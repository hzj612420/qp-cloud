package com.qp.gateway.fiflt;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.annotation.Resource;

import com.qp.common.constants.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 网关鉴权
 */
@Slf4j
@Component
public class AuthFilter implements GlobalFilter, Ordered {
    // 排除过滤的 uri 地址
    // swagger排除自行添加
    private static final String[] whiteList = {"/auth/login", "/auth/clogin", "/user/register"};

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> ops;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getURI().getPath();
        log.info("url:{}", url);
        // 跳过不需要验证的路径
        if (Arrays.asList(whiteList).contains(url)) {
            return chain.filter(exchange);
        }
        if (url.contains("doc")) {
            return chain.filter(exchange);
        }
        String token = exchange.getRequest().getHeaders().getFirst(Constants.TOKEN);
        // token为空
        if (token != null && token.contains(Constants.CLIENT_TOKEN_PIX)) {
            /*return setUnauthorizedResponse(exchange, "token can't null or empty string");*/
            return hallToken(exchange, chain);
        }
        return adminToken(exchange, token, chain);
    }

    private Mono<Void> hallToken(ServerWebExchange exchange, GatewayFilterChain chain) {
        String clientToken = exchange.getRequest().getHeaders().getFirst(Constants.TOKEN);
        String userStr = ops.get(Constants.PLAYER_TOKEN + clientToken);
        if (StringUtils.isBlank(userStr)) {
            return setUnauthorizedResponse(exchange, "token verify error");
        }
        JSONObject jo = JSONObject.parseObject(userStr);
        String playerId = jo.getString("id");
        // 查询token信息
        if (StringUtils.isBlank(playerId)) {
            return setUnauthorizedResponse(exchange, "token verify error");
        }
        // 设置userId到request里，后续根据userId，获取用户信息
        ServerHttpRequest mutableReq = exchange.getRequest().mutate().header(Constants.CLIENT_ID, playerId)
                .header(Constants.CLIENT_USERNAME, jo.getString("loginName")).build();
        ServerWebExchange mutableExchange = exchange.mutate().request(mutableReq).build();
        return chain.filter(mutableExchange);

    }

    private Mono<Void> adminToken(ServerWebExchange exchange, String token, GatewayFilterChain chain) {
        String userStr = ops.get(Constants.ACCESS_TOKEN + token);
        if (StringUtils.isBlank(userStr)) {
            return setUnauthorizedResponse(exchange, "token verify error");
        }
        JSONObject jo = JSONObject.parseObject(userStr);
        String userId = jo.getString("userId");
        // 查询token信息
        if (StringUtils.isBlank(userId)) {
            return setUnauthorizedResponse(exchange, "token verify error");
        }
        // 设置userId到request里，后续根据userId，获取用户信息
        ServerHttpRequest mutableReq = exchange.getRequest().mutate().header(Constants.CURRENT_ID, userId)
                .header(Constants.CURRENT_USERNAME, jo.getString("loginName")).build();
        ServerWebExchange mutableExchange = exchange.mutate().request(mutableReq).build();
        return chain.filter(mutableExchange);
    }

    private Mono<Void> setUnauthorizedResponse(ServerWebExchange exchange, String msg) {
        ServerHttpResponse originalResponse = exchange.getResponse();
        originalResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
        originalResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        byte[] response = null;
        try {
            JSONObject object = new JSONObject();
            object.put("code", 401);
            object.put("msg", msg);
            response = (object.toJSONString()).getBytes(Constants.UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        DataBuffer buffer = originalResponse.bufferFactory().wrap(response);
        return originalResponse.writeWith(Flux.just(buffer));
    }

    @Override
    public int getOrder() {
        return -200;
    }
}
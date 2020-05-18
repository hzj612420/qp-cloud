package com.qp.system.feign.factory;

import com.qp.common.model.ApiResponse;
import com.qp.system.feign.RemoteUserService;
import com.qp.system.model.SysUser;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 用户服务层工厂
 * @author Meixi
 * @date 2020/3/10 21:53
 */
@Slf4j
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {
    @Override
    public RemoteUserService create(Throwable throwable) {
        log.error(throwable.getMessage());
        return new RemoteUserService() {
            @Override
            public ApiResponse<?> updateUserLoginRecord(SysUser user) {
                return new ApiResponse<>().error();
            }

            @Override
            public SysUser selectSysUserByUsername(String username) {
                return null;
            }
        };
    }
}

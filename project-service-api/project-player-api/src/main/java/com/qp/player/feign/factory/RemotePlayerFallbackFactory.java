package com.qp.player.feign.factory;

import com.qp.player.feign.RemotePlayerService;
import com.qp.player.model.Player;
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
public class RemotePlayerFallbackFactory implements FallbackFactory<RemotePlayerService> {
    @Override
    public RemotePlayerService create(Throwable throwable) {
        log.error(throwable.getMessage());
        return new RemotePlayerService() {
            @Override
            public Player selectPlayerByUsername(String username,String site) {
                return null;
            }
            @Override
            public void updatePlayerLoginRecord(Player player) {

            }
        };
    }
}

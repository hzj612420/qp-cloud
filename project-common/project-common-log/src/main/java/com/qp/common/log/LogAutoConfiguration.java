package com.qp.common.log;

import com.qp.common.log.aspect.OperLogAspect;
import com.qp.common.log.listen.LogListener;
import com.qp.system.feign.RemoteLogService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 日志自动配置类
 *
 * @author Meixi
 * @version v1.0.0
 * @date 2020/3/17 15:23 23
 */
@EnableAsync
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration {

    private final RemoteLogService logService;

    @Bean
    public LogListener sysOperLogListener() {
        return new LogListener(logService);
    }

    @Bean
    public OperLogAspect operLogAspect() {
        return new OperLogAspect();
    }
}

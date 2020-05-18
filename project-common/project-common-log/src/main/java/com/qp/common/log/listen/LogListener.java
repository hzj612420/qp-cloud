package com.qp.common.log.listen;

import com.qp.common.log.event.SysLogininforEvent;
import com.qp.common.log.event.SysOperLogEvent;
import com.qp.system.feign.RemoteLogService;
import com.qp.system.model.SysLogininfor;
import com.qp.system.model.SysOperLog;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * 异步监听日志事件
 *
 * @author Meixi
 * @version v1.0.0
 * @date 2020/3/17 14:32 32
 */
@Slf4j
@AllArgsConstructor
public class LogListener {

    private final RemoteLogService remoteLogService;

    @Async
    @Order
    @EventListener(SysOperLogEvent.class)
    public void listenOperLog(SysOperLogEvent event) {
        SysOperLog sysOperLog = (SysOperLog) event.getSource();
        remoteLogService.insertOperlog(sysOperLog);
        log.info("远程操作日志记录成功: {}", sysOperLog);
    }

    @Async
    @Order
    @EventListener(SysLogininforEvent.class)
    public void listenLoginInforLog(SysLogininforEvent event) {
        SysLogininfor sysLogininfor = (SysLogininfor) event.getSource();
        remoteLogService.insertLoginlog(sysLogininfor);
        log.info("远程访问日志记录成功: {}", sysLogininfor);
    }

}

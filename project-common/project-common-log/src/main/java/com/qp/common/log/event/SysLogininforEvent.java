package com.qp.common.log.event;

import com.qp.system.model.SysLogininfor;
import org.springframework.context.ApplicationEvent;


/**
 * 系统登录日志事件
 *
 * @author Meixi
 * @date 2020/3/17 14:30
 */
public class SysLogininforEvent extends ApplicationEvent {
    private static final long serialVersionUID = -9084676463718966036L;

    public SysLogininforEvent(SysLogininfor source) {
        super(source);
    }
}
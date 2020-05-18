package com.qp.system.feign;

import com.qp.common.constants.Constants;
import com.qp.system.feign.factory.RemoteLogFallbackFactory;
import com.qp.system.model.SysLogininfor;
import com.qp.system.model.SysOperLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 日志Feign服务层
 *
 * @author Meixi
 * @date 2020/3/17 14:40
 */
@FeignClient(name = Constants.ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteLogFallbackFactory.class)
public interface RemoteLogService {

    @PostMapping("operLog/save")
    public void insertOperlog(@RequestBody SysOperLog operLog);

    @PostMapping("logininfor/save")
    public void insertLoginlog(@RequestBody SysLogininfor logininfor);
}

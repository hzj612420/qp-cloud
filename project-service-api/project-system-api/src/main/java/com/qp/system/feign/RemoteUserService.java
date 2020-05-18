package com.qp.system.feign;

import com.qp.common.constants.Constants;
import com.qp.common.model.ApiResponse;
import com.qp.system.feign.factory.RemoteUserFallbackFactory;
import com.qp.system.model.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户Feign服务层
 * @author Meixi
 * @date 2020/3/10 21:51
 */
@FeignClient(name = Constants.ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService {

    /**
     * 更新用户信息
     * @param user      用户对象
     * @return ApiResponse<?>
     * @author Meixi
     * @date 2020/3/12 22:17
     */
    @PostMapping("user/update/login")
    public ApiResponse<?> updateUserLoginRecord(@RequestBody SysUser user);

    /**
     * 通过用户名查找用户
     * @param username      用户名
     * @return SysUser
     * @author Meixi
     * @date 2020/3/10 21:59
     */
    @GetMapping("user/find/{username}")
    SysUser selectSysUserByUsername(@PathVariable("username") String username);
}

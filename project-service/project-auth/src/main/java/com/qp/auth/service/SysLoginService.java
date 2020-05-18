package com.qp.auth.service;

import com.qp.system.model.SysUser;

/**
 *系统登录服务层接口
 *
 * @author Meixi
 * @version v1.0.0
 * @date 2020/3/11 15:57 57
 */
public interface SysLoginService {
    /**
     * 用户登录
     * @param username      用户名
     * @param password      密码
     * @return SysUser
     * @author Meixi
     * @date 2020/3/12 22:07
     */
    SysUser login(String username, String password);

    /**
     * 记录用户登录信息
     * @param user      用户对象
     * @author Meixi
     * @date 2020/3/12 22:08
     */
    void recordLoginInfo(SysUser user);

    /**
     * 退出登录
     * @param loginName     用户名
     * @author Meixi
     * @date 2020/3/12 22:09
     */
    void logout(String loginName);
}

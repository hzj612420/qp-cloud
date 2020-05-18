package com.qp.auth.service;


import com.qp.auth.model.resp.TokenResp;
import com.qp.system.model.SysUser;

/**
 * accessToken服务层接口
 *
 * @author Meixi
 * @version v1.0.0
 * @date 2020/3/11 14:58 58
 */
public interface AccessTokenService {

    /**
     * 失效token
     *
     * @param userId 用户id
     * @return void
     * @author Meixi
     * @date 2020/3/13 15:37
     */
    void expireToken(long userId);

    /**
     * 查询token
     *
     * @param token token字符串
     * @return SysUser
     * @author Meixi
     * @date 2020/3/13 15:31
     */
    SysUser queryByToken(String token);

    /**
     * 创建token
     *
     * @param sysUser 用户对象
     * @return TokenResp    token对象
     * @author Meixi
     * @date 2020/3/11 15:32
     */
    TokenResp createToken(SysUser sysUser);
}

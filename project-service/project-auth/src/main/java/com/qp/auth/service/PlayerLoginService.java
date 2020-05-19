package com.qp.auth.service;


import com.qp.auth.model.req.ClientLoginReq;
import com.qp.player.model.Player;

/**
 *系统登录服务层接口
 *
 * @author Meixi
 * @version v1.0.0
 * @date 2020/3/11 15:57 57
 */
public interface PlayerLoginService {
    /**
     * @Author Meixi
     * @Description 代码就是梅西写的
     * @Date 13:53 2020/5/19
     * @Param [cloginReq]
     * @return com.qp.player.model.Player
     **/
    Player login(ClientLoginReq cloginReq);

    /** 
     * 登出 
     * @Author Meixi
     * @Description 代码就是梅西写的
     * @Date 12:27 2020/5/19
     * @Param [player, token]
     * @return void
     **/
    void logout(String player,String token);}

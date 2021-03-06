package com.qp.auth.service.impl;

import com.qp.auth.model.req.ClientLoginReq;
import com.qp.auth.service.PlayerLoginService;
import com.qp.common.constants.Constants;
import com.qp.common.constants.PlayerConstant;
import com.qp.common.constants.UserConstants;
import com.qp.common.exception.BusinessException;
import com.qp.common.log.publish.PublishFactory;
import com.qp.common.utils.IpUtil;
import com.qp.common.utils.MessageUtil;
import com.qp.common.utils.ServletUtil;
import com.qp.player.feign.RemotePlayerService;
import com.qp.player.model.Player;
import com.qp.player.utils.PlayerPasswordUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 系统登录服务层接口实现
 *
 * @author Meixi
 * @version v1.0.0
 * @date 2020/3/11 15:58 58
 */
@Service("playerLoginService")
public class PlayerLoginServiceImpl implements PlayerLoginService {

    @Autowired
    private RemotePlayerService playerService;

    @Override
    public Player login(ClientLoginReq loginReq) {
        String username=loginReq.getUsername();
        String password=loginReq.getPassword();
        if (StringUtils.isAnyBlank(username, password,loginReq.getSite())) {
            // 写入日志 // TODO: 2020/3/17
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtil.message("not.null"));
            throw new BusinessException(MessageUtil.message("player.not.exists"));
        }

        // 密码如果不丰指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            // 写入日志 // TODO: 2020/3/17
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtil.message("player.password.not.match"));
            throw new BusinessException(MessageUtil.message("player.password.not.match"));
        }

        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            // 写入日志 // TODO: 2020/3/17
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtil.message("player.password.not.match"));
            throw new BusinessException(MessageUtil.message("player.password.not.match"));
        }

        // 查询用户信息
        Player player = playerService.selectPlayerByUsername(username,loginReq.getSite());

        // 判断用户是否存在
        if (null == player) {
            // 写入日志 // TODO: 2020/3/17
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtil.message("player.not.exists"));
            throw new BusinessException(MessageUtil.message("player.not.exists"));
        }

        // 判断用户是否停用
        if (PlayerConstant.STATUS_LOCK == player.getStatus()) {
            // 写入日志 // TODO: 2020/3/17
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtil.message("player.blocked", player.getNote()));
            throw new BusinessException(MessageUtil.message("player.blocked"));
        }

        // 密码比较
        if (!PlayerPasswordUtil.matches(player, password)) {
            throw new BusinessException(MessageUtil.message("player.password.not.match"));
        }

        // 写入日志 todo
        PublishFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtil.message("player.login.success"));
        // 记录用户登录信息
        recordLoginInfo(player,loginReq);

        return player;
    }

    public void recordLoginInfo(Player player, ClientLoginReq loginReq) {
        player.setLastLoginIp(IpUtil.getIpAddress(ServletUtil.getRequest()));
        player.setLastLoginTime(new Date());
        player.setLastLoginDeviceType(loginReq.getPlatform());
        player.setLoginTimes(player.getLoginTimes()+1);
        playerService.updatePlayerLoginRecord(player);
    }

    @Override
    public void logout(String loginName,String token) {
        // 写入 日志 // TODO: 2020/3/17
        PublishFactory.recordLogininfor(loginName, Constants.LOGOUT, MessageUtil.message("player.logout.success"));
    }
}

package com.qp.player.feign;

import com.qp.common.constants.Constants;
import com.qp.common.model.ApiResponse;
import com.qp.player.feign.factory.RemotePlayerFallbackFactory;
import com.qp.player.model.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Meixi
 * @Description 代码就是梅西写的
 * @Date 13:02 2020/5/19
 * @Param
 * @return
 **/
@FeignClient(name = Constants.ServiceNameConstants.PLAYER_SERVICE, fallbackFactory = RemotePlayerFallbackFactory.class)
public interface RemotePlayerService {


    /**
     * 通过用户名查找用户
     * @param username      用户名
     * @return SysUser
     * @author Meixi
     * @date 2020/3/10 21:59
     */
    @GetMapping("find")
    public Player selectPlayerByUsername(@RequestParam("username") String username,@RequestParam("site") String site);

    @PostMapping("updateLoginRecord")
    public void updatePlayerLoginRecord(@RequestBody Player player);
}

package com.qp.player.controller;

import com.qp.common.model.ApiResponse;
import com.qp.player.model.Player;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qp.player.service.IPlayerService;

import java.util.List;

/**
 * 玩家 提供者
 *
 * @author Meixi
 * @date 2020-05-18
 */
@Api(tags = "玩家接口")
@RestController
public class PlayerController
{

    @Autowired
    private IPlayerService playerService;

    /**
     * 查询${tableComment}
     */
    @ApiOperation("查询玩家接口")
    @GetMapping("get/{id}")
    public ApiResponse<Player> get(@PathVariable("id") Long id)
    {
        return new ApiResponse<Player>().success(playerService.selectPlayerById(id));

     }

    /**
     * 查询玩家列表
     */
    @ApiOperation("查询玩家列表")
    @GetMapping("list")
    public ApiResponse<List<Player>> list(Player player)
    {

        return new ApiResponse<List<Player>>().success(playerService.selectPlayerList(player));
    }


    /**
     * 新增保存玩家
     */
    @ApiOperation("新增保存玩家")
    @PostMapping("save")
    public ApiResponse<Integer> addSave(@RequestBody Player player)
    {
        return new ApiResponse<Integer>().success(playerService.insertPlayer(player));
    }

    /**
     * 修改保存玩家
     */
    @ApiOperation("修改保存玩家")
    @PostMapping("update")
    public ApiResponse<Integer> editSave(@RequestBody Player player)
    {
        return new ApiResponse<Integer>().success(playerService.updatePlayer(player));
    }

    /**
     * 删除${tableComment}
     */
    @ApiOperation("删除玩家")
    @PostMapping("remove")
    public ApiResponse<Integer> remove(String ids)
    {
        return new ApiResponse<Integer>().success(playerService.deletePlayerByIds(ids));
    }

    @GetMapping("find")
    public Player find( String username, String site)
    {
        System.out.println(username+":"+site);
        return playerService.selectPlayerByUsernameAndSite(username,site);

    }

    @PostMapping("updateLoginRecord")
    public void updatePlayerLoginRecord(@RequestBody Player player){
        playerService.updatePlayerLogin(player);
    }

}

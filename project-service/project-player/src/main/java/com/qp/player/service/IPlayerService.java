package com.qp.player.service;

import com.qp.player.model.Player;
import java.util.List;

/**
 * 玩家Service接口
 *
 * @author Meixi
 * @date 2020-05-18
 */
public interface IPlayerService
{
    /**
     * 查询玩家
     *
     * @param id 玩家ID
     * @return 玩家
     */
    public Player selectPlayerById(Long id);

    /**
     * 查询玩家列表
     *
     * @param player 玩家
     * @return 玩家集合
     */
    public List<Player> selectPlayerList(Player player);

    /**
     * 新增玩家
     *
     * @param player 玩家
     * @return 结果
     */
    public int insertPlayer(Player player);

    /**
     * 修改玩家
     *
     * @param player 玩家
     * @return 结果
     */
    public int updatePlayer(Player player);

    /**
     * 批量删除玩家
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePlayerByIds(String ids);

    /**
     * 删除玩家信息
     *
     * @param id 玩家ID
     * @return 结果
     */
    public int deletePlayerById(Long id);
}

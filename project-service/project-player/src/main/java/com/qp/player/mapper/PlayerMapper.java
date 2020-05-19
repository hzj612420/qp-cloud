package com.qp.player.mapper;

import com.qp.player.model.Player;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 玩家Mapper接口
 *
 * @author Meixi
 * @date 2020-05-18
 */
@Repository("playerMapper")
public interface PlayerMapper
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
     * 删除玩家
     *
     * @param id 玩家ID
     * @return 结果
     */
    public int deletePlayerById(Long id);

    /**
     * 批量删除玩家
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePlayerByIds(String[] ids);

    Player selectPlayerByUsernameAndSite(@Param("username") String username,@Param("site") String site);
}

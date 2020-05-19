package com.qp.player.service.impl;


import com.qp.common.constants.PlayerConstant;
import com.qp.common.core.text.Convert;
import com.qp.common.redis.utils.RedisUtil;
import com.qp.common.utils.DateUtils;
import com.qp.player.mapper.PlayerMapper;
import com.qp.player.model.Player;
import com.qp.player.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 玩家Service业务层处理
 *
 * @author Meixi
 * @date 2020-05-18
 */
@Service("playerService")
public class PlayerServiceImpl implements IPlayerService {
    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 查询玩家
     *
     * @param id 玩家ID
     * @return 玩家
     */
    @Override
    public Player selectPlayerById(Long id) {
        /**
         * 先查缓存有没有这个对象，没有就查数据库并设置缓存
         **/
        Player player = redisUtil.get(PlayerConstant.PLAYER_OBJ + id, Player.class);
        if (player == null) {
            player = playerMapper.selectPlayerById(id);
            redisUtil.set(PlayerConstant.PLAYER_OBJ + id, player, PlayerConstant.EXPIRE);
        }
        return player;
    }

    /**
     * 查询玩家列表
     *
     * @param player 玩家
     * @return 玩家
     */
    @Override
    public List<Player> selectPlayerList(Player player) {
        return playerMapper.selectPlayerList(player);
    }

    /**
     * 新增玩家
     *
     * @param player 玩家
     * @return 结果
     */
    @Override
    public int insertPlayer(Player player) {
        player.setCreateTime(DateUtils.getNowDate());
        return playerMapper.insertPlayer(player);
    }

    /**
     * 修改玩家
     *
     * @param player 玩家
     * @return 结果
     */
    @Override
    public int updatePlayer(Player player) {
        redisUtil.delete(PlayerConstant.PLAYER_OBJ + player.getId());
        player.setUpdateTime(DateUtils.getNowDate());
        return playerMapper.updatePlayer(player);
    }

    /**
     * 删除玩家对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePlayerByIds(String ids) {
        String[] idList = Convert.toStrArray(ids);
        for (String id : idList) {
            redisUtil.delete(PlayerConstant.PLAYER_OBJ + id);
        }
        return playerMapper.deletePlayerByIds(idList);
    }

    /**
     * 删除玩家信息
     *
     * @param id 玩家ID
     * @return 结果
     */
    @Override
    public int deletePlayerById(Long id) {
        redisUtil.delete(PlayerConstant.PLAYER_OBJ + id);
        return playerMapper.deletePlayerById(id);
    }

    @Override
    public Player selectPlayerByUsernameAndSite(String username, String site) {
        return playerMapper.selectPlayerByUsernameAndSite(username,site);
    }

    @Override
    public void updatePlayerLogin(Player player) {
        playerMapper.updatePlayer(player);
    }
}

package com.qp.player.utils;

import com.qp.common.utils.security.Md5Utils;
import com.qp.player.model.Player;

/**
 * 密码加密工具类
 *
 * @author Meixi
 * @date 2020/3/12 22:00
 */
public class PlayerPasswordUtil {

    /**
     * @Author Meixi
     * @Description 代码就是梅西写的 密码比较
     * @Date 13:20 2020/5/19
     * @Param [player, newPassword]
     * @return boolean
     **/
    public static boolean matches(Player player, String newPassword) {
        return player.getPassword().equals(encryptPassword(player.getAccount(), newPassword, player.getSalt()));
    }

    /**
     * 加密
     * @param username      用户名
     * @param password      密码
     * @param salt          盐
     * @return java.lang.String
     * @author Meixi
     * @date 2020/3/12 22:01
     */
    public static String encryptPassword(String username, String password, String salt) {
        return Md5Utils.hash(username + password + salt);
    }

    public static void main(String[] args) {
        String str=encryptPassword("1414","123456","123456");
        System.out.println(str);
    }
}


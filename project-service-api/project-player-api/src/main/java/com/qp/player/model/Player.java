package com.qp.player.model;

import com.qp.common.core.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 玩家对象 player
 *
 * @author Meixi
 * @date 2020-05-18
 */
@ApiModel("玩家对象")
@Data
public class Player implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 玩家ID */
    @ApiModelProperty("玩家ID")
    private Long id;

    /** 昵称 */
    @ApiModelProperty("昵称")
    private String nickName;

    /** 头像 */
    @ApiModelProperty("头像")
    private Long hadIcon;

    /** 性别 */
    @ApiModelProperty("性别")
    private Long sex;

    /** 玩家携带的金币 */
    @ApiModelProperty("玩家携带的金币")
    private Long gold;

    /** Vip等级 */
    @ApiModelProperty("Vip等级")
    private Long vip;

    /** 玩家状态 0 离线, -1 闲置, 1 百人牛牛 2...... */
    @ApiModelProperty("玩家状态 0 离线, -1 闲置, 1 百人牛牛 2......")
    private String isOnline;

    /** 玩家头相框 */
    @ApiModelProperty("玩家头相框")
    private Long headIconFrame;

    /** 昵称修改时的时间 */
    @ApiModelProperty("昵称修改时的时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date nickNameModifyTime;

    /** 保险箱金币 */
    @ApiModelProperty("保险箱金币")
    private Long safeBoxGold;

    /** 保险箱密码 */
    @ApiModelProperty("保险箱密码")
    private String safeBoxPwd;

    /** 密码 */
    @ApiModelProperty("密码")
    private String password;

    /** vip晋级时间 */
    @ApiModelProperty("vip晋级时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date vipAdvanceTime;

    /** 层级 */
    @ApiModelProperty("层级")
    private Long layer;

    /** 已领vip晋级奖励的等级的列表 */
    @ApiModelProperty("已领vip晋级奖励的等级的列表")
    private Long getedUpRewardVipLvSlice;

    /** 最后登录时间 */
    @ApiModelProperty("最后登录时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    /** 最后登录IP */
    @ApiModelProperty("最后登录IP")
    private String lastLoginIp;

    /** 登录来源 lg：设备类型 1 苹果，2 安卓，3 PC */
    @ApiModelProperty("登录来源 lg：设备类型 1 苹果，2 安卓，3 PC")
    private Long lastLoginDeviceType;

    /** 登录天数 */
    @ApiModelProperty("登录天数")
    private Long loginDays;

    /** 登录总次数 */
    @ApiModelProperty("登录总次数")
    private Long loginTimes;

    /** 今日登录次数 */
    @ApiModelProperty("今日登录次数")
    private Long todayLoginTimes;

    /** 在线总时长（秒） */
    @ApiModelProperty("在线总时长")
    private Long onlineTime;

    /** 当天在线时长（秒） */
    @ApiModelProperty("当天在线时长")
    private Long todayOnlineTime;

    /** 首充，true不是，false是 */
    @ApiModelProperty("首充，true不是，false是")
    private Long isFirstPay;

    /** 注册来源 lg：设备类型 1 苹果，2 安卓，3 PC */
    @ApiModelProperty("注册来源 lg：设备类型 1 苹果，2 安卓，3 PC")
    private Long deviceType;

    /** 输钱上线 */
    @ApiModelProperty("输钱上线")
    private Long loseGoldMax;

    /** 输钱警报上线 */
    @ApiModelProperty("输钱警报上线")
    private Long loseAlarmMax;

    /** 赢钱警报上线 */
    @ApiModelProperty("赢钱警报上线")
    private Long winAlarmMax;

    /** 好牌几率 0-100 */
    @ApiModelProperty("好牌几率 0-100")
    private Long goodCardRate;

    /** 绑定设备，暂绑定手机IMEI号即可 */
    @ApiModelProperty("绑定设备，暂绑定手机IMEI号即可")
    private String bindDevice;

    /** 绑定IP */
    @ApiModelProperty("绑定IP")
    private String bindIp;

    /** 允许进入的游戏 */
    @ApiModelProperty("允许进入的游戏")
    private Long openGames;

    /** 最后登出时间 */
    @ApiModelProperty("最后登出时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLogoutTime;

    /** 记录玩家当前所在游戏平台 */
    @ApiModelProperty("记录玩家当前所在游戏平台")
    private Long gamePlatform;

    /** 记录玩家当前所在游戏的类型 */
    @ApiModelProperty("记录玩家当前所在游戏的类型")
    private Long gameType;

    /** 记录玩家当前所在游戏id */
    @ApiModelProperty("记录玩家当前所在游戏id")
    private Long gameId;

    /** 最后领取那天的信息 */
    @ApiModelProperty("最后领取那天的信息")
    private Long dayRewardGetDay;

    /** 最后领取的时间戳 */
    @ApiModelProperty("最后领取的时间戳")
    private Long dayRewardGetTime;

    /** 所属站点 */
    @ApiModelProperty("所属站点")
    private Long siteId;

    /** 电话 */
    @ApiModelProperty("电话")
    private String phone;

    /** 校验码 */
    @ApiModelProperty("校验码")
    private String salt;

    /** 真实姓名 */
    @ApiModelProperty("真实姓名")
    private String realName;

    /** 返点 */
    @ApiModelProperty("返点")
    private Long rebate;

    /** 帐号类型 lg：0正常，1试玩,2代玩 */
    @ApiModelProperty("帐号类型 lg：0正常，1试玩,2代玩")
    private Long accountType;

    /** 状态	lg：0 正常，1 冻结 */
    @ApiModelProperty("状态	lg：0 正常，1 冻结")
    private Long status;

    /** 代理状态	lg：0 正常，1 冻结 */
    @ApiModelProperty("代理状态	lg：0 正常，1 冻结")
    private Long agentStatus;

    /** 账号类型 lg：0 系统会员，1 一级代理，2 二级代理 */
    @ApiModelProperty("账号类型 lg：0 系统会员，1 一级代理，2 二级代理")
    private Long role;

    /** 是否关注 */
    @ApiModelProperty("是否关注")
    private Long isFollow;

    /** 代理邀请码 */
    @ApiModelProperty("代理邀请码")
    private String agentCode;

    /** 帐号	对应自定义帐号 */
    @ApiModelProperty("帐号	对应自定义帐号")
    private String account;

    /** 微信UnionId */
    @ApiModelProperty("微信UnionId")
    private String weiXinUnionId;

    /** 游客UnionId */
    @ApiModelProperty("游客UnionId")
    private String guestUnionId;

    /** 微信OpenId */
    @ApiModelProperty("微信OpenId")
    private String wxOpenId;

    /** 阿里OpenId */
    @ApiModelProperty("阿里OpenId")
    private String aliOpenId;

    /** 注册IP */
    @ApiModelProperty("注册IP")
    private String createIp;

    /** 注册机器码 */
    @ApiModelProperty("注册机器码")
    private String createDeviceCode;

    /** 微信账号 */
    @ApiModelProperty("微信账号")
    private String wxAccount;

    /** 微信昵称 */
    @ApiModelProperty("微信昵称")
    private String wxNickname;

    /** 微信收款码 */
    @ApiModelProperty("微信收款码")
    private String wxCollectionCode;

    /** 支付宝账号 */
    @ApiModelProperty("支付宝账号")
    private String aliAccount;

    /** 支付宝昵称 */
    @ApiModelProperty("支付宝昵称")
    private String aliNickname;

    /** 备注 */
    @ApiModelProperty("备注")
    private String note;

    /** 支付宝收款码 */
    @ApiModelProperty("支付宝收款码")
    private String aliCollectionCode;

    /** 银行卡 */
    @ApiModelProperty("银行卡")
    private String bankcardNo;

    /** 开户行简写 */
    @ApiModelProperty("开户行简写")
    private String bankMark;

    /** 银行用户名 */
    @ApiModelProperty("银行用户名")
    private String bankUsername;

    /** 银行地址 */
    @ApiModelProperty("银行地址")
    private String bankAddress;

    /** QQ帐号 */
    @ApiModelProperty("QQ帐号")
    private String qqAccount;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;
    @ApiModelProperty("站点名称")
    private String site;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("nickName", getNickName())
                .append("hadIcon", getHadIcon())
                .append("sex", getSex())
                .append("gold", getGold())
                .append("vip", getVip())
                .append("isOnline", getIsOnline())
                .append("headIconFrame", getHeadIconFrame())
                .append("nickNameModifyTime", getNickNameModifyTime())
                .append("safeBoxGold", getSafeBoxGold())
                .append("safeBoxPwd", getSafeBoxPwd())
                .append("password", getPassword())
                .append("vipAdvanceTime", getVipAdvanceTime())
                .append("layer", getLayer())
                .append("getedUpRewardVipLvSlice", getGetedUpRewardVipLvSlice())
                .append("lastLoginTime", getLastLoginTime())
                .append("lastLoginIp", getLastLoginIp())
                .append("createTime", getCreateTime())
                .append("lastLoginDeviceType", getLastLoginDeviceType())
                .append("loginDays", getLoginDays())
                .append("loginTimes", getLoginTimes())
                .append("todayLoginTimes", getTodayLoginTimes())
                .append("onlineTime", getOnlineTime())
                .append("todayOnlineTime", getTodayOnlineTime())
                .append("isFirstPay", getIsFirstPay())
                .append("deviceType", getDeviceType())
                .append("loseGoldMax", getLoseGoldMax())
                .append("loseAlarmMax", getLoseAlarmMax())
                .append("winAlarmMax", getWinAlarmMax())
                .append("goodCardRate", getGoodCardRate())
                .append("bindDevice", getBindDevice())
                .append("bindIp", getBindIp())
                .append("openGames", getOpenGames())
                .append("lastLogoutTime", getLastLogoutTime())
                .append("gamePlatform", getGamePlatform())
                .append("gameType", getGameType())
                .append("gameId", getGameId())
                .append("dayRewardGetDay", getDayRewardGetDay())
                .append("dayRewardGetTime", getDayRewardGetTime())
                .append("siteId", getSiteId())
                .append("phone", getPhone())
                .append("salt", getSalt())
                .append("realName", getRealName())
                .append("rebate", getRebate())
                .append("accountType", getAccountType())
                .append("status", getStatus())
                .append("agentStatus", getAgentStatus())
                .append("role", getRole())
                .append("isFollow", getIsFollow())
                .append("agentCode", getAgentCode())
                .append("account", getAccount())
                .append("weiXinUnionId", getWeiXinUnionId())
                .append("guestUnionId", getGuestUnionId())
                .append("wxOpenId", getWxOpenId())
                .append("aliOpenId", getAliOpenId())
                .append("createIp", getCreateIp())
                .append("createDeviceCode", getCreateDeviceCode())
                .append("wxAccount", getWxAccount())
                .append("wxNickname", getWxNickname())
                .append("wxCollectionCode", getWxCollectionCode())
                .append("aliAccount", getAliAccount())
                .append("aliNickname", getAliNickname())
                .append("note", getNote())
                .append("aliCollectionCode", getAliCollectionCode())
                .append("bankcardNo", getBankcardNo())
                .append("bankMark", getBankMark())
                .append("bankUsername", getBankUsername())
                .append("bankAddress", getBankAddress())
                .append("qqAccount", getQqAccount())
                .toString();
    }
}

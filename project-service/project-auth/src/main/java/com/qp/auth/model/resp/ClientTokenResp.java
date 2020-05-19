package com.qp.auth.model.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * token响应对象 @author Meixi @version v1.0.0 @date 2020/3/11 15:26 26
 */
@Data
@ApiModel("token响应对象")
public class ClientTokenResp {
    @ApiModelProperty("玩家账号")
    private long playerId;
    @ApiModelProperty("accessToken 其他请求在头部加上client_token这个字段对应这个token值")
    private String token;
    @ApiModelProperty("玩家账号")
    private String account;
    @ApiModelProperty("游戏类型")
    private long gameType;
    @ApiModelProperty("玩家携带金币")
    private double gold;
    @ApiModelProperty("头像")
    private long headIcon;
    @ApiModelProperty("头像框")
    private long headIconFrame;
    @ApiModelProperty("代理层级")
    private long layer;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("昵称最后修改时间")
    private Date nickNameModifyTime;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("QQ号")
    private String qqAccount;
    @ApiModelProperty("保险箱")
    private double safeBox;
    @ApiModelProperty("性别")
    private Long sex;
    @ApiModelProperty("vip等级")
    private long vipLevel;
    @ApiModelProperty("微信账号")
    private String wxAccount;
}

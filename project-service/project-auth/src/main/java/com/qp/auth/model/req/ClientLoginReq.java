package com.qp.auth.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录请求对象
 *
 * @author Meixi
 * @version v1.0.0
 * @date 2020/3/11 15:51 51
 */
@Data
@ApiModel("客户端登录请求对象")
public class ClientLoginReq {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("站点")
    private String site;

    @ApiModelProperty("设备类型 1 ios，2 android，3 pc")
    private Long platform;

    @ApiModelProperty("版本号")
    private String version;
}

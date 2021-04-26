package com.szz.mall.api.controller.Param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 囧态汗
 * @date 2021/4/21
 * @description MallUserUpdateParam
 */
@Data
public class MallUserUpdateParam implements Serializable {
    @ApiModelProperty("用户昵称")
    private String nickName;
    @ApiModelProperty("用户密码(需要MD5加密)")
    private String passwordMd5;
    @ApiModelProperty("个性签名")
    private String introduceSign;
    @ApiModelProperty("用户头像")
    private String avatar;
}

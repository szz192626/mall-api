package com.szz.mall.api.controller.Param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 囧态汗
 * @date 2021/4/21
 * @description SaveOrderParam
 */
@Data
public class SaveOrderParam implements Serializable {

    @ApiModelProperty("订单项id数组")
    private Long[] cartItemIds;

    @ApiModelProperty("地址id")
    private Long addressId;
}


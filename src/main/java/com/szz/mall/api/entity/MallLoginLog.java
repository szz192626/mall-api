package com.szz.mall.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 囧态汗
 * @date 2021/4/27
 * @description MallLoginLog 商城用户登录信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_mall_login_log")
public class MallLoginLog implements Serializable {

    private static final long serialVersionUID = -3368966771811135485L;
    /**
     * 主键
     */
    @TableId
    private Long logId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 平台
     */
    private String platform;

    /**
     * 访问的API端点
     */
    private String apiUri;

    /**
     * 访问时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}

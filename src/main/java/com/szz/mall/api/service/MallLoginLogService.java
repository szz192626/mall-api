package com.szz.mall.api.service;

import com.szz.mall.api.entity.MallLoginLog;

/**
 * @author 囧态汗
 * @date 2021/4/27
 * @description MallLoginLogService
 */
public interface MallLoginLogService {
    /**
     * 保存登录日志
     *
     * @param mallLoginLog 登录日志
     * @return Boolean
     */
    Boolean saveLog(MallLoginLog mallLoginLog);
}

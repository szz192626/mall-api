package com.szz.mall.api.service.impl;

import com.szz.mall.api.entity.MallLoginLog;
import com.szz.mall.api.mapper.MallLoginLogMapper;
import com.szz.mall.api.service.MallLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 囧态汗
 * @date 2021/4/27
 * @description MallLoginLogServiceImpl
 */
@Service
public class MallLoginLogServiceImpl implements MallLoginLogService {
    @Resource
    private MallLoginLogMapper mallLoginLogMapper;

    @Override
    public Boolean saveLog(MallLoginLog mallLoginLog) {
        return mallLoginLogMapper.insert(mallLoginLog) != 0;
    }
}

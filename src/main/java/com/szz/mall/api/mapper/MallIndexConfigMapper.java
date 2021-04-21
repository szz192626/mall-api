package com.szz.mall.api.mapper;

import com.szz.mall.api.entity.MallIndexConfig;

/**
 * @Entity com.szz.mall.api.entity.MallIndexConfig
 */
public interface MallIndexConfigMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallIndexConfig record);

    int insertSelective(MallIndexConfig record);

    MallIndexConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallIndexConfig record);

    int updateByPrimaryKey(MallIndexConfig record);

}





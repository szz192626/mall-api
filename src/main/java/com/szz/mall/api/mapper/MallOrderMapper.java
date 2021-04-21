package com.szz.mall.api.mapper;

import com.szz.mall.api.entity.MallOrder;

/**
 * @Entity com.szz.mall.api.entity.MallOrder
 */
public interface MallOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallOrder record);

    int insertSelective(MallOrder record);

    MallOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallOrder record);

    int updateByPrimaryKey(MallOrder record);

}





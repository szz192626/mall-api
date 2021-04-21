package com.szz.mall.api.mapper;

import com.szz.mall.api.entity.MallOrderItem;

/**
 * @Entity com.szz.mall.api.entity.MallOrderItem
 */
public interface MallOrderItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallOrderItem record);

    int insertSelective(MallOrderItem record);

    MallOrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallOrderItem record);

    int updateByPrimaryKey(MallOrderItem record);

}





package com.szz.mall.api.mapper;

import com.szz.mall.api.entity.MallOrderAddress;

/**
 * @Entity com.szz.mall.api.entity.MallOrderAddress
 */
public interface MallOrderAddressMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallOrderAddress record);

    int insertSelective(MallOrderAddress record);

    MallOrderAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallOrderAddress record);

    int updateByPrimaryKey(MallOrderAddress record);

}





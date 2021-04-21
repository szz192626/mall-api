package com.szz.mall.api.mapper;

import com.szz.mall.api.entity.MallGoodsInfo;

/**
 * @Entity com.szz.mall.api.entity.MallGoodsInfo
 */
public interface MallGoodsInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallGoodsInfo record);

    int insertSelective(MallGoodsInfo record);

    MallGoodsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallGoodsInfo record);

    int updateByPrimaryKey(MallGoodsInfo record);

}





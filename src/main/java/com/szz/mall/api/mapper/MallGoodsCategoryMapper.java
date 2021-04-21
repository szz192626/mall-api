package com.szz.mall.api.mapper;

import com.szz.mall.api.entity.MallGoodsCategory;

/**
 * @Entity com.szz.mall.api.entity.MallGoodsCategory
 */
public interface MallGoodsCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallGoodsCategory record);

    int insertSelective(MallGoodsCategory record);

    MallGoodsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallGoodsCategory record);

    int updateByPrimaryKey(MallGoodsCategory record);

}





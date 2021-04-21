package com.szz.mall.api.mapper;

import com.szz.mall.api.entity.MallCarousel;

/**
 * @Entity com.szz.mall.api.entity.MallCarousel
 */
public interface MallCarouselMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallCarousel record);

    int insertSelective(MallCarousel record);

    MallCarousel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallCarousel record);

    int updateByPrimaryKey(MallCarousel record);

}





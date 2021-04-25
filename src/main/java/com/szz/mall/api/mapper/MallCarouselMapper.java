package com.szz.mall.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szz.mall.api.entity.MallCarousel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity com.szz.mall.api.entity.MallCarousel
 */
public interface MallCarouselMapper extends BaseMapper<MallCarousel> {

    /**
     * 查询number个轮播图数据
     *
     * @param number 数量
     * @return 轮播图
     */
    List<MallCarousel> findCarouselsByNum(@Param("number") int number);
}




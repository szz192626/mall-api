package com.szz.mall.api.mapper;

import com.szz.mall.api.entity.MallUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MallUserMapperTest {
    @Resource
    private MallUserMapper mallUserMapper;

    @Test
    void selectByPrimaryKey(){
//        MallUser mallUser = mallUserMapper.selectByPrimaryKey(1L);
//        System.out.println(mallUser);
    }
//    @Test
//    void selectAll(){
//        List<MallUser> mallUsers = mallUserMapper.selectAll();
//        System.out.println(mallUsers);
//    }
    @Test
    void selectByLoginName(){
//        MallUser mallUser = mallUserMapper.selectByLoginName("13951905171");
//        log.info("用户信息：" + mallUser);
    }

}
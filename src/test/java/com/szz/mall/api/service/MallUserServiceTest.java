package com.szz.mall.api.service;

import com.szz.mall.api.controller.Param.MallUserUpdateParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MallUserServiceTest {
    @Resource
    private MallUserService mallUserService;

    @Test
    void register() {
        String register = mallUserService.register("13388801111", "123123");
        log.info(register);
        assertEquals("success", register);
    }

    @Test
    void login() {
        String login = mallUserService.login("13388801111", "96e79218965eb72c92a549dd5a330112");
        //返回了登录用户的token，会在tb_mall_user_token表生成一条token记录
        log.info(login);
    }

//    @Test
//    void updateUserInfo() {
//        //修改46号用户信息,可修改的字段为MallUserUpdateParam的属性
//        MallUserUpdateParam mup = new MallUserUpdateParam();
//        mup.setNickName("新昵称");
//        mup.setPasswordMd5("e10adc3949ba59abbe56e057f20f883e");
//        mup.setIntroduceSign("开到荼蘼");
//        Boolean result = mallUserService.updateUserInfo(mup, 46L);
//        log.info(result.toString());
//        assertTrue(result);
//    }

    @Test
    void logout() {
        //会在tb_mall_user_token表中删掉46号用户的一条token数据
        Boolean logout = mallUserService.logout(46L);
        log.info(logout.toString());
        assertTrue(logout);
    }
}
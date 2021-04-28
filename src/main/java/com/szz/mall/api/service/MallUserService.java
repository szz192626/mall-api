package com.szz.mall.api.service;

import com.szz.mall.api.controller.Param.MallUserUpdateParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author 囧态汗
 * @date 2021/4/21
 * @description MallUserService
 */
public interface MallUserService {
    /**
     * 用户注册
     *
     * @param loginName 登录名
     * @param password  密码
     * @return String
     */
    String register(String loginName, String password);


    /**
     * 登录
     *
     * @param loginName   登录名
     * @param passwordMd5 md5加密密码
     * @return String
     */
    Map<String,Object> login(String loginName, String passwordMd5);


    /**
     * 用户信息修改
     *
     * @param mallUser 修改用户的参数实体
     * @param userId   用户id
     * @return boolean
     */
    Boolean updateUserInfo(MallUserUpdateParam mallUser, Long userId);

    /**
     * 退出登录
     *
     * @param userId 用户id
     * @return boolean
     */
    Boolean logout(Long userId);
}

package com.szz.mall.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.szz.mall.api.common.Constants;
import com.szz.mall.api.common.MallException;
import com.szz.mall.api.common.ServiceResultEnum;
import com.szz.mall.api.controller.Param.MallUserUpdateParam;
import com.szz.mall.api.entity.MallUser;
import com.szz.mall.api.entity.MallUserToken;
import com.szz.mall.api.mapper.MallUserMapper;
import com.szz.mall.api.mapper.MallUserTokenMapper;
import com.szz.mall.api.service.MallUserService;
import com.szz.mall.api.util.Md5Util;
import com.szz.mall.api.util.NumberUtil;
import com.szz.mall.api.util.SystemUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 囧态汗
 * @date 2021/4/21
 * @description MallUserServiceImpl
 */
@Service
public class MallUserServiceImpl implements MallUserService {
    @Resource
    private MallUserMapper mallUserMapper;
    @Resource
    private MallUserTokenMapper mallUserTokenMapper;

    @Override
    public String register(String loginName, String password) {
        //根据loginName查询
        Map<String, Object> map = new HashMap<>(4);
        map.put("login_name", loginName);
        List<MallUser> users = mallUserMapper.selectByMap(map);
        if (users.size() != 0) {
            return ServiceResultEnum.SAME_LOGIN_NAME_EXIST.getResult();
        }
        //构建注册用户参数对象
        MallUser registerUser = MallUser.builder()
                .loginName(loginName)
                .nickName(loginName)
                .introduceSign(Constants.USER_INTRO)
                .passwordMd5(Md5Util.encode(password, "UTF-8"))
                .avatar("http://bnnbucket.oss-cn-hangzhou.aliyuncs.com/img-shan/01.jpg")
                .build();
        //调用新增方法，返回受影响的记录行数不为0，则新增成功
        if (mallUserMapper.insert(registerUser) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public Map<String, Object> login(String loginName, String passwordMd5) {
        Map<String, Object> res = new HashMap<>(4);
        //根据loginName和password查询
        Map<String, Object> map = new HashMap<>(4);
        map.put("login_name", loginName);
        map.put("password_md5", passwordMd5);
        List<MallUser> mallUsers = mallUserMapper.selectByMap(map);
        if (mallUsers.size() != 0) {
            //查询到的用户
            MallUser user = mallUsers.get(0);
            System.out.println(user);
            //用户账号被锁定
            if (user.getLockedFlag() == 1) {
                res.put("token", ServiceResultEnum.LOGIN_USER_LOCKED_ERROR.getResult());
                return res;
            }
            //登录后即执行修改token的操作
            String token = getNewToken(System.currentTimeMillis() + "", user.getUserId());
            MallUserToken mallUserToken = mallUserTokenMapper.selectById(user.getUserId());
            //当前时间
            Date now = new Date();
            //过期时间 48 小时
            Date expireTime = new Date(now.getTime() + 2 * 24 * 3600 * 1000);
            if (mallUserToken == null) {
                //新增一条token数据
                mallUserToken = new MallUserToken();
                mallUserToken.setUserId(user.getUserId());
                mallUserToken.setToken(token);
                mallUserToken.setUpdateTime(now);
                mallUserToken.setExpireTime(expireTime);
                if (mallUserTokenMapper.insert(mallUserToken) > 0) {
                    res.put("token", token);
                    res.put("userId", mallUserToken.getUserId());
                    return res;
                }
            } else {
                //更新token
                mallUserToken.setToken(token);
                mallUserToken.setUpdateTime(now);
                mallUserToken.setExpireTime(expireTime);
                if (mallUserTokenMapper.updateById(mallUserToken) > 0) {
                    res.put("token", token);
                    res.put("userId", user.getUserId());
                    return res;
                }
            }
        }
        //登录名或密码错误，返回登录失败的结果
        res.put("msg", ServiceResultEnum.LOGIN_ERROR.getResult());
        return res;
    }

    /**
     * 获取token值
     *
     * @param timeStr 时间
     * @param userId  用户id
     * @return String
     */
    private String getNewToken(String timeStr, Long userId) {
        String src = timeStr + userId + NumberUtil.genRandomNum(4);
        return SystemUtil.genToken(src);
    }

    @Override
    public Boolean updateUserInfo(MallUserUpdateParam mallUser, Long userId) {
        QueryWrapper<MallUser> query = new QueryWrapper<>();
        query.eq("user_id", userId);
        MallUser user = mallUserMapper.selectOne(query);
        System.out.println(user);
        //用户找不到
        if (user == null) {
            MallException.fail(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        //修改相应字段信息
        user.setNickName(mallUser.getNickName());
        user.setPasswordMd5(mallUser.getPasswordMd5());
        user.setIntroduceSign(mallUser.getIntroduceSign());
        user.setAvatar(mallUser.getAvatar());
        return mallUserMapper.update(user, query) > 0;
    }

    @Override
    public Boolean logout(Long userId) {
        return mallUserTokenMapper.deleteById(userId) > 0;
    }
}

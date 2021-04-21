package com.szz.mall.api.mapper;

import com.szz.mall.api.entity.MallUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity com.szz.mall.api.entity.MallUser
 */
public interface MallUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallUser record);

    int insertSelective(MallUser record);

    MallUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallUser record);

    int updateByPrimaryKey(MallUser record);

    List<MallUser> selectAll();

    /**
     * 根据登录名查询用户
     * * @param loginName 登录名
     * * @return 用户对象
     */
    MallUser selectByLoginName(String loginName);

    /**
     * 根据登录名和密码查询用户
     * * @param loginName 登录名
     * * @param password 密码
     * * @return 用户对象
     */
    MallUser selectByLoginNameAndPasswd(@Param("loginName") String loginName, @Param("password") String password);

}





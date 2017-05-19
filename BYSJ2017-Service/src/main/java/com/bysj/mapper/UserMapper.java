package com.bysj.mapper;

import org.apache.ibatis.annotations.Param;

import com.bysj.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //是否有唯一手机号
    int countByPhone(String phone);
    //登录
    int login(@Param("phone") String phone,@Param("password") String password);

	User selectByPhone(String phone);

	int countByName(String name);

    
}
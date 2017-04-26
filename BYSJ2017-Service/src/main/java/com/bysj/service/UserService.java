package com.bysj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bysj.mapper.UserMapper;
import com.bysj.pojo.User;

/**
 *@author  created by licx
 *@data    2017年3月23日---下午1:47:05
 */
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User findUserById(int id){
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}
	
	//用户注册(添加)
	//用户登录（密码匹配）
	//用户注销（session注销，或则cookie操作）
	
	
	
}

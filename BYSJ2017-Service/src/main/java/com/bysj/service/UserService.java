package com.bysj.service;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bysj.mapper.UserMapper;
import com.bysj.pojo.User;

/**
 * @author created by licx
 * @data 2017年3月23日---下午1:47:05
 */
@Service
public class UserService {
	
	private static int i=0;

	@Autowired
	private UserMapper userMapper;

	public User findUserById(int id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	/**
	 * 用户注册(添加)
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean register(User user) throws Exception {
		if(StringUtils.isBlank(user.getUsername())){
			String username="user"+ ++i;
			user.setUsername(username);
		}
		// 插入
		if (userMapper.insert(user) > 0) { // 插入成功
			return true;
		}
		return false;
	}
	/**
	 * 用户登录（密码匹配）
	 * @param phone
	 * @param password
	 * @return
	 */
	public User login(String phone,String password){
		if(userMapper.login(phone, password)>0){
			User user = userMapper.selectByPhone(phone);
			if(user!=null){
				return user;
			}
		}
		return null;
	}
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user) {
		int result = userMapper.updateByPrimaryKeySelective(user);
		if(result > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断用户是否注册 true:为已经注册 false：没有注册
	 * 
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public boolean test(String phone) throws Exception {

		if (userMapper.countByPhone(phone) == 0) { // 该手机号没有注册
			return false;
		}
		return true;
	}
	/**
	 *  判断昵称是否存在  true:为已经存在 false：不存在
	 * @param name
	 * @return
	 */
	public boolean testName(String name) {
		if (userMapper.countByName(name) == 0) { // 改昵称不存在
			return false;
		}
		return true;
	}
	public User selectByPhone(String phone){
		User user = userMapper.selectByPhone(phone);
		return user;
		
	}
	
	// 用户注销（session注销，或则cookie操作）

}

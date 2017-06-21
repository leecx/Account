package com.bysj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bysj.mapper.ShareaccountMapper;
import com.bysj.mapper.UserMapper;
import com.bysj.pojo.Shareaccount;
import com.bysj.pojo.User;
import com.bysj.pojo.result.Result;

/**
 * 关联账户
 *
 * @author created by licx
 * @data 2017年6月3日---下午8:47:34
 */
@Service
public class ShareAccountService {

	@Autowired
	private ShareaccountMapper shareaccountMapper;
	@Autowired
	private UserMapper userMapper;

	// 关联账户
	public Result associated(String phone, User user) {
		Shareaccount shareaccount = new Shareaccount();
		User Auser = userMapper.selectByPhone(phone);
		if (Auser == null) {
			return new Result(404, "关联用户没有注册");
		}
		if (phone.equals(user.getPhone())) {
			return new Result(404, "不能关联自己");
		}
		List<Shareaccount> sas = shareaccountMapper
				.selectByUserId(user.getId());
		for (Shareaccount sa : sas) {
			if (sa.getFriendid() == Auser.getId()) {
				return new Result(404, "该关联用户已存在");
			}
		}
		shareaccount.setUserid(user.getId());
		shareaccount.setFriendid(Auser.getId());
		int insert = shareaccountMapper.insertSelective(shareaccount);
		Shareaccount shareaccountTo = new Shareaccount();
		shareaccountTo.setUserid(Auser.getId());
		shareaccountTo.setFriendid(user.getId());
		int insertTo = shareaccountMapper.insertSelective(shareaccountTo);
		if (insert > 0 && insertTo > 0) {
			return Result.Ok();
		}
		return new Result(404, "插入失败");

	}

	// 查询关联的所有账户
	public Result getAssociated(User user) {
		List<User> users = new ArrayList<User>();
		List<Shareaccount> saList = shareaccountMapper.selectByUserId(user.getId());
		if (saList.size() > 0) {
			for (Shareaccount sa : saList) {
				User Suser = userMapper.selectByPrimaryKey(sa.getFriendid());
				users.add(Suser);
			}
		}
		return new Result(200, "成功", users);
		
	}

	// 取消关联
	public Result deleteAssociated(User user, Integer friendId) {
		Shareaccount shareaccount = new Shareaccount();
		shareaccount.setUserid(user.getId());
		shareaccount.setFriendid(friendId);
		Shareaccount shareaccountTo = new Shareaccount(); // 互相关联对象
		shareaccountTo.setUserid(friendId);
		shareaccountTo.setFriendid(user.getId());
		int del = shareaccountMapper.deleteByShareAccount(shareaccount);
		int delTo = shareaccountMapper.deleteByShareAccount(shareaccountTo);
		if (del > 0 && delTo > 0) {
			return Result.Ok();
		}
		return new Result(404, "失败");
	}

}

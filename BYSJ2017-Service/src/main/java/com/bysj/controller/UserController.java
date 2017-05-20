package com.bysj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bysj.pojo.User;
import com.bysj.pojo.result.Result;
import com.bysj.service.UserService;
import com.bysj.utils.IdentifyCode;
import com.bysj.utils.SendSMS;

/**
 * @author created by licx
 * @data 2017年3月23日---下午1:46:42
 */

@Controller
@RequestMapping("/user")
@RestController
public class UserController {
	
	private static final Logger LOGGER= Logger.getLogger(UserController.class); 

	@Autowired
	private UserService userService;

	// 功能：验证账号是否存在
	@RequestMapping("/testPhone")
	public Result testPhone(String phone, HttpServletResponse response)
			throws Exception {
		LOGGER.info("验证账号是否存在 phone:"+phone);
		if (userService.test(phone)) {
			return new Result(200, "已经注册");
		}
		return new Result(404, "没有注册");
	}
	
	//验证昵称是否重复
	@RequestMapping("/testName")
	public Result testName(String username,HttpServletResponse response){
		LOGGER.info("验证昵称是否重复 Name:"+username);
		if (userService.testName(username)) {
			return new Result(200, "已经存在");
		}
		return new Result(404, "不存在");
	}
	
	// 功能：注册
	@RequestMapping("/register")
	public Result register(User user, HttpServletRequest request, Integer code,
			HttpServletResponse response) throws Exception {
		System.out.println(user.getPassword());
		Integer identifyCode = (Integer) request.getSession().getAttribute("identifyCode");
		if (code == identifyCode) { // 验证码输入正确
			userService.register(user);
			return Result.Ok();
		} else {

		}
		return new Result(400, "失败");
	}

	// 发送验证码
	@RequestMapping("/sendSMS")
	public Result sendSMS(String phone, HttpServletRequest request,
			HttpServletResponse response) {
		if(phone!=null){
			String code = IdentifyCode.getCode();
			if (SendSMS.send(code, phone)) {// 发送短信成功
				request.getSession().setAttribute("identifyCode", code); // 验证码放入session
				return new Result(200, code);
			}
		}
		return new Result(400, "失败");
	}

	// 功能：登陆
	@RequestMapping("/login")
	public Result login(String phone, String password,
			HttpServletResponse response,HttpServletRequest request) {
		User user = userService.login(phone, password);
		System.out.println("登录"+user);
		if(user!=null){
			request.getSession().setAttribute("user", user);
			return Result.Ok();
		}
		return new Result(404, "账号或密码错误！");
	}
	
	// 功能：忘记密码
		@RequestMapping("/setNewPSD")
		public Result setNewPSD(String phone,String password,HttpServletResponse response,HttpServletRequest request){
				//执行修改密码
				User user = userService.selectByPhone(phone);
				if(user!=null){
					user.setPassword(password);
					userService.updateUser(user);
					return Result.Ok();
				}
				return new Result(404, "手机号不存在");
		}

	// 功能：修改密码
	@RequestMapping("/changePSD")
	public Result changePSD(String password,String newPassword,
			HttpServletResponse response,HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		if(user.getPassword()==password){
			//执行修改密码
			user.setPassword(newPassword);
			userService.updateUser(user);
			request.getSession().setAttribute("user", user);
			return Result.Ok();
		}else{
			return new Result(404,"原密码错误！");
		}
	}
	
	//修改个人信息
	@RequestMapping("/update")
	public Result updateUser(User user,HttpServletRequest request,HttpServletResponse response){
		User sessionUser = (User) request.getSession().getAttribute("user");
		String phone = user.getPhone();
		String username = user.getUsername();
		if(StringUtils.isNotBlank(phone)){    //是否为空
			if(userService.selectByPhone(phone)!=null){
				return new Result(404, "手机号已存在");
			}
			sessionUser.setPhone(phone);
			boolean flage = userService.updateUser(sessionUser);
			if(flage){
				request.getSession().setAttribute("user", sessionUser);
				return new Result(200, "修改电话成功！");
			}
		}
		if(StringUtils.isNotBlank(username)){
			if(userService.selectByUsername(username)!=null){
				return new Result(404, "用户名已存在");
			}
			sessionUser.setUsername(username);
			boolean flage = userService.updateUser(sessionUser);
			if(flage){
				request.getSession().setAttribute("user", sessionUser);
				return new Result(200, "修改昵称成功！");
			}
		}
		return new Result(404, "修改失败！");
	}
	
	//登录状态
	@RequestMapping("/loginState")
	public Result loginState(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user);
		if(user!=null){
			return new Result(200, "已登录");
		}
		return new Result(404, "未登录");
		
	}
	
	//退出登录
	@RequestMapping("/loginOut")
	public Result loginOut(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null){
			request.getSession().removeAttribute("user");
			return new Result(200, "退出成功");
		}
		return new Result(404, "未登录");
	}
}

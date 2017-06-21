package com.bysj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bysj.pojo.Shareaccount;
import com.bysj.pojo.User;
import com.bysj.pojo.result.Result;
import com.bysj.service.ShareAccountService;

/**
 *@author  created by licx
 *@data    2017年6月6日---下午5:37:06
 */
@RestController
@RequestMapping("/share")
public class ShareAccountController extends BaseController {
	
	@Autowired
	private ShareAccountService shareAccountService;
	
	/**
	 * 关联账户
	 * @param phone
	 * @param request
	 * @param session
	 * @param code
	 * @return
	 */
	@RequestMapping("/associated")
	public Result associated(String phone,HttpServletRequest request,HttpSession session,String code){
		User user = getSessionUser(session);
		String identifyCode = (String) session.getAttribute("identifyCode");
		if(identifyCode.equals(code)){
			Result associated = shareAccountService.associated(phone, user);
			return associated;
		}else{
			return new Result(404, "验证码错误");
		}
	}
	
	/**
	 * 显示所有的关联账户
	 * @return
	 */
	@RequestMapping("/getAssociated")
	public Result getAssociated(HttpSession session){
		User user = getSessionUser(session);
		Result result = shareAccountService.getAssociated(user);
		return result;
	}
	
	/**
	 * 删除关联用户
	 * @param session
	 * @param friendId
	 * @return
	 */
	@RequestMapping("/deleteAssociated")
	public Result deleteAssociated(HttpSession session,@RequestParam(value="id") Integer friendId){
		User user = getSessionUser(session);
		Result result = shareAccountService.deleteAssociated(user, friendId);
		return result;
	}

}

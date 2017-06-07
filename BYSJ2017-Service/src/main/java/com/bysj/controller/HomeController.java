package com.bysj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bysj.pojo.User;
import com.bysj.pojo.result.BillResult;
import com.bysj.service.HomePageService;

/**
 *@author  created by licx
 *@data    2017年6月4日---下午6:22:16
 */
@RestController
@RequestMapping("/home")
public class HomeController extends BaseController {
	
	@Autowired
	private HomePageService homepageService;
	
	/**
	 * 首页数据显示
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/getHome")
	public BillResult getBillResult(HttpSession session,HttpServletRequest request){
		User user = getSessionUser(session);
		BillResult billResult = null; 
		if(user!=null){
			billResult = homepageService.getBillResult(user);
			billResult.setLogin(true);
			billResult.setCode(200);
		}
		return billResult;
	}
}

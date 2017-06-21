package com.bysj.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import com.bysj.pojo.User;

/**
 *@author  created by licx
 *@data    2017年6月4日---下午6:25:48
 */
public class BaseController {
	
	//获得session中的user
	protected User getSessionUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}
	
}

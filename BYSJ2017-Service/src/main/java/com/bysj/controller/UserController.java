package com.bysj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@author  created by licx
 *@data    2017年3月23日---下午1:46:42
 */

@Controller
public class UserController {
	
	@RequestMapping("/login")
	@ResponseBody
	public Object login(){
		List<String> list = new ArrayList<String>();
		list.add("aaaa");
		list.add("aaaa");
		list.add("aaaa");
		list.add("aaaa");
		return list;
	}
}

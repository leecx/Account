package com.bysj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "asdbc");
		map.put("age", "21");
		map.put("Money", "1000");
		return map;
	}
	
	@RequestMapping("/login1/{name1}/{age}")
	@ResponseBody
	public String login1(@PathVariable("name1") String name,@PathVariable String age, HttpServletRequest request){
		return name+age;
		
	}
}

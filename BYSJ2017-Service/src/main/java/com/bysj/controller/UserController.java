package com.bysj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bysj.pojo.User;
import com.bysj.service.UserService;

/**
 *@author  created by licx
 *@data    2017年3月23日---下午1:46:42
 */

@Controller
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public Object login(HttpServletResponse response){
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "asdbc");
		map.put("age", "21");
		map.put("Money", "1000");
		response.setHeader("Access-Control-Allow-Origin", "*");
		return map;
	}
	
	@RequestMapping("/login1/{name1}/{age}")
	public String login1(@PathVariable("name1") String name,@PathVariable String age, HttpServletRequest request){
		return name+age;
	}
	
	@RequestMapping("/find/{id}")
	public User findUser(@PathVariable("id") int id){
		User user = userService.findUserById(id);
		return user;
	}
	
}

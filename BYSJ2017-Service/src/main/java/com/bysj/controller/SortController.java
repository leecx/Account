package com.bysj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bysj.mapper.SortMapper;
import com.bysj.pojo.Sort;
import com.bysj.pojo.result.Result;

/**
 *@author  created by licx
 *@data    2017年6月1日---下午4:50:19
 */
@Controller
@RestController
@RequestMapping("sort")
public class SortController {
	
	@Autowired
	private SortMapper sortMapper;
	
	@RequestMapping("/addSort")
	public Result addSort(Sort sort){
		sortMapper.insertSelective(sort);
		return Result.Ok();
	}

}

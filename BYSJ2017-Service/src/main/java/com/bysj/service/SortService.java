package com.bysj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bysj.mapper.SortMapper;
import com.bysj.pojo.Sort;

/**
 *@author  created by licx
 *@data    2017年6月1日---下午4:59:20
 */
@Service
public class SortService {

	@Autowired
	private SortMapper sortMapper;
	
	//查询类别id
	public int findIdByName(String name){
		Sort sort = sortMapper.selectByName(name);
		return sort.getId();
	}
}

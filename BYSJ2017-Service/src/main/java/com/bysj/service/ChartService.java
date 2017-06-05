package com.bysj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bysj.mapper.BillMapper;
import com.bysj.pojo.Bill;
import com.bysj.pojo.User;
import com.bysj.pojo.example.BillEx;

/**
 *图表服务 
 *@author  created by licx
 *@data    2017年6月5日---下午10:19:22
 */
@Service
public class ChartService {
	
	@Autowired
	private BillMapper billMapper;
	
	
	//柱状图
	public Map<String, String[]> getBarData(BillEx billEx,User user){
		Map<String, String[]> map = new HashMap<String, String[]>();
		String[] data = null;
		String[] value = null;
		
		List<Bill> bills = billMapper.selectByEx(billEx);
		
		return map;
	}
	
	//饼状图
	
	

}

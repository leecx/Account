package com.bysj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bysj.mapper.ShareaccountMapper;
/**
 *@author  created by licx
 *@data    2017年6月3日---下午8:47:34
 */
@Service
public class ShareAccountService {
	
	@Autowired
	private ShareaccountMapper shareaccountMapper;
	
}

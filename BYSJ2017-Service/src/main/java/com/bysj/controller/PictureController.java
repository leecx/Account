package com.bysj.controller;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bysj.pojo.result.PictureResult;
import com.bysj.service.PictureService;
import com.bysj.utils.JsonUtils;

/**
 *@author  created by licx
 *@data    2017年5月17日---下午6:43:00
 */

@Controller
@RestController
@RequestMapping("/pic")
public class PictureController {
	
	@Autowired
	private PictureService pictureService;
	
	
	@RequestMapping("/upload")
	public String upload(MultipartFile uploadFile) throws Exception {
		
		Map result = pictureService.uploadPicture(uploadFile);
		//为了保证功能的兼容性，需要把Result转换成json格式的字符串。
		String json = JsonUtils.objectToJson(result);
		return json;
	}
}

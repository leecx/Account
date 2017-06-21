package com.bysj.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bysj.pojo.User;
import com.bysj.pojo.result.PictureResult;
import com.bysj.pojo.result.Result;
import com.bysj.service.PictureService;
import com.bysj.service.UserService;
import com.bysj.utils.JsonUtils;
import com.bysj.utils.PicUtil;

/**
 *@author  created by licx
 *@data    2017年5月17日---下午6:43:00
 */

@Controller
@RestController
@RequestMapping("/pic")
public class PictureController extends BaseController{
	
	@Autowired
	private PictureService pictureService;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/upload")
	public String upload(String uploadFile,HttpSession session) throws Exception {
		System.out.println(uploadFile);
		File file = PicUtil.GenerateImage(uploadFile);	//生产图片  
		User Suser = getSessionUser(session);
		Map result = pictureService.uploadPicture(file);
		if(result.get("code").equals(200)){
			Suser.setIcon((String) result.get("url"));
			boolean updateUser = userService.updateUser(Suser);
			if(!updateUser){
				return JsonUtils.objectToJson(new Result(404, "失败"));
			}
			session.setAttribute("user", Suser);
		}
		//为了保证功能的兼容性，需要把Result转换成json格式的字符串。
		String json = JsonUtils.objectToJson(result);
		return json;
	}
}

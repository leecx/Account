package com.bysj.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bysj.utils.FtpUtil;

/**
 *@author  created by licx
 *@data    2017年5月17日---下午6:44:02
 */
@Service
public class PictureService {
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	public Map uploadPicture(File file) {
		Map resultMap = new HashMap<>();
		try {
			//生成一个新的文件名
			//取原始文件名
			String oldName = file.getName();
			System.out.println(oldName);
			//生成新文件名
			//UUID.randomUUID();
			//String newName = IDUtils.genImageName();
			//String newName = UUID.randomUUID().toString();
			
			//图片上传
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, 
					FTP_BASE_PATH, imagePath, oldName, new FileInputStream(file));
			//返回结果
			if(!result) {
				resultMap.put("code", 404);
				resultMap.put("message", "文件上传失败");
				return resultMap;
			}
			resultMap.put("code", 200);
			resultMap.put("url", IMAGE_BASE_URL + imagePath + "/" + oldName);
			System.out.println(IMAGE_BASE_URL + imagePath + "/" + oldName);
			//file.delete(); //上传成功则删除文件
			return resultMap;
			
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("code", 404);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		}
		
	}
}

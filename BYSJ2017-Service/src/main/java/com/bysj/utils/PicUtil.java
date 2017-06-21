package com.bysj.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author created by licx
 * @data 2017年6月13日---下午8:57:43
 */
public class PicUtil {

	public static void main(String[] args) {
		String url = "data:image/png;base64,iVBORw0KyWAAI=";
		int indexOf = url.indexOf(",");
		String image = url.substring(url.indexOf("/")+1, url.indexOf(";"));
		String data = url.substring(indexOf+1, url.length());
		
		System.out.println(GenerateImage(url));
	}

	// base64字符串转化成图片   "data:image/png;base64,iVBORw0KyWAAI=";
	public static File GenerateImage(String imgStr) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null){ // 图像数据为空
			return null;}
		int indexOf = imgStr.indexOf(",");
		String image = imgStr.substring(imgStr.indexOf("/")+1, imgStr.indexOf(";"));
		String data = imgStr.substring(indexOf+1, imgStr.length());
		
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(data);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成图片
			String imgName = UUID.randomUUID().toString();
			String imgFilePath = imgName+"."+image;// 新生成的图片
			OutputStream out = new FileOutputStream("/IMAGE/"+imgFilePath);
			out.write(b);
			out.flush();
			out.close();

			File file = new File("/IMAGE/"+imgFilePath);
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

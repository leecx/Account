package com.bysj.utils;

import java.util.Random;

/**
 *@author  created by licx
 *@data    2017年5月16日---下午12:32:47
 */
public class IdentifyCode {
	
	/**
	 * 生成验证码
	 * @return
	 */
	public static String getCode(){
		Random random = new Random();
		byte[] rand = new byte[4];
		String code = "";
		for(int i=0;i<4;i++){
			rand[i] = (byte) random.nextInt(10);
			code +=rand[i];
		}
		return code;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getCode());
	}
	
}

package com.bysj.pojo.result;

import java.util.List;

/**
 * 同一返回返回结果
 *@author  created by licx
 *@data    2017年5月16日---下午1:17:06
 */
public class Result {
	
	private int code;
	
	private String message;
	
	
	public Result(){}
	
	public Result(int code,String message){
		this.code = code;
		this.message = message;
	}
	
	
	public static Result Ok(){
		return new Result(200, "OK");
	}
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}

package com.bysj.pojo.result;

import java.util.List;

/**
 *@author  created by licx
 *@data    2017年6月13日---下午7:28:29
 */
public class BillDetails {
	
	private String time; 	//具体天
	private List<Content> contents;  //具体天内容
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<Content> getContents() {
		return contents;
	}
	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	
	
	
	
	//text,member,id,isshow

}

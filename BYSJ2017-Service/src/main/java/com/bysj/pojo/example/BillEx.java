package com.bysj.pojo.example;

import java.util.Date;

/**
 *@author  created by licx
 *@data    2017年6月6日---上午12:46:00
 */
public class BillEx {
	
	private Integer userId;			//用户id
	private Date startDay;			//开始时间
	private Date endDay;			//结束时间
	private String member;			//成员
	private String type;			//类型
	private String typeName;		//类型名称
	
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public Date getEndDay() {
		return endDay;
	}
	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	

}

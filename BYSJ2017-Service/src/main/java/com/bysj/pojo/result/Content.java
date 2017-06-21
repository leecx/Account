package com.bysj.pojo.result;
/**
 *@author  created by licx
 *@data    2017年6月13日---下午10:06:36
 */
public class Content {
	
	private String text;		//记录内容  午餐支出20元
	private String member;		//成员
	private int id;				//
	private boolean isShow;		//是否能删除
	private String remark;      //备注
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isShow() {
		return isShow;
	} 
	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

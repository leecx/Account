package com.bysj.account.model;

import java.util.Date;

public class Bill {
	
	private int bIcon;
	private String bName;
	private double bMoney;
	private Date bDate;
	
	
	public Bill() {
		super();
	}
	public Bill(int bIcon, String bName, double bMoney, Date bDate) {
		super();
		this.bIcon = bIcon;
		this.bName = bName;
		this.bMoney = bMoney;
		this.bDate = bDate;
	}
	public int getbIcon() {
		return bIcon;
	}
	public void setbIcon(int bIcon) {
		this.bIcon = bIcon;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public double getbMoney() {
		return bMoney;
	}
	public void setbMoney(double bMoney) {
		this.bMoney = bMoney;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	
	

}

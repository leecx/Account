package com.bysj.pojo.result;
/**
 * 
 * 小预算
 *@author  created by licx
 *@data    2017年6月5日---下午4:52:40
 */
public class BudgetDetail {
	
	private String name;  	//名字
	private Double budget;	//预算
	private Double percent;	//百分比
	private Double balance;	//花费
	private String img;		//图片
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		if(percent<=0){
			this.percent = 0.0;
		}else{
			this.percent = percent;
		}
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}

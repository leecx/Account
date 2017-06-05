package com.bysj.pojo.result;
/**
 * 首页数据
 *@author  created by licx
 *@data    2017年5月21日---下午10:32:14
 */
public class BillResult {
	private boolean isLogin;    //是否登录
	private int nowDay;			//当前日
	private int nowMonth;		//当前月
	private int nowYear;		//当前年
	private String nowWeek;		//当前星期
	private String username;	//昵称
	private Double nowMonthIncome;	//当月收入
	private Double nowMonthPay;		//当月支出
	private Double budgetBalance;	//预算余额
	private boolean isRecordText;	//今天是否记账
	private Double nowDayIncome;	//今天收入
	private Double nowDayPay;	   //今天支出
	private String weekRegion;		//这周区间
	private Double nowWeekIncome;	//本周收入
	private Double nowWeekPay;		//本周支出
	private String monthRegion;		//本月区间
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public int getNowDay() {
		return nowDay;
	}
	public void setNowDay(int nowDay) {
		this.nowDay = nowDay;
	}
	public int getNowMonth() {
		return nowMonth;
	}
	public void setNowMonth(int nowMonth) {
		this.nowMonth = nowMonth;
	}
	public int getNowYear() {
		return nowYear;
	}
	public void setNowYear(int nowYear) {
		this.nowYear = nowYear;
	}
	public String getNowWeek() {
		return nowWeek;
	}
	public void setNowWeek(String nowWeek) {
		this.nowWeek = nowWeek;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getNowMonthIncome() {
		return nowMonthIncome;
	}
	public void setNowMonthIncome(Double nowMonthIncome) {
		this.nowMonthIncome = nowMonthIncome;
	}
	public Double getNowMonthPay() {
		return nowMonthPay;
	}
	public void setNowMonthPay(Double nowMonthPay) {
		this.nowMonthPay = nowMonthPay;
	}
	public Double getBudgetBalance() {
		return budgetBalance;
	}
	public void setBudgetBalance(Double budgetBalance) {
		this.budgetBalance = budgetBalance;
	}
	public boolean isRecordText() {
		return isRecordText;
	}
	public void setRecordText(boolean isRecordText) {
		this.isRecordText = isRecordText;
	}
	public Double getNowDayIncome() {
		return nowDayIncome;
	}
	public void setNowDayIncome(Double nowDayIncome) {
		this.nowDayIncome = nowDayIncome;
	}
	public Double getNowDayPay() {
		return nowDayPay;
	}
	public void setNowDayPay(Double nowDayPay) {
		this.nowDayPay = nowDayPay;
	}
	public String getWeekRegion() {
		return weekRegion;
	}
	public void setWeekRegion(String weekRegion) {
		this.weekRegion = weekRegion;
	}
	public Double getNowWeekIncome() {
		return nowWeekIncome;
	}
	public void setNowWeekIncome(Double nowWeekIncome) {
		this.nowWeekIncome = nowWeekIncome;
	}
	public Double getNowWeekPay() {
		return nowWeekPay;
	}
	public void setNowWeekPay(Double nowWeekPay) {
		this.nowWeekPay = nowWeekPay;
	}
	public String getMonthRegion() {
		return monthRegion;
	}
	public void setMonthRegion(String monthRegion) {
		this.monthRegion = monthRegion;
	}
}

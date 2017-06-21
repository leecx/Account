package com.bysj.service;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bysj.mapper.BillMapper;
import com.bysj.mapper.BudgetMapper;
import com.bysj.pojo.Budget;
import com.bysj.pojo.User;
import com.bysj.pojo.result.BillResult;
import com.bysj.utils.DateUtil;

/**
 * @author created by licx
 * @data 2017年6月4日---下午3:42:37
 */
@Service
public class HomePageService {
	
	@Autowired
	private BillMapper billMapper;
	@Autowired
	private BudgetMapper budgetMapper;
	
	/**
	 * 首页显示
	 * @param user
	 * @return
	 */
	public BillResult getBillResult(User user) {

		BillResult billResult = new BillResult();
		Date date = new Date();
		DateTime dateTime = new DateTime(date.getTime());
		billResult.setNowYear(dateTime.getYear());       	//年
		billResult.setNowMonth(dateTime.getMonthOfYear());	//月
		billResult.setNowDay(dateTime.getDayOfMonth());  	 //日

		String nowWeek = getWeek(dateTime);
		billResult.setNowWeek(nowWeek);                		//周
		billResult.setUsername(user.getUsername());			//名字
		int userId = user.getId();
		billResult.setNowDayIncome(billMapper.selectIncomeByday(userId, date));  //今日收入
		billResult.setNowDayPay(billMapper.selectPayByday(userId, date));	 //今日支出
		if(billResult.getNowDayIncome()>0||billResult.getNowDayPay()>0){		//是否记账
			billResult.setRecordText(true);
		}else{
			billResult.setRecordText(false);
		}
		
		Date  firstDayOfWeek= dateTime.withDayOfWeek(DateTimeConstants.MONDAY).toDate();
		Date lastDayOfWeek = dateTime.withDayOfWeek(DateTimeConstants.SUNDAY).toDate();
		Double WeekIncome = billMapper.selectIncomeByDayRegion(userId,firstDayOfWeek,lastDayOfWeek);
		Double WeekPay = billMapper.selectPayByDayRegion(userId,firstDayOfWeek,lastDayOfWeek);
		billResult.setNowWeekIncome(WeekIncome);				  	//本周收入
		billResult.setNowWeekPay(WeekPay);						 	 //本周支出
		billResult.setWeekRegion(DateUtil.getWeekRegion(date));   	//当前周区间
		
		Date lastDayOfMonth = dateTime.withDayOfMonth(dateTime.dayOfMonth().getMaximumValue()).toDate();
		Date firstDayOfMonth = dateTime.withDayOfMonth(1).toDate();
		Double monthIncome = billMapper.selectIncomeByDayRegion(userId, firstDayOfMonth, lastDayOfMonth);
		Double monthPay = billMapper.selectPayByDayRegion(userId, firstDayOfMonth, lastDayOfMonth);
		billResult.setNowMonthIncome(monthIncome);					  //本月收入
		billResult.setNowMonthPay(monthPay);						  //本月支出
		billResult.setMonthRegion(DateUtil.getMonthInterval(date));   //本月区间
		
		Double budgets = budgetMapper.sumBudget(userId, dateTime.getMonthOfYear(), dateTime.getYear()); //本月预算
		if(monthPay==null){
			monthPay = 0.0;
		}
		if(budgets==null){
			budgets=0.0;
		}
		Double budgetBalance = budgets - monthPay;                                      //本月预算余额
		billResult.setBudgetBalance(budgetBalance);
		
		return billResult;
	}
	
	
	private String getWeek(DateTime dateTime) {
		int dayOfWeek = dateTime.getDayOfWeek();
		String nowWeekDay = null;
		switch (dayOfWeek) {
		case 1:
			nowWeekDay = "星期一";
			break;
		case 2:
			nowWeekDay = "星期二";
			break;
		case 3:
			nowWeekDay = "星期三";
			break;	
		case 4:
			nowWeekDay = "星期四";
			break;
		case 5:
			nowWeekDay = "星期五";
			break;
		case 6:
			nowWeekDay = "星期六";
			break;
		case 7:
			nowWeekDay = "星期日";
			break;
		default:
			break;
		}
		return nowWeekDay;
	}

}

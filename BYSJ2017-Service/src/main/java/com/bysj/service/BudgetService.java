package com.bysj.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bysj.mapper.BillMapper;
import com.bysj.mapper.BudgetMapper;
import com.bysj.mapper.SortMapper;
import com.bysj.pojo.Budget;
import com.bysj.pojo.Sort;
import com.bysj.pojo.User;
import com.bysj.pojo.result.BudgetDetail;
import com.bysj.pojo.result.BudgetDetailResult;

/**
 * @author created by licx
 * @data 2017年6月3日---下午8:13:59
 */
@Service
public class BudgetService {

	@Autowired
	private BudgetMapper budgetMapper;
	@Autowired
	private BillMapper billMapper;
	@Autowired
	private SortMapper sortMapper;

	/**
	 * 添加预算，如果已经存在则修改
	 * @param budget
	 * @return
	 */
	public boolean addBudget(Budget budget) {
		int userId = budget.getUserid();
		int month = budget.getMonth();
		int typeId = budget.getTypeId();
		Budget budgetEx = new Budget();
		budgetEx.setUserid(userId);
		budgetEx.setMonth(month);
		budgetEx.setTypeId(typeId);
		Budget selectByEx = budgetMapper.selectByEx(budgetEx);
		int result = 0;
		if (selectByEx != null) {
			budget.setId(selectByEx.getId());
			result = budgetMapper.updateByPrimaryKeySelective(budget); // 已存在则修改
		} else {
			result = budgetMapper.insertSelective(budget); // 直接插入
		}
		if (result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 显示预算页面数据,更具月份
	 * 
	 * @return
	 */
	public BudgetDetailResult showBudgets(User user,int month,int year) {
		BudgetDetailResult budgetDetailResult = new BudgetDetailResult();
		int userId = user.getId();
		DateTime dateTime = new DateTime().withYear(year).withMonthOfYear(month);
		// 当月总预算
		Double budgets = budgetMapper.sumBudget(userId,dateTime.getMonthOfYear(),dateTime.getYear());
		if(budgets==null){
			budgets=0.0;
		}
		// 当月已用
		Date startDay = dateTime.withDayOfMonth(1).toDate();
		Date endDay = dateTime.withDayOfMonth(dateTime.dayOfMonth().getMaximumValue()).toDate();
		Double use = billMapper.selectPayByDayRegion(userId,startDay,endDay);
		if(use==null){
			use=0.0;
		}
		//当月剩余
		Double unUse = budgets - use;
		
		
		//当月预算详情
		List<BudgetDetail> details = new ArrayList<BudgetDetail>();
		
		List<Budget> budgetList = budgetMapper.selectByMonth(userId,dateTime.getMonthOfYear(),dateTime.getYear());
		for(Budget budget :budgetList){
			BudgetDetail budgetDetail = new BudgetDetail();
			Sort sort = sortMapper.selectByPrimaryKey(budget.getTypeId());
			Double MonthPayByType = billMapper.selectMonthPayByTypeId(budget.getTypeId(), userId, startDay, endDay);
			if(MonthPayByType==null){
				MonthPayByType=0.0;
			}
			Double balance = budget.getNum() - MonthPayByType;
			Double percent = (balance/budget.getNum())*100;
			budgetDetail.setName(sort.getName());   						//名字
			budgetDetail.setBalance(balance);								//余额
			budgetDetail.setBudget(budget.getNum());						//预算
			budgetDetail.setImg(sort.getImg());								//图片
			budgetDetail.setPercent(percent);								//百分比  可用的/总共的
			details.add(budgetDetail);
		}
		budgetDetailResult.setUse(use);
		budgetDetailResult.setBudgets(budgets);
		budgetDetailResult.setUnUse(unUse);
		budgetDetailResult.setBudgetDetails(details);
		//如果为空，则返回所有预算为0返回
		if(budgetDetailResult.getBudgetDetails().size()==0){
			List<Sort> sorts = sortMapper.selectSortsOfPay();
			for(Sort sort:sorts){
				BudgetDetail budgetDetail = new BudgetDetail();
				budgetDetail.setBalance(0.0);
				budgetDetail.setBudget(0.0);
				budgetDetail.setImg(sort.getImg());
				budgetDetail.setName(sort.getName());
				budgetDetail.setPercent(0.0);
				details.add(budgetDetail);
			}
			budgetDetailResult.setBudgetDetails(details);
		}
		return budgetDetailResult;
	}
}

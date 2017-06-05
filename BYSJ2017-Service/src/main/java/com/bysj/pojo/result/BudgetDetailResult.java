package com.bysj.pojo.result;

import java.util.List;

/**
 * 返回页面数据类型
 * 显示预算
 *@author  created by licx
 *@data    2017年6月5日---下午4:49:57
 */
public class BudgetDetailResult {
	
	private int code;
	private Double budgets;   //当月总预算
	private Double use;       //当月已用
	private Double unUse;	//未用
	
	private List<BudgetDetail> budgetDetails;

	public Double getBudgets() {
		return budgets;
	}

	public void setBudgets(Double budgets) {
		this.budgets = budgets;
	}

	public Double getUse() {
		return use;
	}

	public void setUse(Double use) {
		this.use = use;
	}

	public Double getUnUse() {
		return unUse;
	}

	public void setUnUse(Double unUse) {
		this.unUse = unUse;
	}

	public List<BudgetDetail> getBudgetDetails() {
		return budgetDetails;
	}

	public void setBudgetDetails(List<BudgetDetail> budgetDetails) {
		this.budgetDetails = budgetDetails;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	

}


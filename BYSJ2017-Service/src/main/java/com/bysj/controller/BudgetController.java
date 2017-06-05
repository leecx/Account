package com.bysj.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bysj.mapper.SortMapper;
import com.bysj.pojo.Budget;
import com.bysj.pojo.User;
import com.bysj.pojo.result.BudgetDetailResult;
import com.bysj.pojo.result.Result;
import com.bysj.service.BudgetService;
import com.bysj.service.SortService;

/**
 * @author created by licx
 * @data 2017年6月2日---上午12:49:55
 */
@Controller
@RestController
@RequestMapping("/budget")
public class BudgetController extends BaseController {

	@Autowired
	private BudgetService budgetService;
	@Autowired
	private SortService sortService;
	
	/**
	 * 添加预算
	 * @param request
	 * @param budget
	 * @param session
	 * @param typeName
	 * @return
	 */
	@RequestMapping("/addBudget")
	public Result addBudget(HttpServletRequest request, Budget budget,
			HttpSession session, String typeName) {
		
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return Result.notLogin();
		}
		budget.setUserid(user.getId()); // 设置用户id
		int typeId = sortService.findIdByName(typeName);
		budget.setTypeId(typeId);          //设置类型id
		boolean addBudget = budgetService.addBudget(budget);
		if (addBudget) {
			return Result.Ok();
		}
		return new Result(404, "添加失败");
	}
	
	/**
	 * 获得月份对应的的预算
	 * @param request
	 * @param session
	 * @param month
	 * @return
	 */
	@RequestMapping("/getBudgets")
	public BudgetDetailResult getBudgets(HttpServletRequest request,HttpSession session,int month,int year){
		User user = getSessionUser(session);
		BudgetDetailResult budgetDetailResult = budgetService.showBudgets(user,month,year);
		if(budgetDetailResult!=null){
			budgetDetailResult.setCode(200);
		}else{
			budgetDetailResult.setCode(404);;
		}
		return budgetDetailResult;
		
	}

}

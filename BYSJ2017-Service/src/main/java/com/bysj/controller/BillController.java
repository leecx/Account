package com.bysj.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bysj.pojo.Bill;
import com.bysj.pojo.User;
import com.bysj.pojo.example.BillEx;
import com.bysj.pojo.result.Result;
import com.bysj.service.BillService;
import com.bysj.service.ChartService;
import com.bysj.service.SortService;

/**
 *@author  created by licx
 *@data    2017年5月22日---上午12:53:42
 */
@Controller
@RestController
@RequestMapping("/bill")
public class BillController extends BaseController {
	
	@Autowired
	private BillService billService;
	@Autowired
	private SortService sortService;
	@Autowired
	private ChartService chartService;
	
	@RequestMapping("/test")
	public void test(Bill bill){
		System.out.println(bill.getTime());
	}
	
	/**
	 * 添加账单
	 * @param request
	 * @param bill
	 * @param session
	 * @param typeName
	 * @return
	 */
	@RequestMapping("/addBill")
	public Result addBill(HttpServletRequest request,Bill bill,HttpSession session,String typeName){
		User user = (User) session.getAttribute("user");
		if(user == null){
			return new Result(404,"没有登录");
		}
		bill.setUserid(user.getId());  //设置用户id
		
		String type = bill.getType(); //设置账务类型
		if(type.equals("收入")){
			bill.setType("0");
		}else if(type.equals("支出")){
			bill.setType("1");
		}
		
		int typeId = sortService.findIdByName(typeName);
		bill.setTypeid(typeId);            //设置类型
		
		boolean flag = billService.addBill(bill);
		if(flag){
			return Result.Ok();
		}
		return new Result(404, "添加失败");
	}
	
	/**
	 * 柱状图
	 * @param request
	 * @param session
	 * @param billEx
	 * @return
	 */
	@RequestMapping("/getBarData")
	public Map getBarData(HttpServletRequest request,HttpSession session,BillEx billEx){
		User user = getSessionUser(session);
		billEx.setUserId(user.getId());
		Map map = chartService.getBarData(billEx,user);
		if(!map.isEmpty()){
			map.put("code", 200);
		}else{
			map.put("code", 404);
		}
		return map;
	}
	
	/**
	 * 饼状图
	 * @param request
	 * @param session
	 * @param billEx
	 * @return
	 */
	@RequestMapping("/getPieData")
	public Map getPieData(HttpServletRequest request,HttpSession session,BillEx billEx){
		User user = getSessionUser(session);
		Map map = new HashMap();
		billEx.setUserId(user.getId());
		List<Map> pieData = chartService.getPieData(billEx);
		if(!pieData.isEmpty()){
			map.put("data", pieData);
			map.put("code", 200);
		}else{
			map.put("code", 404);
		}
		return map;
		
	}
}

package com.bysj.service;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bysj.mapper.BillMapper;
import com.bysj.mapper.BudgetMapper;
import com.bysj.mapper.SortMapper;
import com.bysj.pojo.Bill;
import com.bysj.pojo.Budget;
import com.bysj.pojo.Sort;
import com.bysj.pojo.User;
import com.bysj.pojo.example.BillEx;

/**
 *@author  created by licx
 *@data    2017年4月26日---下午5:12:04
 */
@Service
public class BillService {

	@Autowired
	private BillMapper billMapper;
	@Autowired
	private BudgetMapper budgetMapper;
	@Autowired
	private SortMapper sortMapper;
	
	//记一笔
	public boolean addBill(Bill bill){
		int insert = billMapper.insertSelective(bill);
		
		if(bill.getType().equals("1")){
			int userId = bill.getUserid();
			int typeId = bill.getTypeid();
			Sort sort = sortMapper.selectByPrimaryKey(typeId);
			if(sort.getParentid()!=null){
				typeId = sort.getParentid();
			}
			DateTime dateTime = new DateTime(bill.getTime().getTime());
			int count = budgetMapper.selectCountByTypeId(userId, dateTime.getMonthOfYear(), dateTime.getYear(),typeId);
			if(count==0){
				Budget budget = new Budget();
				budget.setMonth(dateTime.getMonthOfYear());
				budget.setYear(dateTime.getYear());
				budget.setNum(0.0);
				budget.setTypeId(typeId);
				budget.setUserid(userId);
				budgetMapper.insertSelective(budget);
			}
		}
		if(insert > 0){
			return true;
		}
		return false;
	}
	
	public List<Bill> selectBillsByEx(BillEx billEx,User user){
		
		return null;
	}
	//删除一条记录
	//更新一条记录
	//查询所有记录
	
	
	
}

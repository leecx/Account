package com.bysj.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bysj.mapper.BillMapper;
import com.bysj.mapper.ShareaccountMapper;
import com.bysj.mapper.SortMapper;
import com.bysj.mapper.UserMapper;
import com.bysj.pojo.Bill;
import com.bysj.pojo.Shareaccount;
import com.bysj.pojo.Sort;
import com.bysj.pojo.User;
import com.bysj.pojo.example.BillEx;

/**
 * 图表服务
 *
 * @author created by licx
 * @data 2017年6月5日---下午10:19:22
 */
@Service
public class ChartService {

	@Autowired
	private BillMapper billMapper;
	@Autowired
	private SortMapper sortMapper;
	@Autowired
	private ShareaccountMapper shareaccountMapper;
	@Autowired
	private UserMapper userMapper;

	// 柱状图，要改
	// {aaa,bbb,ccc,ddd}收入：{100,100,100,100} 支出：{100,100,100,100}
	public Map getBarData(BillEx billEx, User user) {
		Map map = new HashMap();
		List<String> usernames = new ArrayList<String>();
		List<Double> incomes = new ArrayList<Double>();
		List<Double> pays = new ArrayList<Double>();

		// 查询出所有的关联用户
		List<User> users = new ArrayList<User>();
		users.add(user);
		List<Shareaccount> saList = shareaccountMapper.selectByUserId(user
				.getId());
		if (saList.size() > 0) {
			for (Shareaccount sa : saList) {
				User Suser = userMapper.selectByPrimaryKey(sa.getFriendid());
				users.add(Suser);
			}
		}
		// 遍历所有用户
		for (User Tuser : users) {
			usernames.add(Tuser.getUsername());
			Double SumOfPay = billMapper.selectPayByDayRegion(Tuser.getId(), billEx.getStartDay(), billEx.getEndDay());
			Double SumOfIncome = billMapper.selectIncomeByDayRegion(Tuser.getId(), billEx.getStartDay(), billEx.getEndDay());
			if (SumOfPay == null) {
				SumOfPay = 0.0;
			}
			if (SumOfIncome == null) {
				SumOfIncome = 0.0;
			}
			incomes.add(SumOfIncome);
			pays.add(SumOfPay);
		}
		map.put("username", usernames);
		map.put("incomes", incomes);
		map.put("pays", pays);
		return map;
	}

	// 饼状图
	public List<Map> getPieData(BillEx billEx) {
		List<Map> datas = new ArrayList<Map>();
		List<String> data = new ArrayList<String>();
		List<Double> value = new ArrayList<Double>();

		List<Bill> bills = billMapper.selectByEx(billEx);
		for (Bill bill : bills) {
			int typeId = bill.getTypeid();
			Sort sort = sortMapper.selectByPrimaryKey(typeId);
			String typeName = sort.getName();
			if (sort.getParentid() != null) {
				typeId = sort.getParentid();
				typeName = sortMapper.selectByPrimaryKey(typeId).getName();
			}
			int index = data.indexOf(typeName);
			if (index == -1) {
				data.add(typeName);
				value.add(bill.getNum());
			} else {
				value.set(index, value.get(index) + bill.getNum());
			}
		}
		for (int i = 0; i < data.size(); i++) {
			Map map = new HashMap();
			map.put("value", value.get(i));
			map.put("name", data.get(i));
			datas.add(map);
		}
		return datas;
	}
}

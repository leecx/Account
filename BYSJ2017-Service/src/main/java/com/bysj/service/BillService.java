package com.bysj.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bysj.mapper.BillMapper;
import com.bysj.mapper.BudgetMapper;
import com.bysj.mapper.ShareaccountMapper;
import com.bysj.mapper.SortMapper;
import com.bysj.mapper.UserMapper;
import com.bysj.pojo.Bill;
import com.bysj.pojo.Budget;
import com.bysj.pojo.Shareaccount;
import com.bysj.pojo.Sort;
import com.bysj.pojo.User;
import com.bysj.pojo.example.BillEx;
import com.bysj.pojo.result.BillDetails;
import com.bysj.pojo.result.Content;
import com.bysj.pojo.result.Result;

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
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ShareaccountMapper shareaccountMapper;
	
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
	
	/**
	 * 查询详细
	 * @param billEx
	 * @param user
	 * @return
	 */
	public List<BillDetails> selectBillsByEx(BillEx billEx,User user){
		List<BillDetails> billDetails = new ArrayList<BillDetails>();
		Set<Long> times = new HashSet<Long>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Integer userId = user.getId();
		billEx.setUserId(userId);
		List<Bill> bills = new ArrayList<Bill>();
		List<Shareaccount> shareaccounts = new ArrayList<Shareaccount>();
		String billExType = billEx.getMember();
		
		if(billExType.contains("(家庭公共)")){
			billEx.setMember("家庭公共");
			String member = billEx.getMember().substring(0,billExType.indexOf("("));
			if(member.equals("全部")){ 	
				 shareaccounts = shareaccountMapper.selectByUserId(billEx.getUserId());
				 bills.addAll(billMapper.selectByEx(billEx));
				 for(Shareaccount shareaccount:shareaccounts){
					 billEx.setUserId(shareaccount.getFriendid());
					 bills.addAll(billMapper.selectByEx(billEx));
				 }
			}else{
				 userId = userMapper.selectByUsername(member).getId();
				 billEx.setUserId(userId);
				 bills = billMapper.selectByEx(billEx);
			}
		}
		else if(billExType.contains("(自我支出)")){
			String member = billEx.getMember().substring(0,billExType.indexOf("("));
			if(member.equals("全部")){
				 shareaccounts = shareaccountMapper.selectByUserId(billEx.getUserId());
				 bills.addAll(billMapper.selectByEx(billEx));
				 for(Shareaccount shareaccount:shareaccounts){
					 billEx.setUserId(shareaccount.getFriendid());
					 billEx.setMember(shareaccount.getFriendid()+"");
					 bills.addAll(billMapper.selectByEx(billEx));
				 }
			}else{
				 userId = userMapper.selectByUsername(member).getId();
				 billEx.setUserId(userId);
				 billEx.setMember(userId+"");
				 bills = billMapper.selectByEx(billEx);
			}
		}
		else if(billExType.equals("全部")){
			shareaccounts = shareaccountMapper.selectByUserId(billEx.getUserId());
			bills.addAll(billMapper.selectByEx(billEx));
			for(Shareaccount shareaccount:shareaccounts){
				billEx.setUserId(shareaccount.getFriendid());
				 bills.addAll(billMapper.selectByEx(billEx));
			}
		}
		else{
			//查询成员的
			User user2 = userMapper.selectByUsername(billEx.getMember());
			billEx.setMember(user2.getId().toString());
			billEx.setUserId(user2.getId());
			bills.addAll(billMapper.selectByEx(billEx));
		}
		
		for(Bill bill:bills){
			times.add(bill.getTime().getTime());    //时间毫秒
		}
		List<Long> SortTimes = new ArrayList<Long>(times);
		Collections.sort(SortTimes);				//从小到大排序
		for(Long time:SortTimes){
			BillDetails billDetails_a = new BillDetails();
			billDetails_a.setTime(dateFormat.format(new Date(time)));
			billDetails.add(billDetails_a);
		}
		
		for(BillDetails billDetails_b:billDetails){
			List<Content> contents = new ArrayList<Content>();
			for(Bill bill:bills){
				if(billDetails_b.getTime().equals(dateFormat.format(bill.getTime()))){
					Content content = new Content();
					content.setId(bill.getId());
					if(!bill.getMember().equals("家庭公共")){
						String username = userMapper.selectByPrimaryKey(Integer.parseInt(bill.getMember())).getUsername();
						content.setMember(username);
					}else{
						content.setMember(bill.getMember());
					}
					String typeName = sortMapper.selectByPrimaryKey(bill.getTypeid()).getName();
					String type = bill.getType().equals("1")?"支出":"收入";
					String num = bill.getNum().toString();
					content.setText(typeName+type+num+"元");
					if(userId==bill.getUserid()){
						content.setShow(true);
					}else{
						content.setShow(false);
					}
					if(bill.getRemark()!=null){
						content.setRemark(bill.getRemark());
					}
					contents.add(content);
				}
			}
			billDetails_b.setContents(contents);
		}
		
		return billDetails;
	}
	//删除一条记录
	public Result deleteBill(Integer id){
		int deleteByPrimaryKey = billMapper.deleteByPrimaryKey(id);
		if(deleteByPrimaryKey>0){
			return Result.Ok();
		}
		return new Result(404, "失败");
	}
	
	//查询所有记录
	
	
	
}

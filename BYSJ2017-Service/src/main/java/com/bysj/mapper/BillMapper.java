package com.bysj.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bysj.pojo.Bill;
import com.bysj.pojo.example.BillEx;

public interface BillMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Bill record);

	int insertSelective(Bill record);

	Bill selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Bill record);

	int updateByPrimaryKey(Bill record);
	
	//查询该日期区间的支出
	Double selectPayByDayRegion(@Param("userId") int userId,
								@Param("startDay") Date startDay,
								@Param("endDay") Date endDay);
	
	//查询该日期区间的收入
	Double selectIncomeByDayRegion(@Param("userId") int userId,
									@Param("startDay") Date startDay,
									@Param("endDay") Date endDay);
	
	//今天支出
	Double selectPayByday(@Param("userId") int userId,@Param("date") Date date);
	
	//今天收入
	Double selectIncomeByday(@Param("userId") int userId,@Param("date") Date date);
	
	//查询该类型支出,月区间
	Double selectMonthPayByTypeId(@Param("typeId") int typeId,
								@Param("userId") int userId,
								@Param("startDay") Date startDay,
								@Param("endDay") Date endDay);
	//更具查询条件，查询出对应的bill
	List<Bill> selectByEx(BillEx billEx);
	
	//查询家庭公共
	Double selectHomeSumByEx(BillEx billEx);
	
	//查询除开家庭公共
	Double selectPaySumByEx(BillEx billEx);
	
}
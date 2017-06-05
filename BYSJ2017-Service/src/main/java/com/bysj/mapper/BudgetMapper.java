package com.bysj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bysj.pojo.Budget;

public interface BudgetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Budget record);

    int insertSelective(Budget record);

    Budget selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Budget record);

    int updateByPrimaryKey(Budget record);

	Budget selectByEx(Budget budgetEx);
	
	//当月总预算
	Double sumBudget(@Param("userId") Integer userId, @Param("month") Integer month ,@Param("year") Integer year);
	
	//查询当月的预算list
	List<Budget> selectByMonth(@Param("userId") Integer userId , @Param("month") Integer month ,@Param("year") Integer year);

	//查询该类型下该年月是否有预算
	int selectCountByTypeId(@Param("userId")Integer userId,@Param("month") Integer month ,@Param("year") Integer year,@Param("typeId") Integer typeId);
}
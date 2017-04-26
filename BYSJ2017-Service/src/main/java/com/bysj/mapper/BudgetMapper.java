package com.bysj.mapper;

import com.bysj.pojo.Budget;

public interface BudgetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Budget record);

    int insertSelective(Budget record);

    Budget selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Budget record);

    int updateByPrimaryKey(Budget record);
}
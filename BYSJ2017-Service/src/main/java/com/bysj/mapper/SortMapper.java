package com.bysj.mapper;

import java.util.List;

import com.bysj.pojo.Sort;

public interface SortMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sort record);

    int insertSelective(Sort record);

    Sort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sort record);

    int updateByPrimaryKey(Sort record);
    
    Sort selectByName(String name);
    
    //查询所有支出一级目录
    List<Sort> selectSortsOfPay();
}
package com.bysj.mapper;

import java.util.List;

import com.bysj.pojo.Shareaccount;

public interface ShareaccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shareaccount record);

    int insertSelective(Shareaccount record);

    Shareaccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shareaccount record);

    int updateByPrimaryKey(Shareaccount record);
    
    //通过userid查询所有关联账户
    List<Shareaccount> selectByUserId(Integer userId);
    
}
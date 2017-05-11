package com.bysj.mapper;

import com.bysj.pojo.Shareaccount;

public interface ShareaccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shareaccount record);

    int insertSelective(Shareaccount record);

    Shareaccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shareaccount record);

    int updateByPrimaryKey(Shareaccount record);
}
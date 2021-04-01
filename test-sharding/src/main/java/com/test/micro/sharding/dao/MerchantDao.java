package com.test.micro.sharding.dao;

import com.test.micro.sharding.entity.Merchant;

public interface MerchantDao {
    int deleteByPrimaryKey(String urid);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
}
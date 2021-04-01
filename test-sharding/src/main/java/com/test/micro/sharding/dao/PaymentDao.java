package com.test.micro.sharding.dao;


import com.test.micro.sharding.entity.Payment;

public interface PaymentDao {
    int deleteByPrimaryKey(String urid);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}
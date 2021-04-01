package com.test.micro.sharding.dao;

import com.test.micro.sharding.entity.Paymentdetail;

public interface PaymentdetailDao {
    int deleteByPrimaryKey(String urid);

    int insert(Paymentdetail record);

    int insertSelective(Paymentdetail record);

    Paymentdetail selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(Paymentdetail record);

    int updateByPrimaryKey(Paymentdetail record);
}
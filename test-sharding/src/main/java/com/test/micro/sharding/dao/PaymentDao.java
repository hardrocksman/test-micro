package com.test.micro.sharding.dao;


import com.test.micro.sharding.entity.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentDao {
    int deleteByPrimaryKey(String urid);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);

    List<Payment> getPayments(@Param("urids") List<String> urids);

    List<Payment> getPaymentsBetween(@Param("startUrid") String startUrid, @Param("endUrid") String endUrid);

    Payment selectWithMerchant(@Param("urid") String urid);

    List<Payment> getPaymentsWith();
}
package com.test.micro.sharding.service;

import com.test.micro.sharding.entity.Payment;
import com.test.micro.sharding.entity.Paymentdetail;

import java.util.List;

public interface PaymentService {

    void insertMerchant(String urid);


    void insertPayment(String urid);

    List<Payment> getPayment(List<String> urids);

    List<Payment> getPaymentBetween(String uridStart, String uridEnd);

    Payment getPaymentWithMerchant(String urid);

    Paymentdetail getDetail(String urid);
}

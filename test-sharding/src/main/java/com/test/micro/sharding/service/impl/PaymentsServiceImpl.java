package com.test.micro.sharding.service.impl;

import com.test.micro.sharding.dao.PaymentDao;
import com.test.micro.sharding.dao.PaymentdetailDao;
import com.test.micro.sharding.entity.Payment;
import com.test.micro.sharding.entity.Paymentdetail;
import com.test.micro.sharding.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class PaymentsServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;
    @Autowired
    PaymentdetailDao paymentdetailDao;

    @Override
    public void insertMerchant() {

    }

    @Override
    public void insertPayment(String urid) {
        Payment payment = new Payment();
        payment.setUrid(urid);
        payment.setOrgid("2222");
        payment.setNotecode(UUID.randomUUID().toString());
        payment.setApplyorgid("2222");
        payment.setOurorgid("2222");
        payment.setOuramount(23132.0);
        payment.setOurexchangerate(1.0);
        payment.setOurlocalcurrencyamount(222.0);
        payment.setOppobjecttype("2");
        payment.setOppamount(23132.0);
        payment.setOppexchangerate(1.0);
        payment.setOpplocalcurrencyamount(222.0);
        payment.setOppobjecttype("2");
        payment.setIssamebank("1");
        payment.setIssameregion("1");
        payment.setIsurgent("2");
        payment.setPaystate("1");
        payment.setCancelstate("1");
        payment.setGenrelatedtransstate("1");
        payment.setRecordsource("4");
        payment.setCreatedby("TEST");
        payment.setCreatedon(new Date());

        payment.setLastmodifiedby("TEST");
        payment.setLastmodifiedon(new Date());
        payment.setRowversion((short) 1);
        payment.setIscheck("0");
        payment.setSplitedamount(0.0);
        payment.setSplitmergeflag("0");
        payment.setTenantid(new BigDecimal("10001"));
        payment.setTerminatestate("0");
        payment.setOurpaidamount(0.0);
        payment.setCosts(0.0);
        payment.setOppprivateflag("0");
        payment.setIspayfailsendmsg("0");

        Paymentdetail paymentdetail = new Paymentdetail();
        paymentdetail.setPaymentid(urid);
        paymentdetail.setUrid(urid);
        paymentdetail.setAmount(2.2);
        paymentdetail.setCreatedby("TEST");
        paymentdetail.setCreatedon(new Date());
        paymentdetail.setRowversion((short) 1);
        paymentdetail.setLastmodifiedby("TEST");
        paymentdetail.setLastmodifiedon(new Date());
        paymentdetail.setTenantid(new BigDecimal("10001"));
        paymentdetail.setOrgid("2222");

        paymentDao.insert(payment);
        paymentdetailDao.insert(paymentdetail);
    }
}

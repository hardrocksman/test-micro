package com.test.micro.sharding.service;

import com.test.micro.sharding.entity.Payment;
import com.test.micro.sharding.entity.Paymentdetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PaymentServiceTest {
    @Autowired
    PaymentService paymentService;
    @Autowired
    IdGenerator idGenerator;

    /**
     * 测试广播表插入
     */
    @Test
    public void testInsertMerchant() {
        paymentService.insertMerchant("1");
    }

    /**
     * 测试广播表插入
     */
    @Test
    public void testBatchInsertMerchant() {
        paymentService.batchInsertMerchant();
    }

    /**
     * 测试主键插入
     */
    @Test
    public void testInsertPayment() {
        Long id = idGenerator.nextId();
        paymentService.insertPayment(id.toString());
    }

    /**
     * 测试主键插入
     */
    @Test
    public void testBatchInsertPayment() {
        Long id = idGenerator.nextId();
        paymentService.batchInsertPayment();
    }

    /**
     * 测试直接查付款表  in  《= 》=
      */
    @Test
    public void selectPayments() {
//        paymentService.getPayment(Arrays.asList("577131389569335296", "577131389569335296"));
        paymentService.getPaymentBetween("577131389569335296", String.valueOf(577131389569335296L + 10000000000L));
    }

    /**
     * 测试广播表查询  join
      */
    @Test
    public void testBroadCastJoin() {
        Payment p = paymentService.getPaymentWithMerchant("577190128661954560");
        System.out.println("商户号：" + p.getMerchantName());
    }


    /**
     * 测试绑定表查询 join
      */
    @Test
    public void bindTableJoin() {
        Paymentdetail p = paymentService.getDetail("577190128661954560");
        System.out.println("商户号：" + p.getNotecode());
    }

    @Test
    public void testGetPayments() {
        paymentService.getPayments();
    }
}

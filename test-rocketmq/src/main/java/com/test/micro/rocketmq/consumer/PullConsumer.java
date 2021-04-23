package com.test.micro.rocketmq.consumer;


import com.alibaba.fastjson.JSONObject;
import com.sun.corba.se.impl.oa.toa.TOA;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class PullConsumer implements CommandLineRunner {

    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;

    @Value("${rocketmq.consumer.groupName}")
    private String groupName;

    @Value("${rocketmq.consumer.topic}")
    private String topic;

    @Value("${rocketmq.consumer.tag}")
    private String tag;

    @Override
    public void run(String... args) throws Exception {
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer(groupName);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setInstanceName(groupName);
        consumer.start();
        System.out.println("消费者创建完成");

        PullThread pullThread = new PullThread(topic, consumer, tag);
        Thread t = new Thread(pullThread);
        t.start();
    }
}

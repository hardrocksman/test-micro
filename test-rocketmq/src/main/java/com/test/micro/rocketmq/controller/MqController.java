package com.test.micro.rocketmq.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.micro.rocketmq.config.RocketMQProducer;
import com.test.micro.rocketmq.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
@Slf4j
public class MqController {

    @Value("${rocketmq.producer.topic}")
    private String topic;

    @Value("${rocketmq.producer.tag}")
    private String tag;

    @Autowired
    MQProducer producer;
//    @Qualifier("rocketMQProducer")
//    RocketMQProducer rocketMQProducer;

    @GetMapping("/testSend")
    public ResponseEntity<String> testSend() {

//        DefaultMQProducer producer = rocketMQProducer.getRocketMQProducer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        User user = new User(1L, "aaa", "2021-09-09", "man", "your home");
        String body = "hi RocketMQ, now is  " + sdf.format(new Date()) + "---"+ JSONObject.toJSONString(user);
        Message message = new Message(topic, tag, body.getBytes());
        try {
            producer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.of(Optional.of("ok"));
    }


    @GetMapping("/testSendDelay")
    public ResponseEntity<String> testSendDelay() {

//        DefaultMQProducer producer = rocketMQProducer.getRocketMQProducer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        User user = new User(1L, "aaa", "2021-09-09", "man", "your home");
        String body = "hi RocketMQ,延时消息 now is  " + sdf.format(new Date()) + "---"+ JSONObject.toJSONString(user);
        Message message = new Message(topic, tag, body.getBytes());
        message.setDelayTimeLevel(3);
        try {
            producer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.of(Optional.of("ok"));
    }
}

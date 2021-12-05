package com.zhl.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.support.MessageBuilder;

@SpringBootApplication
public class SpringCloudRabbitmqApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringCloudRabbitmqApp.class, args);
//        StreamSendClient streamClient = (StreamSendClient)run.getBean("streamSendClient");
//        streamClient.output().send(MessageBuilder.withPayload("from streamClient").build());
    }
}

package com.zhl.test;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding({StreamSendClient.class})
public class SinkReceiver {

    @StreamListener("testMessage")
    public void reveive(Object payload){
        System.out.println("Received:" + payload);
    }
}

package com.zhl.test;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.xml.ws.soap.Addressing;

@Component
public class StartRunner implements CommandLineRunner {

    @Autowired
    StreamSendClient streamSendClient;

    @Override
    public void run(String... args) throws Exception {
        streamSendClient.output().send(MessageBuilder.withPayload("from streamClient").build());
    }
}

package com.zhl.test;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface StreamSendClient {

    @Output("testMessage")
    MessageChannel output();

    @Input("testMessage")
    MessageChannel input();
}

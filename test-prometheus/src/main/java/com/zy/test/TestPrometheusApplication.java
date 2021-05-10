package com.zy.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TestPrometheusApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestPrometheusApplication.class, args);
    }
}

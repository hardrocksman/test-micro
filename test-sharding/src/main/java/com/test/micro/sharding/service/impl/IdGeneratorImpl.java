package com.test.micro.sharding.service.impl;

import com.test.micro.sharding.keygen.SnowFlake;
import com.test.micro.sharding.service.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class IdGeneratorImpl implements IdGenerator {

    @Value("${id-generator.data-center-id}")
    Integer dataCenterId;

    @Value("${id-generator.data-machine-id}")
    Integer machineId;

    private SnowFlake snowflake;

    @PostConstruct
    private void init() {
        log.info("dataCenterId:[{}]", dataCenterId);
        log.info("machineId:[{}]", machineId);
        this.snowflake = new SnowFlake(dataCenterId, machineId);
    }


    @Override
    public Long nextId() {
        return snowflake.nextId();
    }
}

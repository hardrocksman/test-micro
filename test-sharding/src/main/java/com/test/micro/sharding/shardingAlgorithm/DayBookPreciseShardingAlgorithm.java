package com.test.micro.sharding.shardingAlgorithm;

import com.alibaba.fastjson.JSON;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * 精准分片算法
 *
 * @author zhenghualiang
 * @date 2021-04-14
 */
public class DayBookPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Date> {

    private static final Logger log = LoggerFactory.getLogger(DayBookPreciseShardingAlgorithm.class);

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> shardingValue) {
        log.info("collection:[{}],preciseShardingValue:[{}]", JSON.toJSONString(availableTargetNames), JSON.toJSONString(shardingValue));

        Date shardingVa = shardingValue.getValue();

        String dateStr = new SimpleDateFormat("yyyyMM").format(shardingVa);
        for (String name : availableTargetNames) {
            if (name.endsWith(dateStr)) {
                log.info("return name: " + name);
                return name;
            }
        }
        return null;
    }
}

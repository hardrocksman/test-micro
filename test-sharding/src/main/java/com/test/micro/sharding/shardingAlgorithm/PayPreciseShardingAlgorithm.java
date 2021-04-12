package com.test.micro.sharding.shardingAlgorithm;

import com.alibaba.fastjson.JSON;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class PayPreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    private static final Logger log = LoggerFactory.getLogger(PayPreciseShardingAlgorithm.class);

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        log.info("collection:[{}],preciseShardingValue:[{}]", JSON.toJSONString(availableTargetNames), JSON.toJSONString(shardingValue));
        //availableTargetNames: t_order_1,t_order_2
        //shardingValue: {"logicTableName":"t_order","columnName":"order_id","value":396416249350848512}
        //collection:["t_order_1","t_order_2"],preciseShardingValue:{"logicTableName":"t_order","columnName":"order_id","value":396416249350848512}
        //name为两张订单表 t_order_1 和 t_order_2

        String shardingVa = shardingValue.getValue();
        // 雪花算法反推时间
        Long id = Long.parseLong(shardingVa);
        log.info("获取到的id:[{}]", id);
        Long timeStamp = id >> 22;
        log.info("雪花算法反推时间戳:[{}]", timeStamp);
        timeStamp = timeStamp + 1480166465631L;

        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        log.info("雪花算法反推时间，年:[{}],月:[{}]", year, month);

        String suffiex = String.valueOf(year * 100 + month);
        for (String name : availableTargetNames) {
            //订单号取模加1 与 订单表t_order_1 和 t_order_2的尾号做比对，如相等，就直接返回t_order_1 或 t_order_2
            if (name.endsWith(suffiex)) {
                log.info("return name: " + name);
                return name;
            }
        }
        return null;
    }
}

package com.test.micro.sharding.shardingAlgorithm;

import com.alibaba.fastjson.JSON;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class PayPreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayPreciseShardingAlgorithm.class);
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        LOGGER.info("collection:[{}],preciseShardingValue:[{}]", JSON.toJSONString(availableTargetNames), JSON.toJSONString(shardingValue));
        //availableTargetNames: t_order_1,t_order_2
        //shardingValue: {"logicTableName":"t_order","columnName":"order_id","value":396416249350848512}
        //collection:["t_order_1","t_order_2"],preciseShardingValue:{"logicTableName":"t_order","columnName":"order_id","value":396416249350848512}
        //name为两张订单表 t_order_1 和 t_order_2

        String shardingVa = shardingValue.getValue();
        String year = shardingVa.substring(0, 4);
        String month = shardingVa.substring(4, 6);
        LOGGER.info("shardingVa:[{}]", shardingVa);

        Integer monthInt = Integer.parseInt(month);

        String suffiex = year.concat("_").concat(monthInt.toString());
        for (String name : availableTargetNames) {
            //订单号取模加1 与 订单表t_order_1 和 t_order_2的尾号做比对，如相等，就直接返回t_order_1 或 t_order_2
            if (name.endsWith(suffiex)) {
                LOGGER.info("return name: " + name);
                return name;
            }
        }
        return null;
    }
}

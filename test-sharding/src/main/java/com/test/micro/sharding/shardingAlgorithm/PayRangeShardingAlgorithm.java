package com.test.micro.sharding.shardingAlgorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashSet;

public class PayRangeShardingAlgorithm implements RangeShardingAlgorithm<String> {

    private static final Logger log = LoggerFactory.getLogger(PayRangeShardingAlgorithm.class);

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        log.info("分区规则分片算法:[{}]-[{}]", availableTargetNames, shardingValue);

        Range<String> range = shardingValue.getValueRange();

        String startUrid = range.lowerEndpoint();
        String endUrid = range.upperEndpoint();

        // 雪花算法反推时间
        Long startId = Long.parseLong(startUrid);
        log.info("获取到的id:[{}]", startId);
        Long startTimeStamp = startId >> 22;
        log.info("雪花算法反推时间戳:[{}]", startTimeStamp);
        startTimeStamp = startTimeStamp + 1480166465631L;

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(startTimeStamp);

        int startYear = calendar.get(Calendar.YEAR);
        int startMonth = calendar.get(Calendar.MONTH) + 1;

        log.info("雪花算法反推时间，年:[{}],月:[{}]", startYear, startMonth);

        // 雪花算法反推时间
        Long endId = Long.parseLong(endUrid);
        log.info("获取到的id:[{}]", endId);
        Long endTimeStamp = endId >> 22;
        log.info("雪花算法反推时间戳:[{}]", endTimeStamp);
        endTimeStamp = endTimeStamp + 1480166465631L;

        calendar.setTimeInMillis(endTimeStamp);

        int endYear = calendar.get(Calendar.YEAR);
        int endMonth = calendar.get(Calendar.MONTH) + 1;

        log.info("雪花算法反推时间，年:[{}],月:[{}]", endYear, endMonth);

//        String startSuffix = String.valueOf(startYear).concat(String.valueOf(startMonth));
//        String endSuffix = String.valueOf(endYear).concat(String.valueOf(endMonth));

        int startSuffix = startYear * 100 + startMonth;
        int endSuffix = endYear * 100 + endMonth;

        Collection<String> tables = new LinkedHashSet<>();
        for (String name : availableTargetNames) {
            String nameSuffix = name.substring(name.length() - 6);

            int yearMonth = Integer.parseInt(nameSuffix);
            if (yearMonth >= startSuffix && endSuffix >= yearMonth) {
                tables.add(name);
            }
        }

        return tables;
    }
}

package com.test.micro.sharding.shardingAlgorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

/**
 * 区间分片算法
 *
 * @author zhenghualiang
 * @date 2021-04-14
 */
public class DayBookRangeShardingAlgorithm implements RangeShardingAlgorithm<String> {

    private static final Logger log = LoggerFactory.getLogger(DayBookRangeShardingAlgorithm.class);

    DateTimeFormatter DATETIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd");

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        log.info("分区规则分片算法:[{}]-[{}]", availableTargetNames, shardingValue);

        Range<String> range = shardingValue.getValueRange();

        String startDateStr = range.lowerEndpoint();
        String endDateStr = range.upperEndpoint();

        DateTime date = DateTime.parse(startDateStr, DATETIME_FORMATTER);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date.toDate());

        int startYear = calendar.get(Calendar.YEAR);
        int startMonth = calendar.get(Calendar.MONTH) + 1;
        log.info("查询开始时间，年:[{}],月:[{}]", startYear, startMonth);

        endDateStr = endDateStr.substring(0, 10);
        date = DateTime.parse(endDateStr, DATETIME_FORMATTER);
        calendar.setTime(date.toDate());
        int endYear = calendar.get(Calendar.YEAR);
        int endMonth = calendar.get(Calendar.MONTH) + 1;
        log.info("查询结束时间，年:[{}],月:[{}]", endYear, endMonth);

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

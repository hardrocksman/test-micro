package com.zhl.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

    public static final String YEAR_FIRST_DAY = "2021-01-01";

    public static final SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");

    public static final SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

    public final static long START_STMP = 1480166465631L;

    public static void main(String[] args) {
        Calendar ca = Calendar.getInstance();
        try {
            Date d = datef.parse(YEAR_FIRST_DAY);
            ca.setTime(d);

            for (int i = 0; i < 13; i++) {
                Date dd = ca.getTime();

                long snowId = (dd.getTime() - START_STMP) << 22;
                System.out.println("时间：" + dateformat.format(dd) + ";时间戳：" + dd.getTime() + "对应雪花id：" + snowId);

                ca.add(Calendar.MONTH, 1);
            }
        } catch (Exception e) {

        }
    }
}

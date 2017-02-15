package com.liu.coolweather.tool;

import java.text.SimpleDateFormat;

/**
 * Created by LIUZICHENG on 2016/12/24.
 */

public class Util {
    /*获得当天日期*/
    public static String getDate() {
        Long date = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(date);
    }
}

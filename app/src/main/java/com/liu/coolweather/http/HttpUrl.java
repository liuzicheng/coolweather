package com.liu.coolweather.http;

/**
 * Created by LIUZICHENG on 2016/12/17.
 */

public class HttpUrl {
    /*服务地址*/
    public static String serverApi = "https://free-api.heweather.com/v5/";
    /*7-10天气预报接口 forecast?city=""&key=""&lang=""*/
    private static String forecast ="forecast";
    /*今天天气接口*/
    private static String now ="now";

    public static String KEY = "ddbe9d4e7602442b9da8aecdc6ec242e";

    public static String todayWeather = serverApi + now;
}

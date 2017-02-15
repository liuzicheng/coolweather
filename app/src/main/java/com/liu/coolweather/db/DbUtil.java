package com.liu.coolweather.db;

import com.liu.coolweather.LzcApplication;
import com.liu.coolweather.bean.Weather;
import com.liu.coolweather.bean.WeatherTime;
import com.liu.coolweather.tool.ToastTool;

import org.litepal.crud.DataSupport;
import org.litepal.exceptions.DataSupportException;

import java.util.List;

/**
 * Created by LIUZICHENG on 2016/12/24.
 */

public class DbUtil {
    /*查找今天的天气数据*/
    public static WeatherTime findNowWeather(String date){
        List<WeatherTime> listWeat =  DataSupport.where("nowDate = ? ",date).find(WeatherTime.class);
        if (listWeat.size() > 0){
             return listWeat.get(0);
        }
        return  null;
    }

    public static void saveWeather(WeatherTime weatherTime,Weather weather){
       try {
           weather.saveThrows();
           weatherTime.saveThrows();
       }catch (DataSupportException e){
           ToastTool.Makter(LzcApplication.getContext(),"save error");
       }
    }
}

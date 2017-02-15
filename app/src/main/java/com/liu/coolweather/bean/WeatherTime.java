package com.liu.coolweather.bean;

import com.liu.coolweather.bean.Weather;

import org.litepal.crud.DataSupport;

/**
 * Created by LIUZICHENG on 2016/12/24.
 */

public class WeatherTime extends DataSupport{

    private int _id;
    private Long nowDate;//时间
    private Weather weather;

    public Long getNowDate() {
        return nowDate;
    }

    public void setNowDate(Long nowDate) {
        this.nowDate = nowDate;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}

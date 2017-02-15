package com.liu.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by LIUZICHENG on 2017/2/13.
 */

public class County extends DataSupport {

    private int id;
    private String name;
    private String weather_id;
    //县级名称
    private String countyName;
    //县级所对应的天气
    private String weatherId;
    /*当前县所属市id*/
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(String weather_id) {
        this.weather_id = weather_id;
    }
}

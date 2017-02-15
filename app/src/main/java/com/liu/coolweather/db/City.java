package com.liu.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by LIUZICHENG on 2017/2/13.
 */

public class City extends DataSupport {

    private int id;

    private String cityName;
    private String name;
    private String cityCode;
    //当前城市所属的省
    private int provinceId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}

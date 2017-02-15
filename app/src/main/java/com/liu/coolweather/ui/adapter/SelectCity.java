package com.liu.coolweather.ui.adapter;

/**
 * Created by LIUZICHENG on 2017/2/14.
 */

public class SelectCity {
    private int id;
    private String name;
    private String weatherId;//只有县级才有天气ID
    private boolean isOpen = false;//是否张开。默认false
    private int dataType;//是那一级：省 = 0、市 = 1、县 = 2 。
    private int provinceId;//依靠的省级ID
    private int cityId;//依靠的市级ID

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}

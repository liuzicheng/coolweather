package com.liu.coolweather.presenter;

/**
 * Created by LIUZICHENG on 2017/2/13.
 */

public interface ProvinceCityCountyPresenter {

    void getProvince();

    void getCity(int proviceId,int position);

    void getCounty(int provinceId,int cityId,int position);
}

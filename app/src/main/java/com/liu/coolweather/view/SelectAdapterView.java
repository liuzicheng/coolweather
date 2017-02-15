package com.liu.coolweather.view;

import com.liu.coolweather.ui.adapter.SelectCity;

import java.util.List;

/**
 * Created by LIUZICHENG on 2017/2/14.
 */

public interface SelectAdapterView {
     void resultProvince(List<SelectCity> provinceList);
     void resultCity(List<SelectCity> cityList,int position);
     void resultCounty(List<SelectCity> cityList,int position);
}

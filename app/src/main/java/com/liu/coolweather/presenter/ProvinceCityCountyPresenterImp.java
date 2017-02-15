package com.liu.coolweather.presenter;

import com.liu.coolweather.db.City;
import com.liu.coolweather.db.County;
import com.liu.coolweather.db.Province;
import com.liu.coolweather.http.HttpUrl;
import com.liu.coolweather.http.Network;
import com.liu.coolweather.model.ProvinceCityCountyService;
import com.liu.coolweather.tool.LogTool;
import com.liu.coolweather.tool.ToastTool;
import com.liu.coolweather.ui.adapter.SelectCity;
import com.liu.coolweather.view.SelectAdapterView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by LIUZICHENG on 2017/2/13.
 */

public class ProvinceCityCountyPresenterImp implements ProvinceCityCountyPresenter {
    ProvinceCityCountyService service;
    SelectAdapterView selectAdapterView;

    public ProvinceCityCountyPresenterImp(SelectAdapterView selectAdapterView) {
        service = Network.getProvinceService();
        this.selectAdapterView = selectAdapterView;
    }

    @Override
    public void getProvince() {
        service.getProvince()
                .map(new Func1<List<Province>, List<SelectCity>>() {
                    @Override
                    public List<SelectCity> call(List<Province> province) {
                        List<SelectCity> cityList = new ArrayList<SelectCity>();
                        if (province != null) {
                            for (Province p : province) {
                                p.save();
                                SelectCity city = new SelectCity();
                                city.setDataType(0);
                                city.setId(p.getId());
                                city.setName(p.getName());
                                cityList.add(city);
                                LogTool.d(p.getId() + "-" + p.getName());
                            }
                        }
                        return cityList;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<SelectCity>>() {
                    @Override
                    public void onCompleted() {
                        LogTool.d("onCompleted ---");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogTool.d("error:" + e.getMessage());
                    }

                    @Override
                    public void onNext(List<SelectCity> provinces) {
                        if (provinces != null) {
                            selectAdapterView.resultProvince(provinces);
                        }
                    }
                });
    }

    @Override
    public void getCity(final int provinceId, final int position) {
        service.getCity(provinceId)
                .map(new Func1<List<City>, List<SelectCity>>() {
                    @Override
                    public List<SelectCity> call(List<City> cities) {
                        List<SelectCity> cityList = new ArrayList<SelectCity>();
                        if (cities != null && cities.size() > 0) {
                            for (City c : cities) {
                                c.setProvinceId(provinceId);
                                c.save();
                                SelectCity selectCity = new SelectCity();
                                selectCity.setDataType(1);
                                selectCity.setId(c.getId());
                                selectCity.setName(c.getName());
                                selectCity.setProvinceId(provinceId);
                                cityList.add(selectCity);
                                LogTool.d(c.getId() + "-" + c.getName());
                            }
                        }
                        return cityList;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<SelectCity>>() {
                    @Override
                    public void onCompleted() {
                        LogTool.d("onCompleted ---");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogTool.d("error:" + e.getMessage());
                    }

                    @Override
                    public void onNext(List<SelectCity> cityList) {
                        selectAdapterView.resultCity(cityList, position);
                    }
                });
    }

    @Override
    public void getCounty(final int provinceId, final int cityId, final int position) {
        service.getCounty(provinceId, cityId)
                .map(new Func1<List<County>, List<SelectCity>>() {
                    @Override
                    public List<SelectCity> call(List<County> county) {
                        List<SelectCity> cityList = new ArrayList<SelectCity>();
                        if (county != null && county.size() > 0) {
                            for (County c : county) {
                                c.setCityId(cityId);
                                c.save();
                                SelectCity selectCity = new SelectCity();
                                selectCity.setDataType(2);
                                selectCity.setId(c.getId());
                                selectCity.setName(c.getName());
                                selectCity.setCityId(cityId);
                                selectCity.setProvinceId(provinceId);
                                selectCity.setWeatherId(c.getWeather_id());
                                cityList.add(selectCity);
                                LogTool.d(c.getId() + "-" + c.getName());
                            }
                        }
                        return cityList;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<SelectCity>>() {
                    @Override
                    public void onCompleted() {
                        LogTool.d("onCompleted ---");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogTool.d("error:" + e.getMessage());
                    }

                    @Override
                    public void onNext(List<SelectCity> counties) {
                        if (counties != null) {
                            selectAdapterView.resultCounty(counties,position);
                        }
                    }
                });
    }
}

package com.liu.coolweather.presenter;

import com.liu.coolweather.bean.Weather;
import com.liu.coolweather.http.HttpUrl;
import com.liu.coolweather.http.Network;
import com.liu.coolweather.model.RequestServers;
import com.liu.coolweather.view.MainView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LIUZICHENG on 2017/2/12.
 */

public class RequestWeatherPresenterImp implements RequestWeatherPresenter {

    private MainView mainView ;
    private RequestServers requestServers;
    public RequestWeatherPresenterImp(MainView mainView) {
        this.mainView = mainView;
        requestServers = Network.getServer();
    }

    @Override
    public void loadWeather(String city) {
        requestServers.now(city, HttpUrl.KEY, "")
                // 指定 subscribe() 发生在 IO 线程
                .subscribeOn(Schedulers.io())
                // 指定 Subscriber 的回调发生在主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Weather>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Weather weather) {
                        mainView.onWeatherLoad(weather);
                    }
                });
    }
}

package com.liu.coolweather.http;

import com.liu.coolweather.model.ProvinceCityCountyService;
import com.liu.coolweather.model.RequestServers;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LIUZICHENG on 2016/12/21.
 */

public class Network {
    private static RequestServers requestServers;
    private static ProvinceCityCountyService provinceCityCountyService;
    private static OkHttpClient okHttpClient = new OkHttpClient();

    public static RequestServers getServer(){
        if (requestServers == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(HttpUrl.server)
                    .addConverterFactory(GsonConverterFactory.create()) //添加gson支持
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加RxJava支持
                    .build();
            requestServers = retrofit.create(RequestServers.class);
        }
        return requestServers;
    }
    public static ProvinceCityCountyService getProvinceService(){
        if (provinceCityCountyService == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(HttpUrl.province)
                    .addConverterFactory(GsonConverterFactory.create()) //添加gson支持
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加RxJava支持
                    .build();
            provinceCityCountyService =  retrofit.create(ProvinceCityCountyService.class);
        }
        return provinceCityCountyService;
    }
}

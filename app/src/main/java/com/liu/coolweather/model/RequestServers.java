package com.liu.coolweather.model;

import com.liu.coolweather.bean.Weather;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by LIUZICHENG on 2016/12/20.
 */

public interface RequestServers {

    @GET("suggestion")
    Observable<Weather> suggestion(@Query("city") String city,@Query("key") String key,@Query("lang") String lang);
    @GET("now")
    Observable<Weather> now(@Query("city") String city,@Query("key") String key,@Query("lang") String lang);

}

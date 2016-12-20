package com.liu.coolweather.http;

import com.liu.coolweather.model.Weather;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by LIUZICHENG on 2016/12/20.
 */

public interface RequestServers {

    @GET("suggestion")
    Observable<Weather> suggestion(@Query("city") String city,@Query("key") String key,@Query("lang") String lang);

}

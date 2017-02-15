package com.liu.coolweather.model;

import com.liu.coolweather.db.City;
import com.liu.coolweather.db.County;
import com.liu.coolweather.db.Province;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by LIUZICHENG on 2017/2/13.
 */

public interface ProvinceCityCountyService {
    @GET("china")
    Observable<List<Province>> getProvince();
    @GET("china/{id}")
    Observable<List<City>> getCity(@Path("id") int id);
    @GET("china/{id}/{cid}")
    Observable<List<County>> getCounty(@Path("id") int id, @Path("cid") int cid);
}

package com.liu.coolweather.location;

import android.content.Context;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.liu.coolweather.LzcApplication;
import com.liu.coolweather.MainActivity;

/**
 * Created by LIUZICHENG on 2016/12/17.
 */

public class LzcLocatOption {
    private LocationClient mLocationClient;


    public LzcLocatOption( ){
        mLocationClient = new LocationClient(LzcApplication.getContext());
        BDLocationListener listener = new LzcLocationListener();
        mLocationClient.registerLocationListener(listener);
    }

    public void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
//        int span=1000;
//        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
//        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
//        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    public void start(){
        if (mLocationClient != null){
            mLocationClient.start();
        }
    }
    public void stop(){
        if (mLocationClient != null){
            mLocationClient.stop();
        }
    }
}

package com.liu.coolweather;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;


import com.baidu.location.LocationClient;
import com.liu.coolweather.http.HttpUrl;
import com.liu.coolweather.http.RequestServers;
import com.liu.coolweather.location.LzcLocatOption;
import com.liu.coolweather.model.Weather;
import com.liu.coolweather.tool.LogTool;
import com.liu.coolweather.tool.SharedTool;
import com.liu.coolweather.tool.ToastTool;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends BaseActivity {

    private String city;
    private static final int BAIDU_GET_LOCATION = 10000;

    @BindView(R.id.weather)TextView tvWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        LzcLocatOption  option = new LzcLocatOption();
        option.initLocation();
        option.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        city = SharedTool.readString("city","beijing");
        requ(city,"");
    }

    private void requ(String city,String lang){
        Retrofit retrofit = new Retrofit.Builder()
                        .client(new OkHttpClient())
                        .baseUrl(HttpUrl.serverApi)
                        .addConverterFactory(GsonConverterFactory.create()) //添加gson支持
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加RxJava支持
                        .build();
        RequestServers  requestServers =  retrofit.create(RequestServers.class);

        requestServers.suggestion(city,HttpUrl.KEY,lang)
                // 指定 subscribe() 发生在 IO 线程
                .subscribeOn(Schedulers.io())
                // 指定 Subscriber 的回调发生在主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observable);
    }

    Observer<Weather> observable = new Observer<Weather>(){

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            ToastTool.Makter(MainActivity.this,getString(R.string.loading_failed));
        }

        @Override
        public void onNext(Weather weather) {
            if (weather.getHeWeather5().size()>0){
                LogTool.i( weather.getHeWeather5().get(0).getBasic().getCity());
                tvWeather.setText(weather.getHeWeather5().get(0).getBasic().getCity());
            }

        }
    };

    /**
     * 当targetSdkVersion 23 以上时定位权限需要自己去请求。
     * **/
    @Override
    public int checkSelfPermission(String permission) {
        if (this.checkSelfPermission(ACCESS_COARSE_LOCATION)
                != PERMISSION_GRANTED){
            //动态请求定位权限
            ActivityCompat.requestPermissions(this,new String[]{ACCESS_COARSE_LOCATION,ACCESS_FINE_LOCATION},
                    BAIDU_GET_LOCATION);
        }

        return super.checkSelfPermission(permission);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case BAIDU_GET_LOCATION:
                if (grantResults[0] == PERMISSION_GRANTED){
                    //动态获取到权限
                }else {
                    //没有获取到权限
                    ToastTool.Makter(this,"获取定位权限失败");

                }
                break;
        }
    }
}

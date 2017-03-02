package com.liu.coolweather;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.liu.coolweather.db.DbUtil;
import com.liu.coolweather.http.HttpUrl;
import com.liu.coolweather.http.Network;
import com.liu.coolweather.location.LzcLocatOption;
import com.liu.coolweather.lenum.RequestKeyStatusEnum;
import com.liu.coolweather.bean.Weather;
import com.liu.coolweather.bean.WeatherTime;
import com.liu.coolweather.presenter.ProvinceCityCountyPresenterImp;
import com.liu.coolweather.presenter.RequestWeatherPresenterImp;
import com.liu.coolweather.tool.LogTool;
import com.liu.coolweather.tool.NetworkTool;
import com.liu.coolweather.tool.SharedTool;
import com.liu.coolweather.tool.ToastTool;
import com.liu.coolweather.tool.Util;
import com.liu.coolweather.ui.SelectCityActivity;
import com.liu.coolweather.view.MainView;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends BaseActivity implements MainView {
    private String city;
    private static final int BAIDU_GET_LOCATION = 10000;
    private LzcLocatOption option;
    /****/
    @BindView(R.id.temperature)
    TextView temperature;
    @BindView(R.id.hum)
    TextView hum;
    @BindView(R.id.pcpn)
    TextView pcpn;
    @BindView(R.id.pres)
    TextView pres;
    @BindView(R.id.vis)
    TextView vis;
    @BindView(R.id.weather_status)
    TextView tvWeather;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title)
    TextView title;

    @OnClick(R.id.title)
    public void title(View view) {
        ToastTool.Makter(this, getString(R.string.selectCity));
        Intent intent = new Intent(this, SelectCityActivity.class);
        startActivityForResult(intent, RESULT_FIRST_USER);
    }

    @BindView(R.id.fruit_image_view)
    ImageView fruitImageView;
    @BindDrawable(R.drawable.default_fruit)
    Drawable defaultFruit;
    @BindView(R.id.collapsing)
    CollapsingToolbarLayout collapsing;


    RequestWeatherPresenterImp rwpi;
    ProvinceCityCountyPresenterImp pccpi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        title.setText(getString(R.string.app));
        fruitImageView.setImageDrawable(defaultFruit);
        setSupportActionBar(toolbar);
        rwpi = new RequestWeatherPresenterImp(this);
//        pccpi = new ProvinceCityCountyPresenterImp();
//        pccpi.getCounty(11,46);
//        loadDB();
    }
    
    private void loadDB() {
        WeatherTime weatherTime = DbUtil.findNowWeather(Util.getDate());
        if (weatherTime == null) {
            init();
        } else {
            setTextData(weatherTime.getWeather().getHeWeather5().get(0).getNow());
        }
    }

    private void init() {
        option = new LzcLocatOption();
        option.initLocation();
        option.start();
        option.setBackDataListener(new LzcLocatOption.BackDataListener() {
            @Override
            public void success() {
                city = SharedTool.readString("city", "beijing");
                LogTool.i(city);
                rwpi.loadWeather(city);

            }

            @Override
            public void fail() {
                String ip = NetworkTool.getIP();
                LogTool.i(ip);
                rwpi.loadWeather(ip);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addCity:
                ToastTool.Makter(this, getString(R.string.addCity));
                break;
        }
        return true;
    }

    private void setTextData(Weather.HeWeather5Entity.NowEntity nowEntity) {
        tvWeather.setText(nowEntity.getTmp() + "°\n" + nowEntity.getCond().getTxt());
        temperature.setText(getString(R.string.somatosensory_temperature) + ":" + nowEntity.getFl() + "°");
        hum.setText(getString(R.string.relative_humidity) + ":" + nowEntity.getHum() + "%");
        pcpn.setText(getString(R.string.precipitation) + ":" + nowEntity.getPcpn() + "mm");
        pres.setText(getString(R.string.air_pressure) + ":" + nowEntity.getPres() + "");
        vis.setText(getString(R.string.visibility) + ":" + nowEntity.getVis() + "/km");
    }

    /**
     * 当targetSdkVersion 23 以上时定位权限需要自己去请求。
     **/
    @Override
    public int checkSelfPermission(String permission) {
        if (this.checkSelfPermission(ACCESS_COARSE_LOCATION)
                != PERMISSION_GRANTED) {
            //动态请求定位权限
            ActivityCompat.requestPermissions(this, new String[]{ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION},
                    BAIDU_GET_LOCATION);
        }

        return super.checkSelfPermission(permission);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case BAIDU_GET_LOCATION:
                if (grantResults[0] == PERMISSION_GRANTED) {
                    //动态获取到权限

                } else {
                    //没有获取到权限
                    ToastTool.Makter(this, "获取定位权限失败");
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (option != null) {
            option.stop();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESULT_FIRST_USER:
                if (resultCode == RESULT_OK){
                    showCityWeather(data.getStringExtra("cityName"),data.getStringExtra("weatherId"));
                }
                break;
        }
    }
    private void showCityWeather(String cityName,String weatherId){
        title.setText(cityName);
        rwpi.loadWeather(weatherId);
    }
    @Override
    public void onWeatherLoad(Weather weather) {
        setTextData(weather.getHeWeather5().get(0).getNow());
    }
}

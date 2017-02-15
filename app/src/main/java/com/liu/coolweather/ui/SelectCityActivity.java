package com.liu.coolweather.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liu.coolweather.BaseActivity;
import com.liu.coolweather.R;
import com.liu.coolweather.db.Province;
import com.liu.coolweather.presenter.ProvinceCityCountyPresenterImp;
import com.liu.coolweather.ui.adapter.SelectAdapter;
import com.liu.coolweather.ui.adapter.SelectCity;
import com.liu.coolweather.view.SelectAdapterView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectCityActivity extends BaseActivity implements SelectAdapterView {
    @BindView(R.id.recycler_view)
    RecyclerView recycler;
    SelectAdapter adapter;
    ProvinceCityCountyPresenterImp presenterImp;
    List<SelectCity> selectCityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        ButterKnife.bind(this);
        presenterImp = new ProvinceCityCountyPresenterImp(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);
        adapter = new SelectAdapter(selectCityList);
        recycler.setAdapter(adapter);
        queryProvince();
    }

    private void queryProvince(){
        List<Province> provinceList = DataSupport.findAll(Province.class);
        if (provinceList.size() > 0){
            selectCityList.clear();
            for (Province pr:provinceList){
                SelectCity sc = new SelectCity();
                sc.setName(pr.getName());
                sc.setId(pr.getId());
                selectCityList.add(sc);
            }
            adapter.notifyDataSetChanged();
        }else {
            presenterImp.getProvince();
        }
    }

    @Override
    public void resultProvince(List<SelectCity> provinceList) {
        selectCityList.addAll(provinceList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void resultCity(List<SelectCity> cityList,int position) {

    }

    @Override
    public void resultCounty(List<SelectCity> cityList, int position) {

    }


}

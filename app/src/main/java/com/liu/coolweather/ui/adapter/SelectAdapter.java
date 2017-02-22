package com.liu.coolweather.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liu.coolweather.LzcApplication;
import com.liu.coolweather.R;
import com.liu.coolweather.db.City;
import com.liu.coolweather.db.County;
import com.liu.coolweather.presenter.ProvinceCityCountyPresenterImp;
import com.liu.coolweather.tool.LogTool;
import com.liu.coolweather.ui.SelectCityActivity;
import com.liu.coolweather.view.SelectAdapterView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LIUZICHENG on 2017/2/14.
 */

public class SelectAdapter extends RecyclerView.Adapter<SelectAdapter.ViewHolder> implements SelectAdapterView {
    /*布局一种，数据是三层，
      默认加载省，点击省加载市
      点击市加载县。
      数据源的获取两种情况：第一种是直接加载数据库中的。
      第二种是：请求网络数据并重新加进来的。
        */
    private List<SelectCity> cities;
    ProvinceCityCountyPresenterImp presenterImp;
    private Context context ;
    public SelectAdapter(List<SelectCity> cityList,Context context) {
        this.cities = cityList;
        this.context = context;
        presenterImp = new ProvinceCityCountyPresenterImp(this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_select_city, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.city_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                SelectCity selectCity = cities.get(position);
                switch (selectCity.getDataType()) {
                    case 0://省
                            /*判断是否张开*/
                        if (selectCity.isOpen()) {
                                /*删除市级数据*/
                            for (int i = 0; i < cities.size(); i++) {
                                if (cities.get(i).getProvinceId() != 0 &&
                                        selectCity.getId() == cities.get(i).getProvinceId()) {
                                    cities.remove(cities.get(i));
                                    i--;
                                }
                            }
                            cities.get(position).setOpen(false);
                            notifyDataSetChanged();
                        } else {
                                /*获取市级数据*/
                            List<City> cityList = DataSupport.where("provinceId = ?", String.valueOf(selectCity.getId())).find(City.class);
                            if (cityList.size() > 0) {
                                List<SelectCity> scList = new ArrayList<SelectCity>();
                                for (City c : cityList) {
                                    SelectCity mCity = new SelectCity();
                                    mCity.setDataType(1);
                                    mCity.setName(c.getName());
                                    mCity.setId(c.getId());
                                    mCity.setProvinceId(c.getProvinceId());
                                    scList.add(mCity);
                                }
                                cities.get(position).setOpen(true);
                                cities.addAll(position + 1, scList);
                                notifyDataSetChanged();
                            } else {
//                                v.setEnabled(true);
                                presenterImp.getCity(selectCity.getId(), position);
                            }

                        }
                        break;
                    case 1://市
                        if (selectCity.isOpen()) {
                            //删除县级数据
                            for (int i = 0; i < cities.size(); i++) {
                                if (cities.get(i).getCityId() != 0 &&
                                        selectCity.getId() == cities.get(i).getCityId()) {
                                    cities.remove(cities.get(i));
                                    i--;
                                }
                            }
                            cities.get(position).setOpen(false);
                            notifyDataSetChanged();
                        } else {
                            //获取县级数据
                            List<County> countyList = DataSupport.where("cityId = ? ",
                                    String.valueOf(selectCity.getId())).find(County.class);
                            if (countyList.size() > 0) {
                                List<SelectCity> scList = new ArrayList<SelectCity>();
                                for (County c : countyList) {
                                    SelectCity mCity = new SelectCity();
                                    mCity.setDataType(2);
                                    mCity.setId(c.getId());
                                    mCity.setName(c.getName());
                                    mCity.setWeatherId(c.getWeather_id());
                                    mCity.setCityId(selectCity.getId());
                                    mCity.setProvinceId(selectCity.getProvinceId());
                                    scList.add(mCity);
                                }
                                cities.get(position).setOpen(true);
                                cities.addAll(position + 1, scList);
                                notifyDataSetChanged();
                            } else {
                                presenterImp.getCounty(selectCity.getProvinceId(), selectCity.getId(), position);
//
                            }
                        }
                        break;
                    case 2://县
                        //确定选择的地址。
                        if(context instanceof SelectCityActivity){
                            ((SelectCityActivity)context).setSelectCity(selectCity);
                        }
                        break;
                }

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SelectCity selectCity = cities.get(position);
        holder.city_name.setText(cities.get(position).getName());
        holder.left_image.setVisibility(View.VISIBLE);
        holder.city_name.setPadding(64,64, 0, 64);
        if (selectCity.getDataType() == 1) {
            holder.city_name.setPadding(74,64, 0, 64);
        } else if (selectCity.getDataType() == 2) {
            holder.city_name.setPadding(100, 64, 0, 64);
            holder.left_image.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    @Override
    public void resultProvince(List<SelectCity> provinceList) {

    }

    @Override
    public void resultCity(List<SelectCity> cityList, int position) {
        cities.get(position).setOpen(true);
        cities.addAll(position + 1, cityList);
        notifyDataSetChanged();
    }

    @Override
    public void resultCounty(List<SelectCity> cityList, int position) {
        cities.get(position).setOpen(true);
        cities.addAll(position + 1, cityList);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.city_name)
        TextView city_name;
        @BindView(R.id.left_image)
        ImageView left_image;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            view = itemView;
        }
    }
}

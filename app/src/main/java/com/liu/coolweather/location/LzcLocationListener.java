package com.liu.coolweather.location;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.liu.coolweather.LzcApplication;
import com.liu.coolweather.tool.ToastTool;

public class LzcLocationListener implements BDLocationListener {

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        switch (bdLocation.getLocType()){
            case BDLocation.TypeGpsLocation:
                //定位成功
                bdLocation.getCity();
                break;
            case BDLocation.TypeCriteriaException:
                //定位失败

                break;
            case BDLocation.TypeNetWorkException:
                //网络异常 NetWorkError

                break;
            default:
                ToastTool.Makter(LzcApplication.getContext(),"Error:"+bdLocation.getLocType());
                break;
        }
    }
}
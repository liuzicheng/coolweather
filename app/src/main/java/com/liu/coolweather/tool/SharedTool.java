package com.liu.coolweather.tool;

import android.content.Context;
import android.content.SharedPreferences;

import com.liu.coolweather.LzcApplication;

/**
 * Created by LIUZICHENG on 2016/12/19.
 */

public class SharedTool {
    public static void saveString(String key,String data){
        SharedPreferences.Editor editor =
                LzcApplication.getContext().getSharedPreferences(LzcApplication.getContext().getPackageName(), Context.MODE_PRIVATE).edit();
        editor.putString(key,data);
        editor.apply();
    }

    public static String  readString(String key){
        SharedPreferences editor =
                LzcApplication.getContext().getSharedPreferences(LzcApplication.getContext().getPackageName(), Context.MODE_PRIVATE);
        return editor.getString(key,"");
    }
    public static String  readString(String key,String defaultValue){
        SharedPreferences editor =
                LzcApplication.getContext().getSharedPreferences(LzcApplication.getContext().getPackageName(), Context.MODE_PRIVATE);
        return editor.getString(key,defaultValue);
    }
}

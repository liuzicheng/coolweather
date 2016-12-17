package com.liu.coolweather.tool;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by LIUZICHENG on 2016/12/17.
 */

public class ToastTool {
    public static void Makter(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }

}

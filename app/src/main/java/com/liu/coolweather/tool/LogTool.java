package com.liu.coolweather.tool;

import android.util.Log;

import static com.liu.coolweather.LzcApplication.getContext;

/**
 * Created by LIUZICHENG on 2016/12/17.
 */

public class LogTool {

    protected static final String TAG = getContext().getPackageName();

    private static Boolean isLog = true;

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        if (isLog) {
            Log.d(tag, msg);
        }
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        if (isLog) {
            Log.e(tag, msg);
        }
    }

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void i(String tag, String msg) {
        if (isLog) {
            Log.i(tag, msg);
        }
    }

    public static void w(String msg) {
        w(TAG, msg);
    }

    public static void w(String tag, String msg) {
        if (isLog) {
            Log.w(tag, msg);
        }
    }

}

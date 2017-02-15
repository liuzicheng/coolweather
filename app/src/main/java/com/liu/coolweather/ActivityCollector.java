package com.liu.coolweather;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LIUZICHENG on 2017/2/3.
 */

public class ActivityCollector {
    private static List<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity){
        if (activityList != null){
            activityList.remove(activity);
        }
    }

    public static void finishAll(){
        for (Activity activity :activityList){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}

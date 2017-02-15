package com.liu.coolweather;

import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.liu.coolweather.tool.LogTool;

/**
 * Created by LIUZICHENG on 2016/12/17.
 * 基类
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogTool.d(getClass().getName(),getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);

    }
    /*kill掉进程 只能杀自己
    * android.os.Process.killProcess(Process.myPid());
    * */
}

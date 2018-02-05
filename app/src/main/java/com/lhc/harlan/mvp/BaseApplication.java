package com.lhc.harlan.mvp;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;


import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;


import com.lhc.harlan.mvp.dagger.component.AppComponent;

import com.lhc.harlan.mvp.dagger.component.DaggerAppComponent;
import com.lhc.harlan.mvp.dagger.module.AppModule;

import java.util.HashSet;
import java.util.Set;



/**
 * SmartCommunity-com.BIT.fuxingwuye.base
 * 作者： YanwuTang
 * 时间： 2017/6/30.
 */

public class BaseApplication extends Application {

    private static final String TAG = "BasicApplication";

    private static BaseApplication instance;
    private Set<Activity> allActivities;

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;

    private String token = "";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;






    }

    public static BaseApplication getInstance() {
        if (instance == null) {
            Log.e("BasicApplication",
                    " 程序出错,BasicApplication instance is null");
        }
        return instance;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    public static AppComponent getComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();
    }

    @Override
    public void onTerminate() {
        // 程序终止的时候执行
        super.onTerminate();
    }


    /**
     * 添加activity
     */
    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    /**
     * 移除activity
     */
    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    /**
     * 退出app
     */
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    if (!act.isFinishing()) {
                        act.finish();
                    }
                }
            }
        }
//        android.os.Process.killProcess(android.os.Process.myPid());
//        System.exit(0);
    }

    public boolean isPhoneEnalbe(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        return false;
    }
    public boolean callPhoneEnalbe(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        return false;
    }
    public boolean isFileEnalbe(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        return false;
    }


}

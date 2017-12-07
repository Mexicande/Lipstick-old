package com.deerlive.zhuawawa;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.deerlive.zhuawawa.utils.LogUtils;
import com.hss01248.dialog.StyledDialog;
import com.mob.MobSDK;
import com.tencent.bugly.crashreport.CrashReport;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2017/10/23.
 * Author: XuDeLong
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(this);
        LogUtils.init(getInstance());
        StyledDialog.init(this);
       MobSDK.init(this,"22df8db419014","0f69e4d8a099b8426a58a16fccb8e88e");
       // MobSDK.init(this,"22df8db419014","0f69e4d8a099b8426a58a16fccb8e88e");
        CrashReport.initCrashReport(getApplicationContext(), "f973cfa9b3", false);
        //JPushInterface.setDebugMode(true);
        //JPushInterface.init(this);
    }
    public static MyApplication getInstance(){
        return instance;
    }
}

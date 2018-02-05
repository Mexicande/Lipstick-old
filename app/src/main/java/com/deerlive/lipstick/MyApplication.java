package com.deerlive.lipstick;

import android.app.Application;
import android.util.DisplayMetrics;

import com.blankj.utilcode.util.Utils;
import com.deerlive.lipstick.utils.LogUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.hss01248.dialog.StyledDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.meituan.android.walle.WalleChannelReader;
import com.mob.MobSDK;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;
import com.uuch.adlibrary.utils.DisplayUtil;

import static com.deerlive.lipstick.common.Api.APP_VER;
import static com.deerlive.lipstick.common.Api.OS;
import static com.deerlive.lipstick.common.Api.OS_VER;
import static com.deerlive.lipstick.common.Api.QUDAO;


/**
 * Created by Administrator on 2017/10/23.
 * Author: XuDeLong
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    String channel="test";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        // LeakCanary.install(this);

        Utils.init(this);
        LogUtils.init(getInstance());

        initOkGo();

        Fresco.initialize(this);
        initDisplayOpinion();

        StyledDialog.init(this);
        //ShareSDK
        MobSDK.init(this,"241ef37e9c97b","bf5dbc1bbb546283ea4f31b41a7ac8c2");
        //Bugly
        CrashReport.initCrashReport(getApplicationContext(), "591136e336", false);
        //Walle
        channel = WalleChannelReader.getChannel(this.getApplicationContext());
        //友盟
        MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(this,"5a77fa0d8f4a9d45d4000057"
                ,channel));
        //极光推送
        //JPushInterface.setDebugMode(true);
      //  JPushInterface.init(this);
    }

    private void initOkGo() {
        HttpParams params=new HttpParams();

        params.put("os", OS);
        params.put("soft_ver", APP_VER);
        params.put("os_ver", OS_VER);
        params.put("qudao",QUDAO);

        OkGo.getInstance().init(this)
                .addCommonParams(params);
    }
    private void initDisplayOpinion() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        DisplayUtil.density = dm.density;
        DisplayUtil.densityDPI = dm.densityDpi;
        DisplayUtil.screenWidthPx = dm.widthPixels;
        DisplayUtil.screenhightPx = dm.heightPixels;
        DisplayUtil.screenWidthDip = DisplayUtil.px2dip(getApplicationContext(), dm.widthPixels);
        DisplayUtil.screenHightDip = DisplayUtil.px2dip(getApplicationContext(), dm.heightPixels);
    }

    public static MyApplication getInstance(){
        return instance;
    }
}

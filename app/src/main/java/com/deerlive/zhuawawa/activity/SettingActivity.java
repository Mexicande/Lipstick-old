package com.deerlive.zhuawawa.activity;

import android.app.ActivityManager;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.deerlive.zhuawawa.MainActivity;
import com.deerlive.zhuawawa.R;
import com.deerlive.zhuawawa.base.BaseActivity;
import com.deerlive.zhuawawa.common.Api;
import com.deerlive.zhuawawa.common.WebviewActivity;
import com.deerlive.zhuawawa.intf.OnRequestDataListener;
import com.deerlive.zhuawawa.model.Banner;
import com.hss01248.dialog.StyledDialog;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;

public class SettingActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {
    @Bind(R.id.checkbox_bgm)
    CheckBox mCheckBoxBgm;
    @Bind(R.id.checkbox_yinxiao)
    CheckBox mCheckYinXiao;
    private String token;
    public void goBack(View v){
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        token = SPUtils.getInstance().getString("token");
        if("1".equals(SPUtils.getInstance().getString("bgm"))){
            mCheckBoxBgm.setChecked(true);
        }else {
            mCheckBoxBgm.setChecked(false);
        }
        if("1".equals(SPUtils.getInstance().getString("yinxiao"))){
            mCheckYinXiao.setChecked(true);
        }else {
            mCheckYinXiao.setChecked(false);
        }
        mCheckBoxBgm.setOnCheckedChangeListener(this);
        mCheckYinXiao.setOnCheckedChangeListener(this);
    }

    public void logout(View v){
        SPUtils.getInstance().remove("token");
        ActivityUtils.finishAllActivities();
        ActivityUtils.startActivity(LoginActivity.class);
    }

    public void gamehelp(View v){
        Bundle temp = new Bundle();
        temp.putString("title",getResources().getString(R.string.set_helps));
        temp.putString("jump", Api.URL_GAME_HELP+"&token="+token);
        ActivityUtils.startActivity(temp,WebviewActivity.class);
    }

    public void yaoqing(View v){
        Bundle temp = new Bundle();
        temp.putString("title",getResources().getString(R.string.yaoqing_me));
        temp.putString("jump", Api.URL_GAME_YAOQING+"&token="+token);
        ActivityUtils.startActivity(temp,WebviewActivity.class);
    }

    public void yaoqingma(View v){
        Bundle temp = new Bundle();
        temp.putString("title",getResources().getString(R.string.yaoqing_input));
        temp.putString("jump", Api.URL_GAME_YAOQINGMA+"&token="+token);
        ActivityUtils.startActivity(temp,WebviewActivity.class);
    }

    public void feedback(View v){
        Bundle temp = new Bundle();
        temp.putString("title",getResources().getString(R.string.feadback));
        temp.putString("jump", Api.URL_GAME_FEEDBACK+"&token="+token);
        ActivityUtils.startActivity(temp,WebviewActivity.class);
    }

    public void checkUpdate(View v){
        JSONObject params = new JSONObject();
        try {
            String versionCode = getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName;
            params.put("ver_num",versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        Api.checkUpdate(this,params , new OnRequestDataListener() {
            @Override
            public void requestSuccess(int code, JSONObject data) {
                JSONObject info = data.getJSONObject("data");
                if(!StringUtils.isEmpty(info.getString("package"))){
                    checkUpgrade(info.getString("package"),info.getString("description"));
                }
            }

            @Override
            public void requestFailure(int code, String msg) {
                toast(msg);
            }
        });
    }


    private void checkUpgrade(final String downloadUrl,String mes) {
         new MaterialDialog.Builder(this)
                .title(R.string.set_update)
                .content(mes)
                .positiveText(R.string.agree)
                .negativeText(R.string.disagree)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri uri = Uri.parse(downloadUrl);
                        intent.setData(uri);
                        startActivity(intent);
                    }
                })
                .show();
    }

    public void aboutUs(View v){
        Bundle temp = new Bundle();
        temp.putString("title",getResources().getString(R.string.about_us));
        temp.putString("jump", Api.URL_GAME_ABOUT+"&token="+token);
        ActivityUtils.startActivity(temp,WebviewActivity.class);
    }



    @Override
    public int getLayoutResource() {
        return R.layout.activity_setting;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.checkbox_bgm:
                if(isChecked){
                    SPUtils.getInstance().put("bgm","1");
                }else {
                    SPUtils.getInstance().put("bgm","0");
                }
                break;
            case R.id.checkbox_yinxiao:
                if(isChecked){
                    SPUtils.getInstance().put("yinxiao","1");
                }else {
                    SPUtils.getInstance().put("yinxiao","0");
                }
                break;
        }

    }

}

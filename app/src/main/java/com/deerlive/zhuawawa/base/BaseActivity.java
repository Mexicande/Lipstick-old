package com.deerlive.zhuawawa.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.SnackbarUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.deerlive.zhuawawa.R;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/23.
 * Author: XuDeLong
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Boolean active = true;
    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        ButterKnife.bind(this);
    }
    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }

    public void toast(String mes){
        ToastUtils.showShort(mes);
    }
    public void showSnake(String msg){
        SnackbarUtils.with(getWindow().getDecorView()).setBgColor(getResources().getColor(R.color.shape2)).setMessage(msg).show();
    }
    public abstract int getLayoutResource();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
        active = false;
    }
}

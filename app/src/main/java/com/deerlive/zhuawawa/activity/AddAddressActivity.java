package com.deerlive.zhuawawa.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.deerlive.zhuawawa.R;
import com.deerlive.zhuawawa.base.BaseActivity;

public class AddAddressActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_add_address;
    }

    public void goBack(View view){
        finish();
    }

}

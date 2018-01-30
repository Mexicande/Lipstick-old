package com.deerlive.zhuawawa.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SPUtils;
import com.deerlive.zhuawawa.R;
import com.deerlive.zhuawawa.adapter.AdressAdapter;
import com.deerlive.zhuawawa.base.BaseActivity;
import com.deerlive.zhuawawa.common.Api;
import com.deerlive.zhuawawa.intf.OnRequestDataListener;
import com.deerlive.zhuawawa.model.AddressBean;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;

public class ShouhuoActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.recycler)
    RecyclerView recycler;
    private String mToken;

    private AdressAdapter adressAdapter;

    public void goBack(View v) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTitle.setText(R.string.user_address);
        ivAdd.setVisibility(View.VISIBLE);
        mToken = SPUtils.getInstance().getString("token");
        initRecycler();
        initDate();
        setListener();
    }

    private void setListener() {
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.startActivity(AddAddressActivity.class);
            }
        });
    }

    private void initRecycler() {
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adressAdapter = new AdressAdapter(null);
        recycler.setAdapter(adressAdapter);

    }

    private void initDate() {
        Map<String,String>p=new HashMap<>();
        p.put("token", mToken);
        Api.getShouHuoLocation(this, p, new OnRequestDataListener() {
            @Override
            public void requestSuccess(int code, JSONObject data) {
                AddressBean adressBean = JSON.parseObject(data.toString(), AddressBean.class);
                adressAdapter.addData(adressBean.getAddr());
            }

            @Override
            public void requestFailure(int code, String msg) {
                toast(msg);
            }
        });
    }

    Dialog d;

    public void edit(View v) {

       /*         JSONObject p = new JSONObject();
                p.put("token", mToken);
                p.put("delivery_name", mShr);
                p.put("delivery_mobile", mLxfs);
                p.put("delivery_addr", mSh);
        Api.setShouHuoLocation(ShouhuoActivity.this, p, new OnRequestDataListener() {
            @Override
            public void requestSuccess(int code, JSONObject data) {
                toast(data.getString("descrp"));
                if (d != null) {
                    d.dismiss();
                }
            }

            @Override
            public void requestFailure(int code, String msg) {
                toast(msg);
            }
        });*/
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_shouhuo;
    }


}

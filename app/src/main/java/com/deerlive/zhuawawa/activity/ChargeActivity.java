package com.deerlive.zhuawawa.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.deerlive.zhuawawa.R;
import com.deerlive.zhuawawa.adapter.MessageRecyclerListAdapter;
import com.deerlive.zhuawawa.adapter.PayMethodRecyclerListAdapter;
import com.deerlive.zhuawawa.base.BaseActivity;
import com.deerlive.zhuawawa.common.Api;
import com.deerlive.zhuawawa.common.SplashActivity;
import com.deerlive.zhuawawa.intf.OnRecyclerViewItemClickListener;
import com.deerlive.zhuawawa.intf.OnRequestDataListener;
import com.deerlive.zhuawawa.model.PayMethod;
import com.deerlive.zhuawawa.model.PayModel;
import com.deerlive.zhuawawa.pay.alipay.Alipay;
import com.deerlive.zhuawawa.pay.alipay.PayResult;
import com.deerlive.zhuawawa.pay.wechat.Wechat;
import com.deerlive.zhuawawa.utils.LogUtils;
import com.deerlive.zhuawawa.view.GridSpaceItemDecoration;
import com.deerlive.zhuawawa.view.SpaceItemDecoration;
import com.deerlive.zhuawawa.view.popup.EasyPopup;
import com.hss01248.dialog.StyledDialog;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

public class ChargeActivity extends BaseActivity {

    @Bind(R.id.pay_method_list)
    RecyclerView mPayMethodList;
    @Bind(R.id.checkbox_wechat)
    CheckBox mCheckboxWechat;
    @Bind(R.id.checkbox_zfb)
    CheckBox mCheckboxZfb;
    @Bind(R.id.my_balance_text)
    TextView mMybalanceText;
    @Bind(R.id.pay_container)
    LinearLayout mChargeContainer;
    private SwitchHandler mHandler = new SwitchHandler(this);

    private EasyPopup mCirclePop;
    private String mToken;
    private String mBalance;
    private int mCur = -1;
    private static final int SDK_PAY_FLAG = 1;
    private String payMethod = "wechat";
    private ArrayList<PayMethod.PricesBean> mPayMethodData = new ArrayList<>();
    private PayMethodRecyclerListAdapter mPaymethidAdapter;
    private String selectMoney;
    private String currentMoney;
    private String myPayWay="";
    private String paytype_id="";

    public static void launch(Context context) {
        context.startActivity(new Intent(context, ChargeActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToken = SPUtils.getInstance().getString("token");
        mBalance = SPUtils.getInstance().getString("balance");
        mMybalanceText.setText(mBalance);
        mPaymethidAdapter = new PayMethodRecyclerListAdapter(mPayMethodData);
        GridLayoutManager m = new GridLayoutManager(this,2);
        mPayMethodList.addItemDecoration(new GridSpaceItemDecoration(SizeUtils.dp2px(5)));
        mPayMethodList.setLayoutManager(m);
        mPayMethodList.setAdapter(mPaymethidAdapter);
        initData();
        initEasyPopup();
        setListener();
    }

    private void setListener() {

        mPaymethidAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mCur =Integer.parseInt(mPayMethodData.get(position).getId());
            }
        });
    }

    private void initEasyPopup() {
        mCirclePop = new EasyPopup(this)
                .setContentView(R.layout.pay_way_item)
                .setAnimationStyle(R.style.BannerStyle)
                //是否允许点击PopupWindow之外的地方消失
                .setFocusAndOutsideEnable(true)
                .setBackgroundDimEnable(true)
                .setDimValue(0.4f)
                .createPopup();

    }

    public void ZfbC(View v){
        mCheckboxZfb.setChecked(true);
        mCheckboxWechat.setChecked(false);
        payMethod = "zfb";
        beigin_pay();
    }

    public void wechatC(View v){
        mCheckboxZfb.setChecked(false);
        mCheckboxWechat.setChecked(true);
        payMethod = "wechat";
        beigin_pay();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    ArrayList<PayModel> payModels = new ArrayList<>();
    ArrayList<CheckBox> cbs = new ArrayList<>();
    private void initData() {

        Api.getPayMethod(this, new HashMap<String, String>(), new OnRequestDataListener() {
            @Override
            public void requestSuccess(int code, JSONObject data) {
                mPayMethodData.clear();
                PayMethod payMethod = JSON.parseObject(data.toString(), PayMethod.class);
              /*  for(int i= 0;i<list.size();i++){
                    JSONObject t = list.getJSONObject(i);
                    PayMethod m1 = new PayMethod();
                    m1.setCoin(t.getString("diamond_num"));
                    m1.setPrice(t.getString("money_num"));
                    m1.setId(t.getString("id"));
                    m1.setIf_check("0");
                    if(i == 0){
                        m1.setIf_check("1");
                        mCur = 0;
                    }
                    mPayMethodData.add(payMethod.getPrices());
                }*/
                  mPaymethidAdapter.addData(payMethod.getPrices());

            }

            @Override
            public void requestFailure(int code, String msg) {
                toast(msg);
            }
        });

        JSONObject p = new JSONObject();
        p.put("token",mToken);
        Api.getPayType(this, p, new OnRequestDataListener() {
            @Override
            public void requestSuccess(int code, JSONObject data) {
                JSONArray list = data.getJSONArray("data");

                for(int i= 0;i<list.size();i++){
                    PayModel model = new PayModel();
                    model.setId(list.getJSONObject(i).getString("id"));
                    model.setIcon(list.getJSONObject(i).getString("icon"));
                    model.setName(list.getJSONObject(i).getString("name"));
                    model.setType(list.getJSONObject(i).getString("type"));
                    payModels.add(model);
                }

                insertPayItem(payModels);
            }

            @Override
            public void requestFailure(int code, String msg) {
                toast(msg);
            }
        });


    }

    private void insertPayItem(ArrayList<PayModel> payModels) {
        for(int i = 0 ;i<payModels.size();i++){
            LinearLayout item = (LinearLayout)LayoutInflater.from(this).inflate(R.layout.pay_item,null);
            ImageView mImage =(ImageView) item.findViewById(R.id.pay_icon);
            TextView pay_name = (TextView)item.findViewById(R.id.pay_name);
            item.setTag(payModels.get(i).getId());
            CheckBox cb = (CheckBox)item.findViewById(R.id.checkbox);
            if(i == 0){
                cb.setChecked(true);
                myPayWay = payModels.get(i).getName();
                paytype_id = payModels.get(i).getId();
            }
            cbs.add(cb);
            Glide.with(this).load(payModels.get(i).getIcon())
                    .into(mImage);
            pay_name.setText(payModels.get(i).getName());
            mChargeContainer.addView(item);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkPayWay(view);
                }
            });
        }
    }

    private void beigin_pay(){
        if(mCur == -1){
            toast(getResources().getString(R.string.data_error));
            return;
        }
        JSONObject params = new JSONObject();
        params.put("token",mToken);
        params.put("item_id",mPayMethodData.get(mCur).getId());
        params.put("paytype_id",paytype_id);
        Api.beginPay(this, params, new OnRequestDataListener() {
            @Override
            public void requestSuccess(int code, JSONObject data) {

                String className = data.getString("class_name");
                switch (className){
                    case "alipay_app":
                        String payInfo = data.getString("request");
                        Alipay alipay = new Alipay(ChargeActivity.this);
                        alipay.pay(payInfo);
                        alipay.setHander(mHandler);
                        break;
                    case "wxpay_app":
                        JSONObject payInfo1 = data.getJSONObject("request");
                        Wechat wechat = new Wechat(ChargeActivity.this);
                        wechat.pay(payInfo1.toJSONString());
                        break;
                    default:
                        String payInfo2 = data.getString("request");
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri uri = Uri.parse(payInfo2);
                        intent.setData(uri);
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void requestFailure(int code, String msg) {
                toast(msg);
            }
        });

    }

    private void checkPayWay(View view) {
        String id = (String)view.getTag();
        for(int i =0;i<payModels.size();i++){
            cbs.get(i).setChecked(false);
            if(payModels.get(i).getId().equals(id)){
                cbs.get(i).setChecked(true);
                myPayWay = payModels.get(i).getName();
                paytype_id = payModels.get(i).getId();
            }
        }
    }

    public void goBack(View v){
        finish();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_charge;
    }


  /*  private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    *//**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     *//*
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(ChargeActivity.this, "支付成功", Toast.LENGTH_SHORT).show();

                        int b = Integer.parseInt(mPayMethodData.get(mCur).getDiamond_num()) + Integer.parseInt(mBalance);
                        mMybalanceText.setText(b+"");

                        SPUtils.getInstance().put("balance",mBalance);
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(ChargeActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(ChargeActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };*/

    private static class SwitchHandler extends Handler {

        private WeakReference<ChargeActivity> mWeakReference;

        SwitchHandler(ChargeActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            ChargeActivity activity = mWeakReference.get();
            if (activity != null) {
                switch (msg.what) {
                    case SDK_PAY_FLAG: {
                        PayResult payResult = new PayResult((String) msg.obj);
                        /**
                         * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                         * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                         * docType=1) 建议商户依赖异步通知
                         */
                        String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                        String resultStatus = payResult.getResultStatus();
                        // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                        if (TextUtils.equals(resultStatus, "9000")) {
                            Toast.makeText(activity, "支付成功", Toast.LENGTH_SHORT).show();

                            int b = Integer.parseInt(activity.mPayMethodData.get(activity.mCur).getDiamond_num()) + Integer.parseInt(activity.mBalance);
                            activity.mMybalanceText.setText(b + "");

                            SPUtils.getInstance().put("balance", activity.mBalance);
                        } else {
                            // 判断resultStatus 为非"9000"则代表可能支付失败
                            // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                            if (TextUtils.equals(resultStatus, "8000")) {
                                Toast.makeText(activity, "支付结果确认中", Toast.LENGTH_SHORT).show();

                            } else {
                                // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                                Toast.makeText(activity, "支付失败", Toast.LENGTH_SHORT).show();
                            }
                        }
                        break;
                    }
                    default:
                        break;
                }

            }
        }
    }

}

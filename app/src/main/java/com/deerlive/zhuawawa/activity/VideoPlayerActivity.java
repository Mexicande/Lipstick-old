package com.deerlive.zhuawawa.activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.SPUtils;
import com.bumptech.glide.Glide;
import com.deerlive.zhuawawa.R;
import com.deerlive.zhuawawa.adapter.PayMethodRecyclerListAdapter;
import com.deerlive.zhuawawa.base.BaseActivity;
import com.deerlive.zhuawawa.common.Api;
import com.deerlive.zhuawawa.intf.OnRecyclerViewItemClickListener;
import com.deerlive.zhuawawa.intf.OnRequestDataListener;
import com.deerlive.zhuawawa.model.DanmuMessage;
import com.deerlive.zhuawawa.model.PayModel;
import com.deerlive.zhuawawa.pay.alipay.Alipay;
import com.deerlive.zhuawawa.pay.alipay.PayResult;
import com.deerlive.zhuawawa.pay.wechat.Wechat;
import com.hss01248.dialog.StyledDialog;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

import java.util.ArrayList;

import butterknife.Bind;

public class VideoPlayerActivity extends BaseActivity{

    TXLivePlayer mLivePlayer;
    TXCloudVideoView mPlayView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(Window.FEATURE_NO_TITLE);
        initData();
    }


    private void initData() {
        Bundle data = getIntent().getExtras();
        if(data == null){
            toast(getString(R.string.net_error));
            finish();
            return;
        }
        DanmuMessage d = (DanmuMessage) data.getSerializable("item");
        initTencentPlayer(d);
    }
    private void initTencentPlayer(DanmuMessage d) {
        //mPlayerView即step1中添加的界面view
        mPlayView = (TXCloudVideoView) findViewById(R.id.player_surface);
        //创建player对象
        mLivePlayer = new TXLivePlayer(this);
        //关键player对象与界面view
        mLivePlayer.setPlayerView(mPlayView);
        mLivePlayer.setRenderMode(TXLiveConstants.RENDER_MODE_FULL_FILL_SCREEN);
        mLivePlayer.startPlay(d.getId(),TXLivePlayer.PLAY_TYPE_VOD_MP4);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mLivePlayer.stopPlay(true); // true代表清除最后一帧画面
        mPlayView.onDestroy();
    }


    @Override
    public int getLayoutResource() {
        return R.layout.activity_video_player;
    }
}

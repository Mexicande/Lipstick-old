package com.deerlive.lipstick.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deerlive.lipstick.R;
import com.deerlive.lipstick.adapter.RecordZjRecyclerListAdapter;
import com.deerlive.lipstick.base.BaseFragment;
import com.deerlive.lipstick.common.Api;
import com.deerlive.lipstick.intf.OnRequestDataListener;
import com.deerlive.lipstick.model.DanmuMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/10/30.
 * Author: XuDeLong
 * 抓奖抓住记录
 */

public class RecordZjFragment extends BaseFragment {
    private String mArgument; //deviceid
    private ArrayList<DanmuMessage> mRecordZjDate = new ArrayList<>();
    private RecordZjRecyclerListAdapter mRecordZjAdapter;


    @Bind(R.id.record_zhua_list)
    RecyclerView mRecordZhuaList;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null){
            mArgument = bundle.getString("params");
        }else{
            toast(getResources().getString(R.string.net_error));
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecordZjAdapter = new RecordZjRecyclerListAdapter(mRecordZjDate);
        LinearLayoutManager m = new LinearLayoutManager(getContext());
        m.setOrientation(LinearLayoutManager.VERTICAL);
        mRecordZhuaList.setLayoutManager(m);
        mRecordZhuaList.setAdapter(mRecordZjAdapter);

        //getData();
    }

    private void getData() {

        Map<String,String> params=new HashMap<>();
        params.put("deviceid",mArgument);
        params.put("limit_begin","0");
        params.put("limit_num",20+"");
        Api.getLatestDeviceRecord(getContext(), params, new OnRequestDataListener() {
            @Override
            public void requestSuccess(int code, JSONObject data) {
                JSONArray info = data.getJSONArray("info");
                mRecordZjDate.clear();
                for(int i = 0;i<info.size();i++){
                    JSONObject t = info.getJSONObject(i);
                    DanmuMessage item1 = new DanmuMessage();
                    item1.setUid(t.getString("uid"));
                    item1.setUserName(t.getString("user_nicename"));
                    item1.setAvator(t.getString("avatar"));
                    item1.setMessageContent(t.getString("play_time"));
                    mRecordZjDate.add(item1);
                }
                mRecordZjAdapter.setNewData(mRecordZjDate);
            }

            @Override
            public void requestFailure(int code, String msg) {
                toast(msg);

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){

        } else {
            getData();
        }
    }

    /**
     * 传入需要的参数，设置给arguments
     * @param params
     * @return
     */
    public static RecordZjFragment newInstance(String params)
    {
        Bundle bundle = new Bundle();
        bundle.putString("params", params);
        RecordZjFragment contentFragment = new RecordZjFragment();
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_zhongjiang_record;
    }


}

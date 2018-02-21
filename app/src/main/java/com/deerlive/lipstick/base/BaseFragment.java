package com.deerlive.lipstick.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.deerlive.lipstick.utils.ToastUtils;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/23.
 * Author: XuDeLong
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRootView = inflater.inflate(getLayoutResource(), container, false);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    public void toast(String mes){
        ToastUtils.showShort(mes);
    }
    public abstract int getLayoutResource();
}

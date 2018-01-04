package com.deerlive.zhuawawa.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by fengjh on 16/7/31.
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //不是第一个的格子都设一个左边和底部的间距
        outRect.left = space;
        outRect.top = 20;
        outRect.bottom = 20;
        outRect.right = 0;
        if(parent.getChildLayoutPosition(view)%2 == 0){
            outRect.right = 5;
            outRect.top = 20;
            outRect.bottom = 20;
            outRect.left = space;
        }else{
            outRect.left = 5;
            outRect.top = 20;
            outRect.bottom = 20;
            outRect.right = 0;
        }
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.left = 0;
            outRect.bottom = 20;
            outRect.right = 0;
            outRect.top = 20;
        }
    }
}
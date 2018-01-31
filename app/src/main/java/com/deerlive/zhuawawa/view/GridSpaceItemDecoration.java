package com.deerlive.zhuawawa.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by apple on 2018/1/29.
 */

public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public GridSpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //不是第一个的格子都设一个左边和底部的间距
        outRect.left = 0;
        outRect.top = 0;
        outRect.bottom = 20;
        outRect.right = 0;

        if(parent.getChildLayoutPosition(view)%2 == 0){
            outRect.right = 10;
            outRect.top = 0;
            outRect.bottom = 20;
            outRect.left = 25;
        }else{
            outRect.left = 10;
            outRect.top = 0;
            outRect.bottom = 20;
            outRect.right = 25;
        }
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.left = 0;
            outRect.bottom = 20;
            outRect.right = 0;
            outRect.top = 0;
        }else {
            if(parent.getChildLayoutPosition(view)%2 == 0){
                outRect.right = 10;
                outRect.top = 0;
                outRect.bottom = 20;
                outRect.left = 25;
            }else{
                outRect.left = 10;
                outRect.top = 0;
                outRect.bottom = 20;
                outRect.right = 25;
            }
        }


      /*  if(space!=0){
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.left = 0;
                outRect.bottom = 20;
                outRect.right = 0;
                outRect.top = 0;
            }
        }*/
    }


}

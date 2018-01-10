package com.deerlive.zhuawawa.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deerlive.zhuawawa.R;

import java.util.ArrayList;

/**
 * Created by apple on 2018/1/9.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<String> mDatas;

    public MyAdapter(Context mContext, ArrayList<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.textview_item,parent,false));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final  int tempPos = position%(mDatas.size());
        holder.textView.setText(mDatas.get(tempPos));

    }

    @Override
    public int getItemCount() {
        return 100000;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_recyclerview);
        }

    }
}

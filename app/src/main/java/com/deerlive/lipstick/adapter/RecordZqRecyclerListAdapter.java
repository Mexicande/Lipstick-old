package com.deerlive.lipstick.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.deerlive.lipstick.R;
import com.deerlive.lipstick.common.GlideCircleTransform;
import com.deerlive.lipstick.intf.OnRecyclerViewItemClickListener;
import com.deerlive.lipstick.model.DanmuMessage;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RecordZqRecyclerListAdapter  extends BaseQuickAdapter<DanmuMessage,BaseViewHolder> {

    public RecordZqRecyclerListAdapter( List<DanmuMessage> data) {

        super(R.layout.item_record_zq, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DanmuMessage item) {

        helper.setText(R.id.zq_name,item.getUserName())
                .setText(R.id.zq_result,item.getMessageContent())
                .setText(R.id.zq_time,item.getUid());
        Glide.with(mContext).load(item.getAvator())
                .into((ImageView) helper.getView(R.id.zq_avator));
    }


}

package com.deerlive.lipstick.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.deerlive.lipstick.R;
import com.deerlive.lipstick.model.DanmuMessage;

import java.util.List;


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

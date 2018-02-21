package com.deerlive.lipstick.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.deerlive.lipstick.R;
import com.deerlive.lipstick.model.DanmuMessage;

import java.util.List;



public class RecordCoinRecyclerListAdapter extends BaseQuickAdapter<DanmuMessage,BaseViewHolder> {


    public RecordCoinRecyclerListAdapter( List<DanmuMessage> data) {
        super(R.layout.item_record_coin, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DanmuMessage item) {
        helper.setText(R.id.coin_name,item.getUserName())
                .setText(R.id.coin_result,item.getMessageContent())
                .setText(R.id.coin_time,item.getUid());
    }
}

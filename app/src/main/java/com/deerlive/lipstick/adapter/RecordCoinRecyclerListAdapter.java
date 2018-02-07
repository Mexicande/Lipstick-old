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
import com.deerlive.lipstick.intf.OnRecyclerViewItemClickListener;
import com.deerlive.lipstick.model.DanmuMessage;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/*DanmuMessage t = mItems.get(position);
        temp.coin_name.setText(t.getUserName());
        temp.coin_result.setText(t.getMessageContent());
        temp.coin_time.setText(t.getUid());*/

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

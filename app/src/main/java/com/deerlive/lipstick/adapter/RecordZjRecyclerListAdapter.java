package com.deerlive.lipstick.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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

  /*  DanmuMessage t = mItems.get(position);
            temp.mZjName.setText(t.getUserName());
            temp.mZjTime.setText(t.getMessageContent());
            Glide.with(mContext).load(t.getAvator())
            .error(R.mipmap.logo)
            .transform(new GlideCircleTransform(mContext))
            .into(temp.mZjAvator);
*/

public class RecordZjRecyclerListAdapter extends BaseQuickAdapter<DanmuMessage,BaseViewHolder> {

    public RecordZjRecyclerListAdapter( List<DanmuMessage> data) {
        super( R.layout.item_record_zj,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DanmuMessage item) {
        helper.setText(R.id.zj_name,item.getUserName())
                .setText(R.id.zj_time,item.getMessageContent());
        Glide.with(mContext).load(item.getAvator())
                .into((ImageView) helper.getView(R.id.zj_avator));
    }
}

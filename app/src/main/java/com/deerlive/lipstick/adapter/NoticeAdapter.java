package com.deerlive.lipstick.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.deerlive.lipstick.R;
import com.deerlive.lipstick.model.NoticeMessageBean;

import java.util.List;


/**
 * Created by apple on 2017/6/9.
 */

public class NoticeAdapter extends BaseQuickAdapter<NoticeMessageBean.InfoBean,BaseViewHolder> {

    public NoticeAdapter(List<NoticeMessageBean.InfoBean> data) {
        super(R.layout.notice_item, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, NoticeMessageBean.InfoBean item) {

        helper.setText(R.id.tv_name,item.getTitle())
                .setText(R.id.last_time,item.getUpdate_time())
                .setText(R.id.tv_content,item.getContent());
        Glide.with(mContext).load(item.getImg())
                .into((ImageView) helper.getView(R.id.iv_image));
    }
}
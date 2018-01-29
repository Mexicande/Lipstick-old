package com.deerlive.zhuawawa.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.deerlive.zhuawawa.R;
import com.deerlive.zhuawawa.model.ZhuaRecordBean;

import java.util.List;

/**
 * Created by apple on 2018/1/29.
 */

public class ZhuaRecordAdapter extends BaseQuickAdapter<ZhuaRecordBean.InfoBean,BaseViewHolder> {


    public ZhuaRecordAdapter(List<ZhuaRecordBean.InfoBean> data) {

        super(R.layout.item_record_zq, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhuaRecordBean.InfoBean item) {
            helper.setText(R.id.zq_name,item.getName())
                    .setText(R.id.zq_time,item.getCreate_time())
                    .setText(R.id.zq_result,item.getStatus());

            Glide.with(mContext).load(item.getList_img())
                .error(R.mipmap.logo)
                .into((ImageView)helper.getView(R.id.zq_avator))
        ;
    }
}

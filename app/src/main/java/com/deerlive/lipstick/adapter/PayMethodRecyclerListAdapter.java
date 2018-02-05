package com.deerlive.lipstick.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.deerlive.lipstick.R;
import com.deerlive.lipstick.model.PayMethod;

import java.util.List;



public class PayMethodRecyclerListAdapter extends BaseQuickAdapter<PayMethod.PricesBean,BaseViewHolder> {



    public PayMethodRecyclerListAdapter(List<PayMethod.PricesBean> data) {
        super(R.layout.item_pay_method, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PayMethod.PricesBean item) {

        helper.setText(R.id.need_coin,item.getDiamond_num())
                .setText(R.id.super_price,item.getMoney_num());

    }
}

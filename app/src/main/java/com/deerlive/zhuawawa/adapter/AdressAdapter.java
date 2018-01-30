package com.deerlive.zhuawawa.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.deerlive.zhuawawa.R;
import com.deerlive.zhuawawa.model.AddressBean;

import java.util.List;


/**
 * Created by apple on 2017/6/9.
 */

public class AdressAdapter extends BaseQuickAdapter<AddressBean.AddrBean,BaseViewHolder> {

    public AdressAdapter(List<AddressBean.AddrBean> data) {
        super(R.layout.address_item, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, AddressBean.AddrBean item) {

        helper.setText(R.id.tv_userName,item.getName())
                .setText(R.id.tv_userPhone,item.getMobile())
                .setText(R.id.tv_address,item.getCity()+item.getAddress());
    }
}
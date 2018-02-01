package com.deerlive.zhuawawa.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.deerlive.zhuawawa.model.Banner;
import com.deerlive.zhuawawa.model.DeviceAndBanner;

/**
 * Created by apple on 2018/1/4.
 */

public class LocalImageHolderView implements Holder<DeviceAndBanner.BannerBean.PicBean> {
    private ImageView imageView;
    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, final int position, DeviceAndBanner.BannerBean.PicBean data) {
        Glide.with(context)
                .load(data.getImg())
                .dontAnimate()
                .centerCrop()
                //.transform(new CenterCrop(context), new GlideRoundTransform(context,10))
                .into(imageView);
        //imageView.setImageResource(data);
    }
}

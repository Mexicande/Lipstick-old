package com.deerlive.lipstick.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.deerlive.lipstick.R;
import com.deerlive.lipstick.common.GlideCircleTransform;
import com.deerlive.lipstick.intf.OnRecyclerViewItemClickListener;
import com.deerlive.lipstick.model.GrabBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class WeiQuRecyclerListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;

    private static final int TYPE_FOOTER = 1;

    private static final int TYPE_ITEM = 2;

    private View mHeaderView;

    private View mFooterView;

    private Context mContext;
    private List<GrabBean.InfoBean> mItems;
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;

    public WeiQuRecyclerListAdapter(Context mContext, List<GrabBean.InfoBean> mVideoItems) {
        this.mContext = mContext;
        this.mItems = mVideoItems;
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderView(position)) {
            return TYPE_HEADER;
        } else if (isFooterView(position)) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    public void addHeaderView(View headerView) {
        if (haveHeaderView()) {
            throw new IllegalStateException("hearview has already exists!");
        } else {
            //避免出现宽度自适应
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            headerView.setLayoutParams(params);
            mHeaderView = headerView;
            notifyItemInserted(0);
        }

    }



    public void addFooterView(View footerView) {
        if (haveFooterView()) {
            throw new IllegalStateException("footerView has already exists!");
        } else {
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            footerView.setLayoutParams(params);
            mFooterView = footerView;
            notifyItemInserted(getItemCount() - 1);
        }
    }

    public boolean haveHeaderView() {
        return mHeaderView != null;
    }

    public boolean haveFooterView() {
        return mFooterView != null;
    }
    private boolean isHeaderView(int position) {
        return haveHeaderView() && position == 0;
    }

    private boolean isFooterView(int position) {
        return haveFooterView() && position == getItemCount() - 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            return new FooterHolder(mFooterView);
        } else if (viewType == TYPE_HEADER) {
            return new HeaderHolder(mHeaderView);
        } else {
            return new MessageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record_wq, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof HeaderHolder) {

        } else if (holder instanceof FooterHolder) {

        } else {
            final MessageViewHolder temp = (MessageViewHolder)holder;
            GrabBean.InfoBean t = mItems.get(position);
            temp.zq_name.setText(t.getName());
            temp.zq_time.setText(t.getPlay_time());
            if(t.getRemoteUid()==1){
                temp.mCheckBoxSelect.setChecked(true);
            }else {
                temp.mCheckBoxSelect.setChecked(false);
            }
            Glide.with(mContext).load(t.getImg())
                    .error(R.mipmap.logo)
                    .transform(new GlideCircleTransform(mContext))
                    .into(temp.zq_avator);
            setGetWay(temp.mImageWay,t.getChange());
            temp.mContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnRecyclerViewItemClickListener!= null){
                        mOnRecyclerViewItemClickListener.onRecyclerViewItemClick(v,position);
                    }
                }
            });

        }
    }

    private void setGetWay(ImageView imageView,int type) {
            if(type==0){
                imageView.setImageResource(R.mipmap.iv_claw);
            }else {
                imageView.setImageResource(R.mipmap.iv_exchange);
            }

    }

    private int getHeadViewSize() {
        return mHeaderView == null ? 0 : 1;
    }
    @Override
    public int getItemCount() {
        int count = (mItems == null ? 0 : mItems.size());
        if (mFooterView != null) {
            count++;
        }
        if (mHeaderView != null) {
            count++;
        }
        return count;
    }


    class HeaderHolder extends RecyclerView.ViewHolder {

        public HeaderHolder(View itemView) {
            super(itemView);
        }
    }

    class FooterHolder extends RecyclerView.ViewHolder {

        public FooterHolder(View itemView) {
            super(itemView);
        }
    }

    class MessageViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_danmu_container)
        CardView mContainer;
        @Bind(R.id.zq_name)
        TextView zq_name;
        @Bind(R.id.zq_avator)
        ImageView zq_avator;
        @Bind(R.id.zq_time)
        TextView zq_time;
        @Bind(R.id.checkbox_select)
        CheckBox mCheckBoxSelect;
        @Bind(R.id.iv_getWay)
        ImageView mImageWay;
        public MessageViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }
}

package com.deerlive.zhuawawa.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.deerlive.zhuawawa.R;
import com.deerlive.zhuawawa.adapter.MyViewPagerAdapter;
import com.deerlive.zhuawawa.base.BaseActivity;
import com.deerlive.zhuawawa.fragment.IntegarFragment;
import com.deerlive.zhuawawa.fragment.StoreDuiHuanFragment;
import com.deerlive.zhuawawa.intf.User_integration;
import com.deerlive.zhuawawa.model.eventbean.IntegarStore;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgePagerTitleView;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static org.greenrobot.eventbus.EventBus.getDefault;

public class RecordStoreActivity extends BaseActivity  {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.magic_indicator)
    MagicIndicator magicIndicator;

    private  List<String> mDataList = new ArrayList<>();
    @Bind(R.id.view_pager)
    ViewPager viewPager;

    String integra="";
    private MyViewPagerAdapter myViewPagerAdapter;
    private FragmentContainerHelper mFragmentContainerHelper = new FragmentContainerHelper();
    private  CommonNavigator commonNavigator;
    public void goBack(View v) {
        finish();
    }
    public static void launch(Context context) {
        context.startActivity(new Intent(context, RecordStoreActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTitle.setText(R.string.integar_store);
        getDefault().register(this);
        mDataList.add("积分: "+0);
        mDataList.add("兑换记录");
        initFragment();
        mFragmentContainerHelper.attachMagicIndicator(magicIndicator);

    }

    private void initFragment() {
        List<Fragment> list = new ArrayList<>();
        list.add(new IntegarFragment());
        list.add(new StoreDuiHuanFragment());
        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(myViewPagerAdapter);
        commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int i) {
                BadgePagerTitleView badgePagerTitleView = new BadgePagerTitleView(context);

                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mDataList.get(i));
                simplePagerTitleView.setNormalColor(Color.parseColor("#999999"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#ED5796"));
                simplePagerTitleView.setTextSize(16);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(i);
                    }
                });
                badgePagerTitleView.setInnerPagerTitleView(simplePagerTitleView);
                return badgePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setColors(Color.parseColor("#ED5796"));
                indicator.setLineWidth(UIUtil.dip2px(context, 100));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        titleContainer.setDividerPadding(UIUtil.dip2px(this, 15));
        titleContainer.setDividerDrawable(getResources().getDrawable(R.drawable.simple_splitter));

        final FragmentContainerHelper fragmentContainerHelper = new FragmentContainerHelper(magicIndicator);
        fragmentContainerHelper.setInterpolator(new OvershootInterpolator(2.0f));
        fragmentContainerHelper.setDuration(300);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                fragmentContainerHelper.handlePageSelected(position);
            }
        });

    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_record_store;
    }

    @Subscribe
    public void updateEvent(IntegarStore msg) {
        if (msg.message != 0) {
            mDataList.clear();
            mDataList.add("积分: " + msg.message);
            mDataList.add("兑换记录");
            commonNavigator.notifyDataSetChanged();
            myViewPagerAdapter.notifyDataSetChanged();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        getDefault().unregister(this);
    }
}

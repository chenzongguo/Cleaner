package cn.njthl.cleaner.ui.activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.jaeger.library.StatusBarUtil;

import androidx.annotation.Nullable;
import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.ui.adapter.CommonFragmentPagerAdapter;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BaseFragment;
import cn.njthl.cleaner.ui.fragment.FragmentFactory;
import cn.njthl.cleaner.ui.presenter.MainAtPresenter;
import cn.njthl.cleaner.ui.view.IMainAtView;
import cn.njthl.cleaner.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;


public class MainActivity extends BaseActivity<IMainAtView, MainAtPresenter> implements ViewPager.OnPageChangeListener, IMainAtView {

    private List<BaseFragment> mFragmentList = new ArrayList<>(4);
    private CommonFragmentPagerAdapter commonFragmentPagerAdapter;
    @BindView(R2.id.ibAddMenu)
    ImageButton mIbAddMenu;
    @BindView(R2.id.vpContent)
    ViewPager mVpContent;

    //底部
    @BindView(R2.id.llMessage)
    LinearLayout mLlMessage;
    @BindView(R2.id.tvMessageNormal)
    TextView mTvMessageNormal;
    @BindView(R2.id.tvMessagePress)
    TextView mTvMessagePress;
    @BindView(R2.id.tvMessageTextNormal)
    TextView mTvMessageTextNormal;
    @BindView(R2.id.tvMessageTextPress)
    TextView mTvMessageTextPress;
    @BindView(R2.id.tvMessageCount)
    public TextView mTvMessageCount;

//    @BindView(R2.id.llContacts)
//    LinearLayout mLlContacts;
//    @BindView(R2.id.tvContactsNormal)
//    TextView mTvContactsNormal;
//    @BindView(R2.id.tvContactsPress)
//    TextView mTvContactsPress;
//    @BindView(R2.id.tvContactsTextNormal)
//    TextView mTvContactsTextNormal;
//    @BindView(R2.id.tvContactsTextPress)
//    TextView mTvContactsTextPress;
//    @BindView(R2.id.tvContactCount)
//    public TextView mTvContactCount;
//    @BindView(R2.id.tvContactRedDot)
//    public TextView mTvContactRedDot;

    @BindView(R2.id.llDiscovery)
    LinearLayout mLlDiscovery;
    @BindView(R2.id.tvDiscoveryNormal)
    TextView mTvDiscoveryNormal;
    @BindView(R2.id.tvDiscoveryPress)
    TextView mTvDiscoveryPress;
    @BindView(R2.id.tvDiscoveryTextNormal)
    TextView mTvDiscoveryTextNormal;
    @BindView(R2.id.tvDiscoveryTextPress)
    TextView mTvDiscoveryTextPress;
    @BindView(R2.id.tvDiscoveryCount)
    public TextView mTvDiscoveryCount;

    @BindView(R2.id.llMe)
    LinearLayout mLlMe;
    @BindView(R2.id.tvMeNormal)
    TextView mTvMeNormal;
    @BindView(R2.id.tvMePress)
    TextView mTvMePress;
    @BindView(R2.id.tvMeTextNormal)
    TextView mTvMeTextNormal;
    @BindView(R2.id.tvMeTextPress)
    TextView mTvMeTextPress;
    @BindView(R2.id.tvMeCount)
    public TextView mTvMeCount;

    @Override
    public void init() {
//        registerBR();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(this, UIUtils.getColor(R.color.assist_green1), 10);
    }

    @Override
    protected void onResume() {
        super.onResume();
        commonFragmentPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void initView() {
//        StatusBarUtil.setTranslucent(this);
//        StatusBarUtil.setColorNoTranslucent(this,UIUtils.getColor(R.color.side_bar_pressed));
        mIbAddMenu.setVisibility(View.GONE);
        mAppBar.setVisibility(View.VISIBLE);
        setToolbarTitle("首页");

        //等待全局数据获取完毕
//        showWaitingDialog(UIUtils.getString(R.string.please_wait));

        //默认选中第一个
        setTransparency();
        mTvMessagePress.getBackground().setAlpha(255);
        mTvMessageTextPress.setTextColor(Color.argb(255, 69, 192, 26));

        //设置ViewPager的最大缓存页面
        mVpContent.setOffscreenPageLimit(2);

        mFragmentList.add(FragmentFactory.getInstance().getHomePageFragment());
//        mFragmentList.add(FragmentFactory.getInstance().getOrderAllocationFragment());
        mFragmentList.add(FragmentFactory.getInstance().getOrderManageFragment());
        mFragmentList.add(FragmentFactory.getInstance().getMeFragment());
        commonFragmentPagerAdapter = new CommonFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mVpContent.setAdapter(commonFragmentPagerAdapter);
    }

    @Override
    public void initListener() {
        mIbAddMenu.setOnClickListener(v -> {
            //显示或隐藏popupwindow
//            View menuView = View.inflate(MainActivity.this, R.layout.menu_main, null);
//            PopupWindow popupWindow = PopupWindowUtils.getPopupWindowAtLocation(menuView, getWindow().getDecorView(), Gravity.TOP | Gravity.RIGHT, UIUtils.dip2Px(5), mAppBar.getHeight() + 30);
//            menuView.findViewById(R.id.tvCreateGroup).setOnClickListener(v1 -> {
//                jumpToActivity(CreateGroupActivity.class);
//                popupWindow.dismiss();
//            });
//            menuView.findViewById(R.id.tvHelpFeedback).setOnClickListener(v1 -> {
//                jumpToWebViewActivity(AppConst.WeChatUrl.HELP_FEED_BACK);
//                popupWindow.dismiss();
//            });
//            menuView.findViewById(R.id.tvAddFriend).setOnClickListener(v1 -> {
//                jumpToActivity(AddFriendActivity.class);
//                popupWindow.dismiss();
//            });
//            menuView.findViewById(R.id.tvScan).setOnClickListener(v1 -> {
//                jumpToActivity(ScanActivity.class);
//                popupWindow.dismiss();
//            });
        });

        mLlMessage.setOnClickListener(v -> bottomBtnClick(v));
//        mLlContacts.setOnClickListener(v -> bottomBtnClick(v));
        mLlDiscovery.setOnClickListener(v -> bottomBtnClick(v));
        mLlMe.setOnClickListener(v -> bottomBtnClick(v));
        mVpContent.setOnPageChangeListener(this);
    }

    @Override
    public void requestPermissionResult(boolean allowPermission) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unRegisterBR();
    }

    /**
     * 获得状态栏的高度
     *
     * @param context
     * @return
     */
    public static int getStatusHeight(Context context) {

        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    public void bottomBtnClick(View view) {
        setTransparency();
        switch (view.getId()) {
            case R.id.llMessage:
                mToolbarTitle.setText("首页");
                mVpContent.setCurrentItem(0, false);
                mTvMessagePress.getBackground().setAlpha(255);
                mTvMessageTextPress.setTextColor(Color.argb(255, 69, 192, 26));
                break;
//            case R.id.llContacts:
//                mAppBar.setVisibility(View.VISIBLE);
//                mToolbarTitle.setText("未完成订单");
//                mVpContent.setCurrentItem(1, false);
//                mTvContactsPress.getBackground().setAlpha(255);
//                mTvContactsTextPress.setTextColor(Color.argb(255, 69, 192, 26));
//                break;
            case R.id.llDiscovery:
                mAppBar.setVisibility(View.VISIBLE);
                mToolbarTitle.setText("订单管理");
                mVpContent.setCurrentItem(1, false);
                mTvDiscoveryPress.getBackground().setAlpha(255);
                mTvDiscoveryTextPress.setTextColor(Color.argb(255, 69, 192, 26));
                break;
            case R.id.llMe:
                mAppBar.setVisibility(View.VISIBLE);
                mToolbarTitle.setText("我的");
                mVpContent.setCurrentItem(2, false);
                mTvMePress.getBackground().setAlpha(255);
                mTvMeTextPress.setTextColor(Color.argb(255, 69, 192, 26));
                break;
        }
    }

    /**
     * 把press图片、文字全部隐藏(设置透明度)
     */
    private void setTransparency() {
        mTvMessageNormal.getBackground().setAlpha(255);
//        mTvContactsNormal.getBackground().setAlpha(255);
        mTvDiscoveryNormal.getBackground().setAlpha(255);
        mTvMeNormal.getBackground().setAlpha(255);
        mTvMessagePress.getBackground().setAlpha(1);
//        mTvContactsPress.getBackground().setAlpha(1);
        mTvDiscoveryPress.getBackground().setAlpha(1);
        mTvMePress.getBackground().setAlpha(1);
        mTvMessageTextNormal.setTextColor(Color.argb(255, 153, 153, 153));
//        mTvContactsTextNormal.setTextColor(Color.argb(255, 153, 153, 153));
        mTvDiscoveryTextNormal.setTextColor(Color.argb(255, 153, 153, 153));
        mTvMeTextNormal.setTextColor(Color.argb(255, 153, 153, 153));
        mTvMessageTextPress.setTextColor(Color.argb(0, 69, 192, 26));
//        mTvContactsTextPress.setTextColor(Color.argb(0, 69, 192, 26));
        mTvDiscoveryTextPress.setTextColor(Color.argb(0, 69, 192, 26));
        mTvMeTextPress.setTextColor(Color.argb(0, 69, 192, 26));
    }

    @Override
    protected MainAtPresenter createPresenter() {
        return new MainAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean isToolbarCanBack() {
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //根据ViewPager滑动位置更改透明度
        int diaphaneity_one = (int) (255 * positionOffset);
        int diaphaneity_two = (int) (255 * (1 - positionOffset));
        switch (position) {
            case 0:
                mTvMessageNormal.getBackground().setAlpha(diaphaneity_one);
                mTvMessagePress.getBackground().setAlpha(diaphaneity_two);
                mTvDiscoveryNormal.getBackground().setAlpha(diaphaneity_two);
                mTvDiscoveryPress.getBackground().setAlpha(diaphaneity_one);
                mTvMessageTextNormal.setTextColor(Color.argb(diaphaneity_one, 153, 153, 153));
                mTvMessageTextPress.setTextColor(Color.argb(diaphaneity_two, 69, 192, 26));
                mTvDiscoveryNormal.setTextColor(Color.argb(diaphaneity_two, 153, 153, 153));
                mTvDiscoveryPress.setTextColor(Color.argb(diaphaneity_one, 69, 192, 26));
                break;
//            case 1:
//                mTvContactsNormal.getBackground().setAlpha(diaphaneity_one);
//                mTvContactsPress.getBackground().setAlpha(diaphaneity_two);
//                mTvDiscoveryNormal.getBackground().setAlpha(diaphaneity_two);
//                mTvDiscoveryPress.getBackground().setAlpha(diaphaneity_one);
//                mTvContactsTextNormal.setTextColor(Color.argb(diaphaneity_one, 153, 153, 153));
//                mTvContactsTextPress.setTextColor(Color.argb(diaphaneity_two, 69, 192, 26));
//                mTvDiscoveryTextNormal.setTextColor(Color.argb(diaphaneity_two, 153, 153, 153));
//                mTvDiscoveryTextPress.setTextColor(Color.argb(diaphaneity_one, 69, 192, 26));
//                break;
            case 1:
                mTvDiscoveryNormal.getBackground().setAlpha(diaphaneity_one);
                mTvDiscoveryPress.getBackground().setAlpha(diaphaneity_two);
                mTvMeNormal.getBackground().setAlpha(diaphaneity_two);
                mTvMePress.getBackground().setAlpha(diaphaneity_one);
                mTvDiscoveryTextNormal.setTextColor(Color.argb(diaphaneity_one, 153, 153, 153));
                mTvDiscoveryTextPress.setTextColor(Color.argb(diaphaneity_two, 69, 192, 26));
                mTvMeTextNormal.setTextColor(Color.argb(diaphaneity_two, 153, 153, 153));
                mTvMeTextPress.setTextColor(Color.argb(diaphaneity_one, 69, 192, 26));
                break;
        }
    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mAppBar.setVisibility(View.VISIBLE);
                mToolbarTitle.setText("首页");
                break;
//            case 1:
//                mAppBar.setVisibility(View.VISIBLE);
//                mToolbarTitle.setText("未完成订单");
//                break;
            case 1:
                mAppBar.setVisibility(View.VISIBLE);
                mToolbarTitle.setText("订单管理");
                break;
            case 2:
                mAppBar.setVisibility(View.VISIBLE);
                mToolbarTitle.setText("我的");
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

//    @Override
//    public void onPageSelected(int position) {
//        if (position == 1) {
//            //如果是“通讯录”页被选中，则显示快速导航条
//            FragmentFactory.getInstance().getContactsFragment().showQuickIndexBar(true);
//        } else {
//            FragmentFactory.getInstance().getContactsFragment().showQuickIndexBar(false);
//        }
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//        if (state != ViewPager.SCROLL_STATE_IDLE) {
//            //滚动过程中隐藏快速导航条
//            FragmentFactory.getInstance().getContactsFragment().showQuickIndexBar(false);
//        } else {
//            FragmentFactory.getInstance().getContactsFragment().showQuickIndexBar(true);
//        }
//    }

//    private void registerBR() {
//        BroadcastManager.getInstance(this).register(AppConst.FETCH_COMPLETE, new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                hideWaitingDialog();
//            }
//        });
//    }
//
//    private void unRegisterBR() {
//        BroadcastManager.getInstance(this).unregister(AppConst.FETCH_COMPLETE);
//    }

    @Override
    public TextView getTvMessageCount() {
        return mTvMessageCount;
    }
}
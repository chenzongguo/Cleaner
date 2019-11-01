package cn.njthl.cleaner.ui.fragment;

import android.widget.ImageView;
import android.widget.ListView;

import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.ui.activity.MainActivity;
import cn.njthl.cleaner.ui.base.BaseFragment;
import cn.njthl.cleaner.ui.presenter.HomePageFgPresenter;
import cn.njthl.cleaner.ui.view.HomePageFgView;

import butterknife.BindView;
import cn.njthl.cleaner.widget.MyListView;

public class HomePageFragment extends BaseFragment<HomePageFgView, HomePageFgPresenter> implements HomePageFgView{

    @BindView(R2.id.lv_order_receive)
    MyListView lv_OrderReceive;


    @Override
    public void onStart() {
        super.onStart();
        mPresenter.getConversations();
    }


    //    @Override
//    public void onResume() {
//        super.onResume();
//        mPresenter.getConversations();
//    }

//    public void  viewUpdate(){
//        mPresenter.getConversations();
//    }
    @Override
    protected HomePageFgPresenter createPresenter() {
        return new HomePageFgPresenter((MainActivity) getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_home_page;
    }

    @Override
    public MyListView getLvOrderReceive() {
        return lv_OrderReceive;
    }

}

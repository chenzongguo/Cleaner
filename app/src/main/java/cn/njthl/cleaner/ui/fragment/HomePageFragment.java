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

public class HomePageFragment extends BaseFragment<HomePageFgView, HomePageFgPresenter> implements HomePageFgView{

    @BindView(R2.id.lv_order_receive)
    ListView lv_OrderReceive;

    @BindView(R2.id.img_NoOrder)
    ImageView img_NoOrder;

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
    public ListView getLvOrderReceive() {
        return lv_OrderReceive;
    }

    @Override
    public ImageView getImaNoOrder() {
        return img_NoOrder;
    }
}

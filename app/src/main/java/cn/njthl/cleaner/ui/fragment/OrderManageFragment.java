package cn.njthl.cleaner.ui.fragment;

import android.widget.LinearLayout;

import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.ui.activity.MainActivity;
import cn.njthl.cleaner.ui.base.BaseFragment;
import cn.njthl.cleaner.ui.presenter.OrderManageFgPresenter;
import cn.njthl.cleaner.ui.view.OrderManageFgView;

import butterknife.BindView;

public class OrderManageFragment extends BaseFragment<OrderManageFgView, OrderManageFgPresenter> implements OrderManageFgView {

    @BindView(R2.id.llyOrderNoConfirm)
    LinearLayout llyOrderNoConfirm;

    @BindView(R2.id.llyOrderNoConfirm3)
    LinearLayout llyOrderNoConfirm3;

    @BindView(R2.id.llyOrderNoConfirm4)
    LinearLayout llyOrderNoConfirm4;

    @BindView(R2.id.llyOrderNoConfirm5)
    LinearLayout llyOrderNoConfirm5;

//    @BindView(R2.id.llyOrderNoConfirm)
//    LinearLayout llyOrderNoConfirm;
//
//    @BindView(R2.id.llyOrderNoConfirm)
//    LinearLayout llyOrderNoConfirm;

    @BindView(R2.id.llyComplete)
    LinearLayout llyComplete;
    @Override
    protected OrderManageFgPresenter createPresenter() {
        return new OrderManageFgPresenter((MainActivity) getActivity());
    }

//    @Override
//    public void init() {
//        super.init();
//        mPresenter.getConversations();
//    }
    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_order_manage;
    }


    @Override
    public LinearLayout getLlyOrderNoConfirm() {
        return llyOrderNoConfirm;
    }

    @Override
    public void initListener() {

        llyOrderNoConfirm.setOnClickListener(v -> mPresenter.toActivity("2"));
        llyOrderNoConfirm3.setOnClickListener(v -> mPresenter.toActivity("3"));
        llyOrderNoConfirm4.setOnClickListener(v -> mPresenter.toActivity("4"));
        llyOrderNoConfirm5.setOnClickListener(v -> mPresenter.toActivity("5"));
        llyComplete.setOnClickListener(v -> mPresenter.toActivity("7"));
    }
}
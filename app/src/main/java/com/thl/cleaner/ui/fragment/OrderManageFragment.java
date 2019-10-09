package com.thl.cleaner.ui.fragment;

import android.widget.LinearLayout;

import com.thl.cleaner.R;
import com.thl.cleaner.R2;
import com.thl.cleaner.ui.activity.MainActivity;
import com.thl.cleaner.ui.base.BaseFragment;
import com.thl.cleaner.ui.presenter.OrderManageFgPresenter;
import com.thl.cleaner.ui.view.OrderManageFgView;

import butterknife.BindView;

public class OrderManageFragment extends BaseFragment<OrderManageFgView, OrderManageFgPresenter> implements OrderManageFgView {

    @BindView(R2.id.llyOrderNoConfirm)
    LinearLayout llyOrderNoConfirm;
    @Override
    protected OrderManageFgPresenter createPresenter() {
        return new OrderManageFgPresenter((MainActivity) getActivity());
    }

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

        llyOrderNoConfirm.setOnClickListener(v -> mPresenter.toActivity());
    }
}
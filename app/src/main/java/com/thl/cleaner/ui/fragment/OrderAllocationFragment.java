package com.thl.cleaner.ui.fragment;

import android.widget.ImageView;
import android.widget.ListView;

import com.thl.cleaner.R;
import com.thl.cleaner.R2;
import com.thl.cleaner.ui.activity.MainActivity;
import com.thl.cleaner.ui.base.BaseFragment;
import com.thl.cleaner.ui.presenter.OrderAllocationFgPresenter;
import com.thl.cleaner.ui.view.OrderAllocationFgView;

import butterknife.BindView;

public class OrderAllocationFragment extends BaseFragment<OrderAllocationFgView, OrderAllocationFgPresenter> implements OrderAllocationFgView{

    @BindView(R2.id.lv_order_allocation)
    ListView lv_OrderAllocation;

    @BindView(R2.id.img_NoOrder)
    ImageView img_NoOrder;

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.getConversations();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getConversations();
    }

    @Override
    protected OrderAllocationFgPresenter createPresenter() {
        return new OrderAllocationFgPresenter((MainActivity) getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_order_allocation;
    }

    @Override
    public ListView getLvOrderAllocation() {
        return lv_OrderAllocation;
    }

    @Override
    public ImageView getImaNoOrder() {
        return img_NoOrder;
    }
}

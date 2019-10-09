package com.thl.cleaner.ui.presenter;

import com.thl.cleaner.ui.activity.OrderNoConfirmActivity;
import com.thl.cleaner.ui.base.BaseActivity;
import com.thl.cleaner.ui.base.BasePresenter;
import com.thl.cleaner.ui.view.OrderManageFgView;

public class OrderManageFgPresenter extends BasePresenter<OrderManageFgView> {
    public OrderManageFgPresenter(BaseActivity context) {
        super(context);
    }

    public void toActivity(){
        mContext.jumpToActivityAndClearTop(OrderNoConfirmActivity.class);
    }


}
package cn.njthl.cleaner.ui.presenter;

import android.content.Intent;

import cn.njthl.cleaner.ui.activity.OrderNoConfirmActivity;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.OrderManageFgView;

public class OrderManageFgPresenter extends BasePresenter<OrderManageFgView> {
    public OrderManageFgPresenter(BaseActivity context) {
        super(context);
    }

    public void toActivity(String Order_room_state){
        Intent intent = new Intent(mContext, OrderNoConfirmActivity.class);
        intent.putExtra("order_room_state",Order_room_state);
//                intent.putExtra("order_state",cleanerOrderBeanList.get(position).getOrder_room_state());
        mContext.jumpToActivity(intent);
//        mContext.jumpToActivityAndClearTop(OrderNoConfirmActivity.class);
    }


}
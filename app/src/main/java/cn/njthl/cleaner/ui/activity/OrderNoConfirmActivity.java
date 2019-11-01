package cn.njthl.cleaner.ui.activity;

import android.widget.ImageView;
import android.widget.ListView;


import com.jaeger.library.StatusBarUtil;

import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.presenter.OrderNoConfirmAtPresenter;
import cn.njthl.cleaner.ui.view.IOrderNoConfirmAtView;

import butterknife.BindView;
import cn.njthl.cleaner.util.UIUtils;

public class OrderNoConfirmActivity extends BaseActivity<IOrderNoConfirmAtView, OrderNoConfirmAtPresenter> implements IOrderNoConfirmAtView {

    @BindView(R2.id.lv_order_no_confirm)
    ListView lv_order_no_confirm;

    @BindView(R2.id.img_NoOrder)
    ImageView img_NoOrder;

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getConversations();
    }

    @Override
    public void initView() {
        super.initView();
        StatusBarUtil.setColor(this, UIUtils.getColor(R.color.assist_green1), 10);
        mToolbarTitle.setText("订单列表");
    }

    @Override
    public void requestPermissionResult(boolean allowPermission) {

    }

    @Override
    protected OrderNoConfirmAtPresenter createPresenter() {
        return new OrderNoConfirmAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.at_order_no_confirm;
    }

    @Override
    public ListView getLvOrderNoConfirm() {
        return lv_order_no_confirm;
    }

    @Override
    public ImageView getImaNoOrder() {
        return img_NoOrder;
    }
}

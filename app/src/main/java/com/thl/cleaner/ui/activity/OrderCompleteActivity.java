package com.thl.cleaner.ui.activity;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.thl.cleaner.R;
import com.thl.cleaner.R2;
import com.thl.cleaner.ui.base.BaseActivity;
import com.thl.cleaner.ui.presenter.OrderCompleteAtPresenter;
import com.thl.cleaner.ui.view.IOrderCompleteAtView;

import butterknife.BindView;

public class OrderCompleteActivity extends BaseActivity<IOrderCompleteAtView, OrderCompleteAtPresenter> implements IOrderCompleteAtView {
    @BindView(R2.id.tvCorpName)
    TextView tvCorpName;

    @BindView(R2.id.img_photo1)
    ImageView img_photo1;
    @BindView(R2.id.img_photo2)
    ImageView img_photo2;
    @BindView(R2.id.img_photo3)
    ImageView img_photo3;
    @BindView(R2.id.btnComplete)
    Button btnComplete;


    @Override
    public void initListener() {
        super.initListener();
        btnComplete.setOnClickListener(v -> mPresenter.complete());
    }

    @Override
    public void requestPermissionResult(boolean allowPermission) {

    }

    @Override
    protected OrderCompleteAtPresenter createPresenter() {
        return new OrderCompleteAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.at_order_complete;
    }

    @Override
    public TextView getTvRoomName() {
        return null;
    }

    @Override
    public ImageView getImgPhoto1() {
        return img_photo1;
    }

    @Override
    public ImageView getImgPhoto2() {
        return img_photo2;
    }

    @Override
    public ImageView getImgPhoto3() {
        return img_photo3;
    }

    @Override
    public Button getBtnComplete() {
        return btnComplete;
    }
}

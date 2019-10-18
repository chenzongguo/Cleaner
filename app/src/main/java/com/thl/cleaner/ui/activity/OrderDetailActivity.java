package com.thl.cleaner.ui.activity;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.thl.cleaner.R;
import com.thl.cleaner.R2;
import com.thl.cleaner.ui.base.BaseActivity;
import com.thl.cleaner.ui.presenter.OederDetailAtPresenter;
import com.thl.cleaner.ui.view.IOrderDetailAtView;

import butterknife.BindView;

public class OrderDetailActivity extends BaseActivity<IOrderDetailAtView, OederDetailAtPresenter> implements IOrderDetailAtView {
    @BindView(R2.id.tvCorpName)
    TextView tvCorpName;

    @BindView(R2.id.tvAddress)
    TextView tvAddress;

    @BindView(R2.id.tv_room_name)
    TextView tvRoomName;

    @BindView(R2.id.tvRoomType)
    TextView tvRoomType;

//    @BindView(R2.id.tvBedNum)
//    TextView tvBedNum;

    @BindView(R2.id.tvOrderId)
    TextView tvOrderId;

//    @BindView(R2.id.tvRemark)
//    TextView tvRemark;
//
    @BindView(R2.id.btnParnterReceipt)
    Button btnParnterReceipt;
//
//    @BindView(R2.id.etVerifyCode)
//    EditText mEtVerifyCode;
//
//    @BindView(R2.id.btnCheckCaptcha)
//    Button mBtnCheckCaptcha;
//
//    @BindView(R2.id.etPwd)
//    EditText mEtPwd;
//
//    @BindView(R2.id.etPwd2)
//    EditText mEtPwd2;
//
//    @BindView(R2.id.btnUserRegister)
//    Button mBtnUserRegister;

//    @BindView(R2.id.lvOrderRoom)
//    ListView lvOrderRoom;


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getConversations();
    }

    @Override
    public void initListener() {
        btnParnterReceipt.setOnClickListener(v -> mPresenter.ParnterReceipt());
//        mBtnCheckCaptcha.setOnClickListener(v -> mPresenter.GetVerifyCode());
//        mBtnUserRegister.setOnClickListener(v -> mPresenter.register());
    }


    @Override
    public void requestPermissionResult(boolean allowPermission) {

    }

    @Override
    protected OederDetailAtPresenter createPresenter() {
        return new OederDetailAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.at_order_detail;
    }


//    @Override
//    public ListView getLvRoomInfo() {
//        return lvOrderRoom;
//    }

    @Override
    public TextView getTvAddress() {
        return tvAddress;
    }

    @Override
    public TextView getTvCorpName() {
        return tvCorpName;
    }

    @Override
    public TextView getTvRoomName() {
        return tvRoomName;
    }

    @Override
    public TextView getTvRoomType() {
        return tvRoomType;
    }

    @Override
    public TextView getTvBedNum() {
        return null;
    }

    @Override
    public TextView getTvOrderId() {
        return tvOrderId;
    }

    @Override
    public TextView getTvRemark() {
        return null;
    }

    @Override
    public Button getBtnParnterReceipt() {
        return btnParnterReceipt;
    }
}
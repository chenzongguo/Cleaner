package cn.njthl.cleaner.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.presenter.OederDetailAtPresenter;
import cn.njthl.cleaner.ui.view.IOrderDetailAtView;
import cn.njthl.cleaner.util.UIUtils;

import androidx.annotation.Nullable;
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

    @BindView(R2.id.tvRoomState)
    TextView tvRoomState;

//    @BindView(R2.id.tvBedNum)
//    TextView tvBedNum;

    @BindView(R2.id.tvOrderId)
    TextView tvOrderId;

//    @BindView(R2.id.tvRemark)
//    TextView tvRemark;

    @BindView(R2.id.tvCreateTime)
    TextView tvCreateTime;

    @BindView(R2.id.tvTime)
    TextView tvTime;

    @BindView(R2.id.tvContacts)
    TextView tvContacts;

    @BindView(R2.id.tvContactPhone)
    TextView tvContactPhone;
//
    @BindView(R2.id.btnParnterReceipt)
    Button btnParnterReceipt;

    @BindView(R2.id.btnCompelte)
    Button btnCompelte;

    @BindView(R2.id.btnEvaluation)
    Button btnEvaluation;

    @BindView(R2.id.rlyNoCompelte)
    RelativeLayout rlyNoCompelte;

    @BindView(R2.id.rlyCompelte)
    RelativeLayout rlyCompelte;
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(this, UIUtils.getColor(R.color.assist_green1), 10);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getConversations();
    }

    @Override
    public void initView() {
        super.initView();
        mToolbarTitle.setText("订单详情");
    }

    @Override
    public void initListener() {
        btnParnterReceipt.setOnClickListener(v -> mPresenter.ParnterReceipt());
        btnCompelte.setOnClickListener(v -> mPresenter.compelte());
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
    public TextView getTvRoomState() {
        return tvRoomState;
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
    public TextView getTvCreateTime() {
        return tvCreateTime;
    }

    @Override
    public TextView getTvTime() {
        return tvTime;
    }

    @Override
    public TextView getTvContacts() {
        return tvContacts;
    }

    @Override
    public TextView getTvContactPhone() {
        return tvContactPhone;
    }

    @Override
    public Button getBtnParnterReceipt() {
        return btnParnterReceipt;
    }

    @Override
    public Button getBtnEvaluation() {
        return btnEvaluation;
    }

    @Override
    public RelativeLayout getRlyNoCompelte() {
        return rlyNoCompelte;
    }

    @Override
    public RelativeLayout getRlyCompelte() {
        return rlyCompelte;
    }
}
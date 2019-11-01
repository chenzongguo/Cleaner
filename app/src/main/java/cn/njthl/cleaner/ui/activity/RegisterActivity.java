package cn.njthl.cleaner.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

import androidx.annotation.Nullable;
import butterknife.BindView;
import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.presenter.RegisterAtPresenter;
import cn.njthl.cleaner.ui.view.IRegisterAtView;
import cn.njthl.cleaner.util.UIUtils;

public class RegisterActivity extends BaseActivity<IRegisterAtView, RegisterAtPresenter> implements IRegisterAtView {
    @BindView(R2.id.etPhone)
    EditText mEtPhone;

    @BindView(R2.id.btnGetVerifyCode)
    Button mBtnGetVerifyCode;

    @BindView(R2.id.etVerifyCode)
    EditText mEtVerifyCode;

    @BindView(R2.id.btnCheckCaptcha)
    Button mBtnCheckCaptcha;

    @BindView(R2.id.etPwd)
    EditText mEtPwd;

    @BindView(R2.id.etPwd2)
    EditText mEtPwd2;

    @BindView(R2.id.btnUserRegister)
    Button mBtnUserRegister;

    @BindView(R2.id.llyPhone)
    LinearLayout llyPhone;

    @BindView(R2.id.llyVerifyCode)
    LinearLayout llyVerifyCode;

    @BindView(R2.id.llypwd)
    LinearLayout llypwd;

    @BindView(R2.id.tv_phone)
    TextView tv_phone;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(this, UIUtils.getColor(R.color.assist_green1), 10);
    }

    @Override
    public void initView() {
        super.initView();
        setToolbarTitle("注册账户");
    }

    @Override
    public void initListener() {
        mBtnGetVerifyCode.setOnClickListener(v -> mPresenter.GetVerifyCode());
        mBtnCheckCaptcha.setOnClickListener(v -> mPresenter.checkCaptcha());
        mBtnUserRegister.setOnClickListener(v -> mPresenter.register());
    }


    @Override
    public void requestPermissionResult(boolean allowPermission) {

    }

    @Override
    protected RegisterAtPresenter createPresenter() {
        return new RegisterAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    public EditText getEtPhone() {
        return mEtPhone;
    }

    @Override
    public EditText getEtVerifyCode() {
        return mEtVerifyCode;
    }

    @Override
    public EditText getEtPwd() {
        return mEtPwd;
    }

    @Override
    public EditText getEtPwd2() {
        return mEtPwd2;
    }

    @Override
    public LinearLayout getLlyPhone() {
        return llyPhone;
    }

    @Override
    public LinearLayout getLlyVerifyCode() {
        return llyVerifyCode;
    }

    @Override
    public LinearLayout getLlypwd() {
        return llypwd;
    }

    @Override
    public TextView getTvPhone() {
        return tv_phone;
    }
}

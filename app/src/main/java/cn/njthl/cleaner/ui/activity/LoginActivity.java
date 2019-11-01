package cn.njthl.cleaner.ui.activity;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

import androidx.annotation.Nullable;
import butterknife.BindView;
import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.presenter.LoginAtPresenter;
import cn.njthl.cleaner.ui.view.ILoginAtView;
import cn.njthl.cleaner.util.UIUtils;

/**
 * @创建者
 * @描述 登录界面
 */
public class LoginActivity extends BaseActivity<ILoginAtView, LoginAtPresenter> implements ILoginAtView {

    @BindView(R2.id.ibAddMenu)
    ImageButton mIbAddMenu;

    @BindView(R2.id.etPhone)
    EditText mEtPhone;
    @BindView(R2.id.vLinePhone)
    View mVLinePhone;

    @BindView(R2.id.etPwd)
    EditText mEtPwd;
    @BindView(R2.id.vLinePwd)
    View mVLinePwd;

    @BindView(R2.id.tvProblems)
    TextView mTvProblems;
    @BindView(R2.id.btnLogin)
    Button mBtnLogin;
    @BindView(R2.id.tv_register)
    TextView mTvRegister;
    @BindView(R2.id.tvOtherLogin)
    TextView mTvOtherLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(this, UIUtils.getColor(R.color.assist_green1), 10);
    }

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mBtnLogin.setEnabled(canLogin());
            if(!canLogin()){
                mBtnLogin.setBackgroundColor(UIUtils.getColor(R.color.line));
            }else{
                mBtnLogin.setBackgroundColor(UIUtils.getColor(R.color.assist_green1));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Override
    public void requestPermissionResult(boolean allowPermission) {

    }

    @Override
    public void initView() {
        mIbAddMenu.setVisibility(View.GONE);
    }


    @Override
    protected boolean isToolbarCanBack() {
        return false;
    }
    @Override
    public void initListener() {
        mEtPwd.addTextChangedListener(watcher);
        mEtPhone.addTextChangedListener(watcher);
        mEtPwd.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                mVLinePwd.setBackgroundColor(UIUtils.getColor(R.color.green0));
            } else {
                mVLinePwd.setBackgroundColor(UIUtils.getColor(R.color.line));
            }
        });
        mEtPhone.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                mVLinePhone.setBackgroundColor(UIUtils.getColor(R.color.green0));
            } else {
                mVLinePhone.setBackgroundColor(UIUtils.getColor(R.color.line));
            }
        });

        mBtnLogin.setOnClickListener(v -> mPresenter.login());
        mTvRegister.setOnClickListener(v -> mPresenter.register());
    }

    private boolean canLogin() {
        int pwdLength = mEtPwd.getText().toString().trim().length();
        int phoneLength = mEtPhone.getText().toString().trim().length();
        if (pwdLength > 0 && phoneLength > 0) {
            return true;
        }
        return false;
    }


    @Override
    protected LoginAtPresenter createPresenter() {
        return new LoginAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public EditText getEtPhone() {
        return mEtPhone;
    }

    @Override
    public EditText getEtPwd() {
        return mEtPwd;
    }
}
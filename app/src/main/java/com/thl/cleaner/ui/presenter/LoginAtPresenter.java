package com.thl.cleaner.ui.presenter;

import android.text.TextUtils;
import android.widget.Toast;


import com.thl.cleaner.R;
import com.thl.cleaner.api.ApiRetrofit;
import com.thl.cleaner.app.AppConst;
import com.thl.cleaner.model.request.UserLoginRequest;
import com.thl.cleaner.ui.activity.MainActivity;
import com.thl.cleaner.ui.activity.RegisterActivity;
import com.thl.cleaner.ui.base.BaseActivity;
import com.thl.cleaner.ui.base.BasePresenter;
import com.thl.cleaner.ui.view.ILoginAtView;
import com.thl.cleaner.util.LogUtils;
import com.thl.cleaner.util.UIUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class LoginAtPresenter extends BasePresenter<ILoginAtView> {

    public LoginAtPresenter(BaseActivity context) {
        super(context);
    }

    public void login() {
        String phone = getView().getEtPhone().getText().toString().trim();
        String pwd = getView().getEtPwd().getText().toString().trim();

        if (TextUtils.isEmpty(phone)) {
            UIUtils.showToast(UIUtils.getString(R.string.IDcard_not_empty));
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            UIUtils.showToast(UIUtils.getString(R.string.password_not_empty));
            return;
        }

        UserLoginRequest userLoginRequest= new UserLoginRequest();
        userLoginRequest.setType("1");
        userLoginRequest.setUser_phone(phone);
        userLoginRequest.setUser_pwd(pwd);
        ApiRetrofit.getInstance().userLogin(userLoginRequest)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(userLoginResponse -> {
            String code = userLoginResponse.getCode();
            if("000".equals(code)){
                AppConst.USER_TOKEN = userLoginResponse.getData().getUser_token();
                AppConst.USER_ID = userLoginResponse.getData().getUser_id();
                AppConst.ROLE_ID = userLoginResponse.getData().getRole_id();
                mContext.jumpToActivityAndClearTask(MainActivity.class);
//                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
//                        registerReceiver();
            }else{
                        Toast.makeText(mContext, userLoginResponse.getErrMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void register(){
        mContext.jumpToActivityAndClearTop(RegisterActivity.class);
//        mContext.finish();
    }

    private void loginError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
        mContext.hideWaitingDialog();
    }
}

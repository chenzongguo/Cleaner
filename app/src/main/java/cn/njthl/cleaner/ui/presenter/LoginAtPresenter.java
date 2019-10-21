package cn.njthl.cleaner.ui.presenter;

import android.text.TextUtils;
import android.widget.Toast;


import cn.njthl.cleaner.R;
import cn.njthl.cleaner.api.ApiRetrofit;
import cn.njthl.cleaner.app.AppConst;
import cn.njthl.cleaner.model.request.UserLoginRequest;
import cn.njthl.cleaner.ui.activity.MainActivity;
import cn.njthl.cleaner.ui.activity.RegisterActivity;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.ILoginAtView;
import cn.njthl.cleaner.util.LogUtils;
import cn.njthl.cleaner.util.UIUtils;

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

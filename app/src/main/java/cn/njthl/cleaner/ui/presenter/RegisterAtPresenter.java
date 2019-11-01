package cn.njthl.cleaner.ui.presenter;

import android.text.TextUtils;
import android.view.View;

import cn.njthl.cleaner.R;
import cn.njthl.cleaner.api.ApiRetrofit;
import cn.njthl.cleaner.ui.activity.LoginActivity;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.IRegisterAtView;
import cn.njthl.cleaner.util.ButtonUtils;
import cn.njthl.cleaner.util.LogUtils;
import cn.njthl.cleaner.util.NetUtils;
import cn.njthl.cleaner.util.UIUtils;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RegisterAtPresenter extends BasePresenter<IRegisterAtView> {

    public RegisterAtPresenter(BaseActivity context) {
        super(context);
    }

    public void login() {
        String phone = getView().getEtPhone().getText().toString().trim();
        String pwd = getView().getEtPwd().getText().toString().trim();


    }

    public void GetVerifyCode(){
        if (!ButtonUtils.isFastDoubleClick()) {
            String phone = getView().getEtPhone().getText().toString().trim();
            if (TextUtils.isEmpty(phone)) {
                UIUtils.showToast(UIUtils.getString(R.string.IDcard_not_empty));
                return;
            }

            if (phone.length() < 11) {
                UIUtils.showToast("手机号长度不正确");
                return ;
            }
            if(!NetUtils.isConnectedAndToast(mContext))
                return;
            mContext.showWaitingDialog("正在获取验证码");

            ApiRetrofit.getInstance().checkUserPhone(phone)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(baseResponse -> {
                        String code = baseResponse.getCode();
                        if("000".equals(code)){
                            mContext.hideWaitingDialog();
                            UIUtils.showToast(" 手机号已注册");
//                        getView().getLlyPhone().setVisibility(View.GONE);
//                        getView().getLlyVerifyCode().setVisibility(View.VISIBLE);
//                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
//                        registerReceiver();
                        }else{
                            ApiRetrofit.getInstance().sendCaptcha(phone)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(userLoginResponse -> {
                                        String code1 = userLoginResponse.getCode();
                                        if("000".equals(code1)){
//                        UIUtils.showToast(UIUtils.getString(R.string.vertify_code_get_success));
                                            mContext.hideWaitingDialog();
                                            getView().getLlyPhone().setVisibility(View.GONE);
                                            getView().getLlyVerifyCode().setVisibility(View.VISIBLE);
                                            getView().getTvPhone().setText(phone);
//                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
//                        registerReceiver();
                                        }else{
                                            mContext.hideWaitingDialog();
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    },this::loginError);
        }

    }

    public void checkCaptcha(){
        if (!ButtonUtils.isFastDoubleClick()) {
            String phone = getView().getEtPhone().getText().toString().trim();
            String VerifyCode = getView().getEtVerifyCode().getText().toString();
            if (TextUtils.isEmpty(VerifyCode)) {
                UIUtils.showToast(UIUtils.getString(R.string.vertify_code_not_empty));
                return;
            }
            if (VerifyCode.length() < 6) {
                UIUtils.showToast("验证码长度不正确");
                return ;
            }
            ApiRetrofit.getInstance().checkCaptcha(phone,VerifyCode)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(userLoginResponse -> {
                        String code = userLoginResponse.getCode();
                        if("000".equals(code)){
                            getView().getLlyVerifyCode().setVisibility(View.GONE);
                            getView().getLlypwd().setVisibility(View.VISIBLE);
                            UIUtils.showToast(UIUtils.getString(R.string.vertify_code_get_success));
//                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
//                        registerReceiver();
                        }else{
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                        }
                    },this::loginError);
        }
    }

    public void register(){
        if (!ButtonUtils.isFastDoubleClick()) {
            String phone = getView().getEtPhone().getText().toString().trim();
            String pwd = getView().getEtPwd().getText().toString().trim();
            String pwd2 = getView().getEtPwd2().getText().toString().trim();

            if (!pwd.equals(pwd2)){
                UIUtils.showToast("密码输入不一致");
                return;
            }
            ApiRetrofit.getInstance().userRegister(phone,pwd)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(userLoginResponse -> {
                        String code = userLoginResponse.getCode();
                        if("000".equals(code)){
                            UIUtils.showToast("注册成功");
                            mContext.jumpToActivityAndClearTask(LoginActivity.class);
//                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
//                        registerReceiver();
                        }else{
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                        }
                    },this::loginError);
        }

    }
    private void loginError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
    }

}
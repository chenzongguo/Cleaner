package cn.njthl.cleaner.ui.presenter;

import android.text.TextUtils;

import cn.njthl.cleaner.R;
import cn.njthl.cleaner.api.ApiRetrofit;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.IRegisterAtView;
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
        String phone = getView().getEtPhone().getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            UIUtils.showToast(UIUtils.getString(R.string.IDcard_not_empty));
            return;
        }
        ApiRetrofit.getInstance().sendCaptcha(phone)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userLoginResponse -> {
                    String code = userLoginResponse.getCode();
                    if("000".equals(code)){
                        UIUtils.showToast(UIUtils.getString(R.string.vertify_code_get_success));
//                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
//                        registerReceiver();
                    }else{
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void checkCaptcha(){
        String phone = getView().getEtPhone().getText().toString().trim();
        String VerifyCode = getView().getEtVerifyCode().getText().toString();
        if (TextUtils.isEmpty(phone)) {
            UIUtils.showToast(UIUtils.getString(R.string.IDcard_not_empty));
            return;
        }
        ApiRetrofit.getInstance().checkCaptcha(phone,VerifyCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userLoginResponse -> {
                    String code = userLoginResponse.getCode();
                    if("000".equals(code)){
                        UIUtils.showToast(UIUtils.getString(R.string.vertify_code_get_success));
//                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
//                        registerReceiver();
                    }else{
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void register(){
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
//                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
//                        registerReceiver();
                    }else{
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
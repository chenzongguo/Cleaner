package cn.njthl.cleaner.ui.activity;

import android.widget.Button;

import butterknife.BindView;
import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.app.AppConst;
import cn.njthl.cleaner.app.MyApp;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.util.ActivityCollectorUtils;
import cn.njthl.cleaner.util.SPUtils;

public class SettingActivity extends BaseActivity {

    @BindView(R2.id.btnLogout)
    Button mBtnLogout;

    @Override
    public void initListener() {
        super.initListener();
        mBtnLogout.setOnClickListener(v -> logout());
    }

    private void logout(){
        SPUtils.getInstance(MyApp.getContext()).putString("USER_TOKEN","");
        ActivityCollectorUtils.finishAllActivity();
        jumpToActivityAndClearTop(LoginActivity.class);
    }
    @Override
    public void requestPermissionResult(boolean allowPermission) {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.at_setting;
    }

}

package cn.njthl.cleaner.ui.presenter;

import android.content.Intent;

import cn.njthl.cleaner.ui.activity.SettingActivity;
import cn.njthl.cleaner.ui.activity.UserInfoActivity;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.MeFgView;

public class MeFgPresenter extends BasePresenter<MeFgView> {
    public void toUserManageActivity(){
        Intent intent = new Intent(mContext, UserInfoActivity.class);
        mContext.jumpToActivity(intent);
    }


    public void toSettingActivity(){
        Intent intent = new Intent(mContext, SettingActivity.class);
        mContext.jumpToActivity(intent);
    }
    public MeFgPresenter(BaseActivity context) {
        super(context);
    }
}

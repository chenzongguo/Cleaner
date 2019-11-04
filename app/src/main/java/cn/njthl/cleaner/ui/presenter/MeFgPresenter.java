package cn.njthl.cleaner.ui.presenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import cn.njthl.cleaner.app.MyApp;
import cn.njthl.cleaner.ui.activity.LoginActivity;
import cn.njthl.cleaner.ui.activity.SettingActivity;
import cn.njthl.cleaner.ui.activity.UserInfoActivity;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.MeFgView;
import cn.njthl.cleaner.util.ActivityCollectorUtils;
import cn.njthl.cleaner.util.ButtonUtils;
import cn.njthl.cleaner.util.SPUtils;

public class MeFgPresenter extends BasePresenter<MeFgView> {
    public void toUserManageActivity(){
        if (!ButtonUtils.isFastDoubleClick()) {
            Intent intent = new Intent(mContext, UserInfoActivity.class);
            mContext.jumpToActivity(intent);
        }
    }


    public void toSettingActivity(){
        if (!ButtonUtils.isFastDoubleClick()) {
            Intent intent = new Intent(mContext, SettingActivity.class);
            mContext.jumpToActivity(intent);
        }

    }

    public void logout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("确认退出应用吗");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SPUtils.getInstance(MyApp.getContext()).putString("USER_TOKEN","");
                ActivityCollectorUtils.finishAllActivity();
                mContext.jumpToActivityAndClearTop(LoginActivity.class);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create().show();
    }
    public MeFgPresenter(BaseActivity context) {
        super(context);
    }
}

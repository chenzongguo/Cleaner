package cn.njthl.cleaner.ui.fragment;

import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.ui.activity.MainActivity;
import cn.njthl.cleaner.ui.base.BaseFragment;
import cn.njthl.cleaner.ui.presenter.MeFgPresenter;
import cn.njthl.cleaner.ui.view.MeFgView;

public class MeFragment extends BaseFragment<MeFgView, MeFgPresenter> implements MeFgView {

    @BindView(R2.id.tvUserInfo)
    TextView tvUserInfo;

//    @BindView(R2.id.tvUserInvitation)
//    TextView tvUserInvitation;

//    @BindView(R2.id.tv_setting)
//    TextView tv_setting;

    @BindView(R2.id.btnLogout)
    Button mBtnLogout;

    @Override
    public void initListener() {
        super.initListener();
        tvUserInfo.setOnClickListener(v -> mPresenter.toUserManageActivity());
//        tv_setting.setOnClickListener(v -> mPresenter.toSettingActivity());
        mBtnLogout.setOnClickListener(v -> mPresenter.logout());
    }

    @Override
    protected MeFgPresenter createPresenter() {
        return new MeFgPresenter((MainActivity) getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_me;
    }


}
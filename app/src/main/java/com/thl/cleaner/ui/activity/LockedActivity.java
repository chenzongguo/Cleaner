package com.thl.cleaner.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.thl.cleaner.R;
import com.thl.cleaner.R2;
import com.thl.cleaner.ui.base.BaseActivity;
import com.thl.cleaner.ui.presenter.LockedAtPresenter;
import com.thl.cleaner.ui.view.ILockedAtView;

import java.util.List;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.BindViews;

public class LockedActivity extends BaseActivity<ILockedAtView, LockedAtPresenter> implements ILockedAtView {

    @BindViews({ R2.id.name, R2.id.sex,  R2.id.nation,R2.id.address,R2.id.cardnum,R2.id.phonenum,R2.id.detailed_addr})
    List<EditText> editTexts;

    @BindViews({R2.id.area,R2.id.lockedReson,R2.id.sourceOfBus,R2.id.lockType,R2.id.ReadStatus})
    List<TextView> textViews;
    @BindView(R2.id.sumbit)
    Button btn_sumbit;
    @BindViews({R2.id.idcardphoto,R2.id.lockphoto})
    List<ImageView> imageViews;

    @Override
    public void initView() {
        super.initView();
        StatusBarUtil.setTranslucent(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.ReadCardinit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.stopReadCard();
    }

    @Override
    public void initListener() {
        btn_sumbit.setOnClickListener(v -> mPresenter.save());
        textViews.get(0).setOnClickListener(v -> mPresenter.areaOnclick());
        textViews.get(1).setOnClickListener(v -> mPresenter.lockedResonOnclick());
        textViews.get(2).setOnClickListener(v -> mPresenter.sourceOfBusOnclick());
        textViews.get(3).setOnClickListener(v -> mPresenter.lockTypeOnclick());
    }
    @Override
    public void requestPermissionResult(boolean allowPermission) {

    }

    @Override
    protected LockedAtPresenter createPresenter() {
        return new LockedAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_locked;
    }

    @Override
    public List<EditText> GetEtList() {
        return editTexts;
    }

    @Override
    public List<TextView> GetTvList() {
        return textViews;
    }

    @Override
    public List<ImageView> GetImgList() {
        return imageViews;
    }
}

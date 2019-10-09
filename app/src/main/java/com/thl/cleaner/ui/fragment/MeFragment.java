package com.thl.cleaner.ui.fragment;

import com.thl.cleaner.R;
import com.thl.cleaner.ui.base.BaseFragment;
import com.thl.cleaner.ui.presenter.MeFgPresenter;
import com.thl.cleaner.ui.view.MeFgView;

public class MeFragment extends BaseFragment<MeFgView, MeFgPresenter> implements MeFgView {

    @Override
    protected MeFgPresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_me;
    }


}
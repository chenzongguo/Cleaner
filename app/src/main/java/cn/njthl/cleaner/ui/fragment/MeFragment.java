package cn.njthl.cleaner.ui.fragment;

import cn.njthl.cleaner.R;
import cn.njthl.cleaner.ui.base.BaseFragment;
import cn.njthl.cleaner.ui.presenter.MeFgPresenter;
import cn.njthl.cleaner.ui.view.MeFgView;

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
package cn.njthl.cleaner.ui.fragment;

import android.widget.TextView;

import butterknife.BindView;
import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.ui.activity.MainActivity;
import cn.njthl.cleaner.ui.base.BaseFragment;
import cn.njthl.cleaner.ui.presenter.NewOrderManageFgPresenter;
import cn.njthl.cleaner.ui.view.NewOrderManageFgView;
import cn.njthl.cleaner.widget.MyListView;

public class NewOrderManageFragment extends BaseFragment<NewOrderManageFgView, NewOrderManageFgPresenter> implements NewOrderManageFgView {

    @BindView(R2.id.lv_Order)
    MyListView lv_Order;

//    @BindView(R2.id.img_NoOrder)
//    ImageView img_NoOrder;
    @BindView(R2.id.tv_NoArriveCorp)
    TextView tv_NoArriveCorp;

    @BindView(R2.id.tv_ArriveCrop)
    TextView tv_ArriveCrop;

    @BindView(R2.id.tv_CleanComplete)
    TextView tv_CleanComplete;

    @BindView(R2.id.tv_OrderComplete)
    TextView tv_OrderComplete;

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.getConversations();
    }

    @Override
    public void initListener() {
        super.initListener();
        tv_NoArriveCorp.setOnClickListener(v -> mPresenter.tableClick("3"));
        tv_ArriveCrop.setOnClickListener(v -> mPresenter.tableClick("4"));
        tv_CleanComplete.setOnClickListener(v -> mPresenter.tableClick("5"));
        tv_OrderComplete.setOnClickListener(v -> mPresenter.tableClick("7"));
    }

    @Override
    protected NewOrderManageFgPresenter createPresenter() {
        return new NewOrderManageFgPresenter((MainActivity) getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fg_order_manage;
    }


    @Override
    public MyListView getLvOrder() {
        return lv_Order;
    }

    @Override
    public TextView getTvNoArriveCorp() {
        return tv_NoArriveCorp;
    }

    @Override
    public TextView getTvArriveCorp() {
        return tv_ArriveCrop;
    }

    @Override
    public TextView getTvCleanComplete() {
        return tv_CleanComplete;
    }

    @Override
    public TextView getTvOrderComplete() {
        return tv_OrderComplete;
    }
}

package cn.njthl.cleaner.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.presenter.CompelteAtPresenter;
import cn.njthl.cleaner.ui.view.ICompelteAtView;
import cn.njthl.cleaner.util.UIUtils;

public class CompelteActivity extends BaseActivity<ICompelteAtView, CompelteAtPresenter> implements ICompelteAtView {

    @BindView(R2.id.tvCorpName)
    TextView tvCorpName;


    @BindView(R2.id.imgImg1)
    ImageView img_photo1;

    @BindView(R2.id.imgImg2)
    ImageView img_photo2;

    @BindView(R2.id.imgImg3)
    ImageView img_photo3;

    @BindView(R2.id.imgImg4)
    ImageView img_photo4;

    @BindView(R2.id.imgImg5)
    ImageView img_photo5;

    @BindView(R2.id.imgImg6)
    ImageView img_photo6;

    @BindView(R2.id.imgImg7)
    ImageView img_photo7;

    @BindView(R2.id.imgImg8)
    ImageView img_photo8;


    @Override
    public void initData() {
        super.initData();
        mPresenter.getConversations();
    }
    @Override
    public void initView() {
        super.initView();
        StatusBarUtil.setColor(this, UIUtils.getColor(R.color.assist_green1), 10);
        setToolbarTitle("打扫详情");
    }

    @Override
    public void initListener() {
        super.initListener();
        img_photo1.setOnClickListener(v -> mPresenter.showImage(0));
        img_photo2.setOnClickListener(v -> mPresenter.showImage(1));
        img_photo3.setOnClickListener(v -> mPresenter.showImage(2));
        img_photo4.setOnClickListener(v -> mPresenter.showImage(3));
        img_photo5.setOnClickListener(v -> mPresenter.showImage(4));
        img_photo6.setOnClickListener(v -> mPresenter.showImage(5));
        img_photo7.setOnClickListener(v -> mPresenter.showImage(6));
        img_photo8.setOnClickListener(v -> mPresenter.showImage(7));
    }

    @Override
    public void requestPermissionResult(boolean allowPermission) {

    }

    @Override
    protected CompelteAtPresenter createPresenter() {
        return new CompelteAtPresenter(this);

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.at_compelte;
    }

    @Override
    public ImageView getImageView1() {
        return img_photo1;
    }

    @Override
    public ImageView getImageView2() {
        return img_photo2;
    }

    @Override
    public ImageView getImageView3() {
        return img_photo3;
    }

    @Override
    public ImageView getImageView4() {
        return img_photo4;
    }

    @Override
    public ImageView getImageView5() {
        return img_photo5;
    }

    @Override
    public ImageView getImageView6() {
        return img_photo6;
    }

    @Override
    public ImageView getImageView7() {
        return img_photo7;
    }

    @Override
    public ImageView getImageView8() {
        return img_photo8;
    }
}

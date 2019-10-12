package com.thl.cleaner.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.thl.cleaner.R;
import com.thl.cleaner.R2;
import com.thl.cleaner.ui.base.BaseActivity;
import com.thl.cleaner.ui.presenter.OrderCompleteAtPresenter;
import com.thl.cleaner.ui.view.IOrderCompleteAtView;

import butterknife.BindView;

public class OrderCompleteActivity extends BaseActivity<IOrderCompleteAtView, OrderCompleteAtPresenter> implements IOrderCompleteAtView {
    @BindView(R2.id.tvCorpName)
    TextView tvCorpName;

    @BindView(R2.id.img_photo1)
    ImageView img_photo1;
    @BindView(R2.id.img_photo2)
    ImageView img_photo2;
    @BindView(R2.id.img_photo3)
    ImageView img_photo3;
    @BindView(R2.id.btnComplete)
    Button btnComplete;


    @Override
    public void initListener() {
        super.initListener();
        btnComplete.setOnClickListener(v -> mPresenter.complete());
        img_photo1.setOnClickListener(v -> mPresenter.takephoto(1));
        img_photo2.setOnClickListener(v -> mPresenter.takephoto(2));
        img_photo3.setOnClickListener(v -> mPresenter.takephoto(3));
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == Activity.RESULT_OK) {

            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
                return;
            }
            Bundle bundle = data.getExtras();
            Bitmap bitmap_locktype = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式
//            PPBS_Code = CommonUtils.getCode();
            if (data!= null) {
                Bitmap cameraBitmap = (Bitmap) data.getExtras().get("data");
                System.out.println("fdf================="+data.getDataString());
                switch (requestCode){
                    case 1:
                        img_photo1.setImageBitmap(cameraBitmap);
                        break;
                    case 2:
                        img_photo2.setImageBitmap(cameraBitmap);
                        break;
                    case 3:
                        img_photo3.setImageBitmap(cameraBitmap);
                        break;
                }
                System.out.println("成功======"+cameraBitmap.getWidth()+cameraBitmap.getHeight());

            }
        }
    }
    @Override
    public void requestPermissionResult(boolean allowPermission) {

    }

    @Override
    protected OrderCompleteAtPresenter createPresenter() {
        return new OrderCompleteAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.at_order_complete;
    }

    @Override
    public TextView getTvRoomName() {
        return null;
    }

    @Override
    public ImageView getImgPhoto1() {
        return img_photo1;
    }

    @Override
    public ImageView getImgPhoto2() {
        return img_photo2;
    }

    @Override
    public ImageView getImgPhoto3() {
        return img_photo3;
    }

    @Override
    public Button getBtnComplete() {
        return btnComplete;
    }
}

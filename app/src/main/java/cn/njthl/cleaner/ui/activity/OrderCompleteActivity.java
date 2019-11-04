package cn.njthl.cleaner.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.presenter.OrderCompleteAtPresenter;
import cn.njthl.cleaner.ui.view.IOrderCompleteAtView;
import cn.njthl.cleaner.util.UIUtils;

import androidx.annotation.Nullable;
import butterknife.BindView;

public class OrderCompleteActivity extends BaseActivity<IOrderCompleteAtView, OrderCompleteAtPresenter> implements IOrderCompleteAtView {
    @BindView(R2.id.tvCorpName)
    TextView tvCorpName;

    @BindView(R2.id.tvPhotonum)
    TextView tvPhotonum;
    @BindView(R2.id.Takephoto)
    ImageView Takephoto;

    @BindView(R2.id.img_photo1)
    ImageView img_photo1;
    @BindView(R2.id.img_photo2)
    ImageView img_photo2;
    @BindView(R2.id.img_photo3)
    ImageView img_photo3;
    @BindView(R2.id.img_photo4)
    ImageView img_photo4;
    @BindView(R2.id.img_photo5)
    ImageView img_photo5;
    @BindView(R2.id.img_photo6)
    ImageView img_photo6;
    @BindView(R2.id.img_photo7)
    ImageView img_photo7;
    @BindView(R2.id.img_photo8)
    ImageView img_photo8;
    @BindView(R2.id.btnComplete)
    Button btnComplete;

    private int i=1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(this, UIUtils.getColor(R.color.assist_green1), 10);
    }

    @Override
    public void initListener() {
        super.initListener();
        btnComplete.setOnClickListener(v -> mPresenter.complete());
        Takephoto.setOnClickListener(v -> mPresenter.takephoto(i));
//        img_photo2.setOnClickListener(v -> mPresenter.takephoto(2));
//        img_photo3.setOnClickListener(v -> mPresenter.takephoto(3));
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
                mPresenter.setCameraBitmap(requestCode,cameraBitmap);
                switch (requestCode){
                    case 1:
                        img_photo1.setImageBitmap(cameraBitmap);
                        img_photo1.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        img_photo2.setImageBitmap(cameraBitmap);
                        img_photo2.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        img_photo3.setImageBitmap(cameraBitmap);
                        img_photo3.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        img_photo4.setImageBitmap(cameraBitmap);
                        img_photo4.setVisibility(View.VISIBLE);
                        break;

                    case 5:
                        img_photo5.setImageBitmap(cameraBitmap);
                        img_photo5.setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        img_photo6.setImageBitmap(cameraBitmap);
                        img_photo6.setVisibility(View.VISIBLE);
                        break;
                    case 7:
                        img_photo7.setImageBitmap(cameraBitmap);
                        img_photo7.setVisibility(View.VISIBLE);
                        break;
                    case 8:
                        img_photo8.setImageBitmap(cameraBitmap);
                        img_photo8.setVisibility(View.VISIBLE);
                        break;
                }
                System.out.println("成功======"+cameraBitmap.getWidth()+cameraBitmap.getHeight());

            }
            i = i +1;
            tvPhotonum.setText(""+(i-1));
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
    public ImageView getImgPhoto4() {
        return img_photo4;
    }

    @Override
    public ImageView getImgPhoto5() {
        return img_photo5;
    }

    @Override
    public ImageView getImgPhoto6() {
        return img_photo6;
    }

    @Override
    public ImageView getImgPhoto7() {
        return img_photo7;
    }

    @Override
    public ImageView getImgPhoto8() {
        return img_photo8;
    }

    @Override
    public Button getBtnComplete() {
        return btnComplete;
    }
}

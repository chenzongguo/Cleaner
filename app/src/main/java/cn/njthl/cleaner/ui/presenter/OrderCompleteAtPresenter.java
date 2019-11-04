package cn.njthl.cleaner.ui.presenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Toast;

import cn.njthl.cleaner.api.ApiRetrofit;
import cn.njthl.cleaner.model.request.cleaner.FinishOrderRoomRequest;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.IOrderCompleteAtView;
import cn.njthl.cleaner.util.ButtonUtils;
import cn.njthl.cleaner.util.ImageUtils;

import cn.njthl.cleaner.util.LogUtils;
import cn.njthl.cleaner.util.UIUtils;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OrderCompleteAtPresenter extends BasePresenter<IOrderCompleteAtView> {
    private Bitmap cameraBitmap1,cameraBitmap2,cameraBitmap3,cameraBitmap4,cameraBitmap5,cameraBitmap6,cameraBitmap7,cameraBitmap8;
    public OrderCompleteAtPresenter(BaseActivity context) {
        super(context);
    }
    public void complete(){
        if (!ButtonUtils.isFastDoubleClick()) {
            String order_room_id = mContext.getIntent().getStringExtra("order_room_id");
            String order_id = mContext.getIntent().getStringExtra("order_id");

            FinishOrderRoomRequest finishOrderRoomRequest = new FinishOrderRoomRequest();
            finishOrderRoomRequest.setOrder_id(order_id);

            finishOrderRoomRequest.setOrder_room_id(order_room_id);
            finishOrderRoomRequest.setUser_remark("保洁员测试备注");
//        ImageUtils.bufferImage(getView().getImgPhoto1().getDrawable());
            getView().getImgPhoto1().setDrawingCacheEnabled(true);
            getView().getImgPhoto2().setDrawingCacheEnabled(true);
            getView().getImgPhoto3().setDrawingCacheEnabled(true);
            getView().getImgPhoto4().setDrawingCacheEnabled(true);
            getView().getImgPhoto5().setDrawingCacheEnabled(true);
            getView().getImgPhoto6().setDrawingCacheEnabled(true);
            getView().getImgPhoto7().setDrawingCacheEnabled(true);
            getView().getImgPhoto8().setDrawingCacheEnabled(true);
            Bitmap bitmap=getView().getImgPhoto1().getDrawingCache();
            FinishOrderRoomRequest.Pic_array pic_array = new FinishOrderRoomRequest.Pic_array();
            if(bitmap==null){
                Toast.makeText(mContext, "请拍摄照片", Toast.LENGTH_SHORT).show();
                return;
            }
            pic_array.setPic_one(ImageUtils.Bitmap_to_base64(cameraBitmap1));
            if(getView().getImgPhoto2().getDrawingCache()==null){
                Toast.makeText(mContext, "请拍摄照片2", Toast.LENGTH_SHORT).show();
                return;
            }
            if(getView().getImgPhoto3().getDrawingCache()==null){
                Toast.makeText(mContext, "请拍摄照片3", Toast.LENGTH_SHORT).show();
                return;
            }
            if(getView().getImgPhoto4().getDrawingCache()==null){
                Toast.makeText(mContext, "请拍摄照片4", Toast.LENGTH_SHORT).show();
                return;
            }
            if(getView().getImgPhoto5().getDrawingCache()==null){
                Toast.makeText(mContext, "请拍摄照片5", Toast.LENGTH_SHORT).show();
                return;
            }
            if(getView().getImgPhoto6().getDrawingCache()==null){
                Toast.makeText(mContext, "请拍摄照片6", Toast.LENGTH_SHORT).show();
                return;
            }

            if(getView().getImgPhoto7().getDrawingCache()==null){
                Toast.makeText(mContext, "请拍摄照片7", Toast.LENGTH_SHORT).show();
                return;
            }

            if(getView().getImgPhoto8().getDrawingCache()==null){
                Toast.makeText(mContext, "请拍摄照片8", Toast.LENGTH_SHORT).show();
                return;
            }

            pic_array.setPic_two(ImageUtils.Bitmap_to_base64(cameraBitmap2));
            pic_array.setPic_three(ImageUtils.Bitmap_to_base64(cameraBitmap3));
            pic_array.setPic_four(ImageUtils.Bitmap_to_base64(cameraBitmap4));
            pic_array.setPic_five(ImageUtils.Bitmap_to_base64(cameraBitmap5));
            pic_array.setPic_six(ImageUtils.Bitmap_to_base64(cameraBitmap6));
            pic_array.setPic_seven(ImageUtils.Bitmap_to_base64(cameraBitmap7));
            pic_array.setPic_eight(ImageUtils.Bitmap_to_base64(cameraBitmap8));
            finishOrderRoomRequest.setPic_array(pic_array);
//        finishOrderRoomRequest.setService_pic_one(ImageUtils.Bitmap_to_base64(bitmap));
//        finishOrderRoomRequest.setUser_id("5");
            getView().getImgPhoto1().setDrawingCacheEnabled(false);
            mContext.showWaitingDialog("正在上传");
            ApiRetrofit.getInstance().finishOrderRoom(finishOrderRoomRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(getBaseResponse -> {
                        String code = getBaseResponse.getCode();
                        mContext.hideWaitingDialog();
                        if("000".equals(code)){
                            getView().getBtnComplete().setEnabled(false);
                            getView().getBtnComplete().setText("订单已完成");
                            Toast.makeText(mContext, "提交信息成功", Toast.LENGTH_SHORT).show();
                            mContext.finish();
                        }else{
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(mContext, getBaseResponse.getErrMessage(), Toast.LENGTH_SHORT).show();
                        }
                    },this::loginError);
        }

    }
    public void takephoto(int i){
        if(i>8){
            Toast.makeText(mContext, "最多只能拍八张照片", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        mContext.startActivityForResult(intent, i);
    }

    public void setCameraBitmap(int i,Bitmap cameraBitmap){
        switch (i){
            case 1:
                cameraBitmap1 = cameraBitmap;
                break;
            case 2:
                cameraBitmap2 = cameraBitmap;
                break;
            case 3:
                cameraBitmap3 = cameraBitmap;
                break;
            case 4:
                cameraBitmap4 = cameraBitmap;
                break;

            case 5:
                cameraBitmap5 = cameraBitmap;
                break;
            case 6:
                cameraBitmap6 = cameraBitmap;
                break;
            case 7:
                cameraBitmap7 = cameraBitmap;
                break;
            case 8:
                cameraBitmap8 = cameraBitmap;
                break;
        }
    }
    private void loginError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
        if (mContext == null || mContext.isDestroyed() || mContext.isFinishing()) {
            return;
        }
        mContext.hideWaitingDialog();
    }
}

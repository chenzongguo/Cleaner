package com.thl.cleaner.ui.presenter;

import android.graphics.Bitmap;
import android.widget.Toast;

import com.thl.cleaner.api.ApiRetrofit;
import com.thl.cleaner.model.request.cleaner.CleanerDoorRequest;
import com.thl.cleaner.model.request.cleaner.FinishOrderRoomRequest;
import com.thl.cleaner.ui.base.BaseActivity;
import com.thl.cleaner.ui.base.BasePresenter;
import com.thl.cleaner.ui.view.IOrderCompleteAtView;
import com.thl.cleaner.util.ImageUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OrderCompleteAtPresenter extends BasePresenter<IOrderCompleteAtView> {
    public OrderCompleteAtPresenter(BaseActivity context) {
        super(context);
    }
    public void complete(){
       String order_room_id = mContext.getIntent().getStringExtra("order_room_id");
        String order_id = mContext.getIntent().getStringExtra("order_id");

        FinishOrderRoomRequest finishOrderRoomRequest = new FinishOrderRoomRequest();
        finishOrderRoomRequest.setOrder_id(order_id);

        finishOrderRoomRequest.setOrder_room_id(order_room_id);
        finishOrderRoomRequest.setUser_remark("保洁员测试备注");
//        ImageUtils.bufferImage(getView().getImgPhoto1().getDrawable());
        getView().getImgPhoto1().getDrawable();
        getView().getImgPhoto1().setDrawingCacheEnabled(true);
        Bitmap bitmap=getView().getImgPhoto1().getDrawingCache();
        finishOrderRoomRequest.setService_pic_one(ImageUtils.Bitmap_to_base64(bitmap));
//        finishOrderRoomRequest.setUser_id("5");
        getView().getImgPhoto1().setDrawingCacheEnabled(false);
        ApiRetrofit.getInstance().finishOrderRoom(finishOrderRoomRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getBaseResponse -> {
                    String code = getBaseResponse.getCode();
                    if("000".equals(code)){
//                            getView().getBtnParnterReceipt().setEnabled(false);
                        Toast.makeText(mContext, "提交信息成功", Toast.LENGTH_SHORT).show();
                    }else{
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(mContext, getBaseResponse.getErrMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

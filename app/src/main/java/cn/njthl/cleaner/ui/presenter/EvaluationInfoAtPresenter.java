package cn.njthl.cleaner.ui.presenter;

import android.graphics.Bitmap;

import cn.njthl.cleaner.api.ApiRetrofit;
import cn.njthl.cleaner.model.request.GetOrderRoomRatingRequest;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.IEvaluationInfoView;
import cn.njthl.cleaner.util.ImageUtils;
import cn.njthl.cleaner.util.LogUtils;
import cn.njthl.cleaner.util.UIUtils;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class EvaluationInfoAtPresenter extends BasePresenter<IEvaluationInfoView> {
    public EvaluationInfoAtPresenter(BaseActivity context) {
        super(context);
    }

    public void getConversations() {
        loadData();

    }
    private void  loadData(){
        String user_rating_id = mContext.getIntent().getStringExtra("user_rating_id");
        GetOrderRoomRatingRequest getOrderRoomRatingRequest = new GetOrderRoomRatingRequest();
        getOrderRoomRatingRequest.setType("2");
        getOrderRoomRatingRequest.setUser_rating_id(user_rating_id);
        ApiRetrofit.getInstance().getOrderRoomRating(getOrderRoomRatingRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getOrderRoomRatingResponse -> {
                    String code = getOrderRoomRatingResponse.getCode();
                    if("000".equals(code)){
                        Bitmap bitmap = ImageUtils.base64ToBitmap(getOrderRoomRatingResponse.getData().getRating_pic_one());
                        getView().getImageView1().setImageBitmap(bitmap);
                        getView().getcleanliness_star().setRating(Integer.parseInt(getOrderRoomRatingResponse.getData().getCleanliness_star()));
                        getView().getorder_speed_star().setRating(Integer.parseInt(getOrderRoomRatingResponse.getData().getOrder_speed_star()));
                        getView().getTvRatingExplain().setText(getOrderRoomRatingResponse.getData().getRating_explain());
//                        getView().getImageView2().setImageBitmap(ImageUtils.base64ToBitmap(getCleanPicResponse.getData().getPic_two()));
//                        getView().getImageView3().setImageBitmap(ImageUtils.base64ToBitmap(getCleanPicResponse.getData().getPic_three()));
//                        orderBeanList =  getOrderListResponse.getData().getPaging_data();
////                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
////                        registerReceiver();
//                        if(orderBeanList!=null && orderBeanList.size()>0){
//                            setAdapter();
//                            getView().getImaNoOrder().setVisibility(View.GONE);
//                        }else{
//                            getView().getImaNoOrder().setVisibility(View.VISIBLE);
//                        }


                    }else{
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                    }
                },this::loginError);
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

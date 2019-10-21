package cn.njthl.cleaner.ui.presenter;

import android.graphics.Bitmap;

import cn.njthl.cleaner.api.ApiRetrofit;
import cn.njthl.cleaner.model.request.GetCleanPicRequest;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.ICompelteAtView;
import cn.njthl.cleaner.util.ImageUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CompelteAtPresenter extends BasePresenter<ICompelteAtView> {
    public CompelteAtPresenter(BaseActivity context) {
        super(context);
    }

    public void getConversations() {
        loadData();

    }
    private void  loadData(){
        String pic_id = mContext.getIntent().getStringExtra("pic_id");
        GetCleanPicRequest getCleanPicRequest = new GetCleanPicRequest();
        getCleanPicRequest.setType("1");
        getCleanPicRequest.setPic_id(pic_id);
        ApiRetrofit.getInstance().getCleanPic(getCleanPicRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getCleanPicResponse -> {
                    String code = getCleanPicResponse.getCode();
                    if("000".equals(code)){
                        Bitmap bitmap = ImageUtils.base64ToBitmap(getCleanPicResponse.getData().getPic_one());
                        getView().getImageView1().setImageBitmap(bitmap);
                        getView().getImageView2().setImageBitmap(ImageUtils.base64ToBitmap(getCleanPicResponse.getData().getPic_two()));
                        getView().getImageView3().setImageBitmap(ImageUtils.base64ToBitmap(getCleanPicResponse.getData().getPic_three()));
                        getView().getImageView4().setImageBitmap(ImageUtils.base64ToBitmap(getCleanPicResponse.getData().getPic_four()));
                        getView().getImageView5().setImageBitmap(ImageUtils.base64ToBitmap(getCleanPicResponse.getData().getPic_five()));
                        getView().getImageView6().setImageBitmap(ImageUtils.base64ToBitmap(getCleanPicResponse.getData().getPic_six()));
                        getView().getImageView7().setImageBitmap(ImageUtils.base64ToBitmap(getCleanPicResponse.getData().getPic_seven()));
                        getView().getImageView8().setImageBitmap(ImageUtils.base64ToBitmap(getCleanPicResponse.getData().getPic_eight()));
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
                });
    }
}

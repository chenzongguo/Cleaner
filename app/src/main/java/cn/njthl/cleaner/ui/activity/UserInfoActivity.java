package cn.njthl.cleaner.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.api.ApiRetrofit;
import cn.njthl.cleaner.app.MyApp;
import cn.njthl.cleaner.model.request.GetUserListRequest;
import cn.njthl.cleaner.model.response.GetUserListResponse;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.util.LogUtils;
import cn.njthl.cleaner.util.SPUtils;
import cn.njthl.cleaner.util.UIUtils;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserInfoActivity extends BaseActivity {

    @BindView(R2.id.tvName)
    TextView tvName;

    @BindView(R2.id.tvCert_no)
    TextView tvCert_no;

    @BindView(R2.id.tvPhone)
    TextView tvPhone;

    @BindView(R2.id.tvSex)
    TextView tvSex;

    @BindView(R2.id.ImgIDcardFace)
    ImageView ImgIDcardFace;

    @BindView(R2.id.ImgIDcardBack)
    ImageView ImgIDcardBack;

    @BindView(R2.id.ImgFace)
    ImageView ImgFace;

    private String  user_id;
    private GetUserListResponse getUserListResponse;

    @Override
    public void initView() {
        super.initView();
        loadData();
    }

    private void  loadData(){
//        user_id = getIntent().getStringExtra("user_id");
        user_id = SPUtils.getInstance(MyApp.getContext()).getString("USER_ID","");
        GetUserListRequest getUserListRequest = new GetUserListRequest();
        getUserListRequest.setType("2");
        getUserListRequest.setUser_id(user_id);
        getUserListRequest.setPartner_id("1");//商户id
        ApiRetrofit.getInstance().getUserList(getUserListRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getUserListResponse -> {
                    String code = getUserListResponse.getCode();
                    if("000".equals(code)){
                        this.getUserListResponse = getUserListResponse;
                        if(getUserListResponse.getData()!=null&&getUserListResponse.getData().size()>0){
//                            items = new String[getUserListResponse.getData().size()];
//                            for (int i = 0; i < items.length; i++){
//                                items[i] = getUserListResponse.getData().get(i).getName();
//                            }
                            setText();
                        }else{
                            Toast.makeText(this, "人员信息异常", Toast.LENGTH_SHORT).show();
                        }
//                        orderRoomBeanList =  getOrderResponse.getData().getCorp_room_data();
////                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
////                        registerReceiver();
//                        setAdapter();
//                        initView(getOrderResponse);
                    }else{
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(this, getUserListResponse.getErrMessage(), Toast.LENGTH_SHORT).show();
                    }
                },this::loginError);
    }

    private void setText(){
        tvName.setText(getUserListResponse.getData().get(0).getName());
        tvCert_no.setText(getUserListResponse.getData().get(0).getCert_no());
        if("1".equals(getUserListResponse.getData().get(0).getSex())){
            tvSex.setText("男");
        }else if("2".equals(getUserListResponse.getData().get(0).getSex())){
            tvSex.setText("女");
        }
        tvPhone.setText(getUserListResponse.getData().get(0).getContact_phone());
    }
    @Override
    public void requestPermissionResult(boolean allowPermission) {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.at_user_info;
    }
    private void loginError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
        if (this == null || this.isDestroyed() || this.isFinishing()) {
            return;
        }
        hideWaitingDialog();
    }
}

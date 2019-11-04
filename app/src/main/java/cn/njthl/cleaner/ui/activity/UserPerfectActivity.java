package cn.njthl.cleaner.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import cn.njthl.cleaner.R;
import cn.njthl.cleaner.R2;
import cn.njthl.cleaner.api.ApiRetrofit;
import cn.njthl.cleaner.app.AppConst;
import cn.njthl.cleaner.app.MyApp;
import cn.njthl.cleaner.model.Bean.UserPerfectBean;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.util.ImageUtils;
import cn.njthl.cleaner.util.LogUtils;
import cn.njthl.cleaner.util.SPUtils;
import cn.njthl.cleaner.util.UIUtils;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserPerfectActivity extends BaseActivity {
    @BindView(R2.id.etName)
    EditText etName;

    @BindView(R2.id.etCert_no)
    EditText etCert_no;

    @BindView(R2.id.etPhone)
    EditText mEtPhone;

    @BindView(R2.id.tvSex)
    TextView tvSex;

    @BindView(R2.id.ImgIDcardFace)
    ImageView ImgIDcardFace;

    @BindView(R2.id.ImgIDcardBack)
    ImageView ImgIDcardBack;

    @BindView(R2.id.ImgFace)
    ImageView ImgFace;

    @BindView(R2.id.ImgIDcardFace1)
    ImageView ImgIDcardFace1;

    @BindView(R2.id.ImgIDcardBack1)
    ImageView ImgIDcardBack1;

    @BindView(R2.id.ImgFace1)
    ImageView ImgFace1;

    @BindView(R2.id.btnUserPerfect)
    Button btnUserPerfect;

    private String[] items = new  String[] {"男", "女"};
    private String sexCode;
    private boolean IDcardFace_isOk,IDcardBack_isOk,Face_isOk;

    @Override
    public void initView() {
        super.initView();
        setToolbarTitle("完善信息");
        StatusBarUtil.setColor(this, UIUtils.getColor(R.color.assist_green1), 10);
    }
    @Override
    public void initListener() {
        super.initListener();
        ImgIDcardFace1.setOnClickListener(v -> takephoto(1));
        ImgIDcardBack1.setOnClickListener(v -> takephoto(2));
        ImgFace1.setOnClickListener(v -> takephoto(3));
        tvSex.setOnClickListener(v -> showGoalDialog("选择性别"));
        btnUserPerfect.setOnClickListener(v -> userPerfect());
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
                        IDcardFace_isOk = true;
                        ImgIDcardFace.setImageBitmap(cameraBitmap);
                        break;
                    case 2:
                        IDcardBack_isOk = true;
                        ImgIDcardBack.setImageBitmap(cameraBitmap);
                        break;
                    case 3:
                        Face_isOk = true;
                        ImgFace.setImageBitmap(cameraBitmap);
                        break;
                }

            }
        }
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
        return R.layout.at_user_perfect;
    }


    private void showGoalDialog(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle(str);
        builder.setCancelable(false);
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                if(which==0){
                    sexCode  = "1";
                    tvSex.setText("  "+items[which].toString());
                }else{
                    sexCode  = "2";
                    tvSex.setText("  "+items[which].toString());
                }
                dialog.dismiss();
            }

        });
//        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//            }
//       });
        builder.show();
    }

    private boolean validate(){
        if (TextUtils.isEmpty(etName.getText().toString().trim())) {
            UIUtils.showToast("请填写姓名");
            return false;
        }
        if (TextUtils.isEmpty(etCert_no.getText().toString().trim())) {
            UIUtils.showToast("请填写身份证号");
            return false;
        }
        if (TextUtils.isEmpty(mEtPhone.getText().toString().trim())) {
            UIUtils.showToast("请填写手机号");
            return false;
        }
        if(!IDcardFace_isOk){
            Toast.makeText(this, "请拍摄身份证正面照片", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!IDcardBack_isOk){
            Toast.makeText(this, "请拍摄身份证反面照片", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!Face_isOk){
            Toast.makeText(this, "请拍摄本人现场照片", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    private void userPerfect(){
        if(!validate()){
            return;
        }
        showWaitingDialog("正在上传信息，请稍后");
        UserPerfectBean userPerfectBean = new UserPerfectBean();
        userPerfectBean.setType("1");
        userPerfectBean.setName(etName.getText().toString());
        userPerfectBean.setCert_no(etCert_no.getText().toString());
        userPerfectBean.setUser_id(SPUtils.getInstance(MyApp.getContext()).getString("USER_ID",""));
        userPerfectBean.setSex("1");
        userPerfectBean.setAge("26");
        userPerfectBean.setContact_phone(mEtPhone.getText().toString());
        userPerfectBean.setService_type("1");
        ImgIDcardFace.setDrawingCacheEnabled(true);
        ImgIDcardBack.setDrawingCacheEnabled(true);
        ImgFace.setDrawingCacheEnabled(true);
        userPerfectBean.setIdcard_face_pic(ImageUtils.Bitmap_to_base64(ImgIDcardFace.getDrawingCache()));
        userPerfectBean.setIdcard_back_pic(ImageUtils.Bitmap_to_base64(ImgIDcardBack.getDrawingCache()));
        userPerfectBean.setLive_face_pic(ImageUtils.Bitmap_to_base64(ImgFace.getDrawingCache()));

        ApiRetrofit.getInstance().userPerfectData(userPerfectBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseResponse -> {
                    String code = baseResponse.getCode();
                    if("000".equals(code)){
//                        AppConst.USER_TOKEN = userLoginResponse.getData().getUser_token();
//                        AppConst.USER_ID = userLoginResponse.getData().getUser_id();
//                        AppConst.ROLE_ID = userLoginResponse.getData().getRole_id();
//                        if(userLoginResponse.getData().getIs_complete().equals("0"))
//                            mContext.jumpToActivityAndClearTask(UserPerfectActivity.class);
//                        else
                        AppConst.Is_complete = "1";
                            jumpToActivityAndClearTask(MainActivity.class);
                            hideWaitingDialog();
//                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
//                        registerReceiver();
                    }else{
                        hideWaitingDialog();
                        Toast.makeText(this, baseResponse.getErrMessage(), Toast.LENGTH_SHORT).show();
                    }
                },this::loginError);
    }
    public void takephoto(int i){
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, i);
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

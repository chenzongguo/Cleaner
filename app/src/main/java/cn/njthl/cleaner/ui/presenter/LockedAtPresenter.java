package cn.njthl.cleaner.ui.presenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import cn.njthl.cleaner.app.SPConstant;
import cn.njthl.cleaner.db.model.Customer;
import cn.njthl.cleaner.db.model.Photo;
import cn.njthl.cleaner.db.model.UnlockBusiness;
import cn.njthl.cleaner.hw.CardInfo;
import cn.njthl.cleaner.hw.ReadCard;
import cn.njthl.cleaner.hw.ReadCardListener;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.ILockedAtView;
import cn.njthl.cleaner.util.SPUtils;
import cn.njthl.cleaner.util.TimeUtils;
import cn.njthl.cleaner.util.UIUtils;

public class LockedAtPresenter extends BasePresenter<ILockedAtView> implements ReadCardListener {
    private ReadCard mReadCard;
    String PPBS_AreaCode,PPBS_ResaonCode,PPBS_110Code,PPBS_LockTypeCode,Cus_NationCode;
    private String[] items, items1, items2, items3, items4, items5;
    public LockedAtPresenter(BaseActivity context) {
        super(context);
    }
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    getView().GetTvList().get(0).setText("  "+items[msg.arg1].toString());
                    if(msg.arg1 < 8){
                        PPBS_AreaCode = "32010"+msg.arg1;
                    }else if(msg.arg1 < 12){
                        PPBS_AreaCode = "3201"+(msg.arg1 +3 );
                    }else if(msg.arg1 < 16){
                        PPBS_AreaCode = "3201"+(msg.arg1 +4 );
                    }else if(msg.arg1 < 21){
                        PPBS_AreaCode = "3201"+(msg.arg1 +5 );
                    }else if(msg.arg1 < 12){
                        PPBS_AreaCode = "3201"+(msg.arg1 +10 );
                    }
                    break;
                case 1:
                    getView().GetTvList().get(1).setText("  "+items1[msg.arg1].toString());
                    if(msg.arg1 == 5){
                        PPBS_ResaonCode="99";
                    }else{
                        PPBS_ResaonCode = "0"+(msg.arg1+1);
                    }

                    break;
                case 2:
                    getView().GetTvList().get(2).setText("  "+items2[msg.arg1].toString());
                    if(msg.arg1 == 3){
                        PPBS_110Code = "99";
                    }else{
                        PPBS_110Code = "0"+(msg.arg1+1);
                    }
                    break;
                case 3:
                    getView().GetTvList().get(3).setText("  "+items3[msg.arg1].toString());
                    if(msg.arg1 == 6){
                        PPBS_LockTypeCode = "99";
                    }else{
                        PPBS_LockTypeCode = "0"+(msg.arg1+1);
                    }
                    break;
                case 4:
                    getView().GetEtList().get(2).setText("  "+items4[msg.arg1].toString());
                    if(msg.arg1 > 8){
                        Cus_NationCode = ""+(msg.arg1+1);
                    }else{
                        Cus_NationCode = "0"+(msg.arg1+1);
                    }
                    break;
                case 5:
                    getView().GetEtList().get(1).setText("  "+items5[msg.arg1].toString());
                    break;
            }
        }
    };

    private void showGoalDialog(final int i,final String[] items, String str) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(str);
        builder.setCancelable(false);
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Message msg = new Message();
                msg.what = i;
                msg.arg1 = which;
                handler.sendMessage(msg);
                dialog.dismiss();
            }
        });
        builder.show();
    }
    public void areaOnclick(){
        items = new  String[] {"南京市", "南京市市辖区", "南京市玄武区" , "南京市白下区", "南京市秦淮区",
                "南京市建邺区", "南京市鼓楼区" , "南京市下关区", "南京市浦口区" , "南京市沿江工业开发区（原大厂）",
                "南京市栖霞区" , "南京市雨花台区", "南京市高新开发区" , "南京市水上分局", "南京市公交分局",
                "南京市经济技术开发区" , "南京市江宁区", "南京市浦口区（原江浦县）" , "南京市六合区", "南京市溧水县",
                "南京市高淳县" , "南京市新华分局", "南京市平顶山分局" , "南京市九龙分局"};
        showGoalDialog(0,items,"选择开锁区域");
    }
    public void lockedResonOnclick(){
        items1 = new  String[] {"锁已损坏", "钥匙损坏", "钥匙遗失" , "钥匙忘带", "更坏锁芯", "其他"};
        showGoalDialog(1,items1,"选择开锁原因");
    }
    public void sourceOfBusOnclick(){
        items2 = new  String[] {"私人需求", "110指派", "派出所指派" , "其他"};
        showGoalDialog(2,items2,"选择业务来源");
    }
    public void lockTypeOnclick(){
        items3 = new  String[] {"车辆", "箱柜", "住宅" , "办公用房", "库房", "门店", "其他"};
        showGoalDialog(3,items3,"选择锁具类型");
    }
    public void nationOnclick(){
        items4 = new  String[] {"汉族", "蒙古族", "回族" , "藏族", "维吾尔族", "苗族","彝族","壮族",
                "布依族","朝鲜族","满族","侗族","瑶族","白族","土家族","哈尼族","哈萨克族","傣族","黎族",
                "傈僳族","佤族","畲族","高山族","拉祜族","水族","东乡族","纳西族","景颇族","柯尔克孜族",
                "土族","达斡尔族","仫佬族","羌族","布朗族","撒拉族","毛难族","仡佬族","锡伯族","阿昌族",
                "普米族","塔吉克族","怒族","乌孜别克族","俄罗斯族","鄂温克族","德昂族","保安族","裕固族",
                "京族","塔塔尔族","独龙族","鄂伦春族","赫哲族","门巴族","珞巴族","基诺族"};

        showGoalDialog(4,items4,"选择民族");
    }

    public void ReadCardinit(){
        if(mReadCard==null){
            mReadCard = new ReadCard(mContext);
            mReadCard.setReadCardListener(this);
            mReadCard.connect();
        }
    }
    public void stopReadCard() {
        mReadCard.disconnect();
    }

    public void save(){

    };
    private boolean validate(){
        if(TextUtils.isEmpty(getView().GetEtList().get(0).getText().toString())){
            UIUtils.showToast("姓名不能为空");
            return false;
        }else if(TextUtils.isEmpty(getView().GetEtList().get(1).getText().toString())){
            UIUtils.showToast("性别不能为空");
            return false;
        }else if(TextUtils.isEmpty(getView().GetEtList().get(2).getText().toString())){
            UIUtils.showToast("民族不能为空");
            return false;
        }else if(TextUtils.isEmpty(getView().GetEtList().get(4).getText().toString())){
            UIUtils.showToast("身份证号不能为空");
            return false;
        }else if(TextUtils.isEmpty(getView().GetEtList().get(3).getText().toString())){
            UIUtils.showToast("户籍地址不能为空");
            return false;
        }else if(TextUtils.isEmpty(getView().GetEtList().get(5).getText().toString())){
            UIUtils.showToast("联系电话不能为空");
            return false;
        }else if(TextUtils.isEmpty(getView().GetEtList().get(6).getText().toString())){
            UIUtils.showToast("详细地址不能为空");
            return false;
        }else if(TextUtils.isEmpty(getView().GetTvList().get(0).getText().toString())){
            UIUtils.showToast("开锁区域不能为空");
            return false;
        }else if(TextUtils.isEmpty(getView().GetTvList().get(1).getText().toString())){
            UIUtils.showToast("开锁原因不能为空");
            return false;
        }else if(TextUtils.isEmpty(getView().GetTvList().get(2).getText().toString())){
            UIUtils.showToast("业务来源不能为空");
            return false;
        }else if(TextUtils.isEmpty(getView().GetTvList().get(3).getText().toString())){
            UIUtils.showToast("锁具类型不能为空");
            return false;
//        }else if(bitmap_locktype == null){
//            UIUtils.showToast("请拍摄锁具照片");
//            return false;
        }else{
            return true;
        }
    }
    private void setBean(){
        Customer custrbean= new Customer();
        UnlockBusiness busbean = new UnlockBusiness();
        Photo custrphotobean = new Photo();
        Photo  busphotobean = new Photo();


        String Cus_Code = SPUtils.getInstance(mContext).getString(SPConstant.Enterprise_Code,"") +
                TimeUtils.getDateTime2()+"49"+SPUtils.getInstance(mContext).getString(SPConstant.IMEI,"");
        String PPBS_Code = SPUtils.getInstance(mContext).getString(SPConstant.Enterprise_Code,"") +
                TimeUtils.getDateTime2()+"50"+SPUtils.getInstance(mContext).getString(SPConstant.IMEI,"");

        custrbean.setCus_Code(Cus_Code);
        custrbean.setCus_Name(getView().GetEtList().get(0).getText().toString());
        custrbean.setCus_Sex(getView().GetEtList().get(1).getText().toString());
        if("男".equals(getView().GetEtList().get(1).getText().toString())){
            custrbean.setCus_SexCode("1");
        }else{
            custrbean.setCus_SexCode("2");
        }
        custrbean.setCus_Nation(getView().GetEtList().get(2).getText().toString());
        custrbean.setCus_NationCode(Cus_NationCode);
//        custrbean.setCus_Birthday(edtBirth.getText().toString());
        custrbean.setCus_Number(getView().GetEtList().get(4).getText().toString());
        custrbean.setCus_Addr(getView().GetEtList().get(3).getText().toString());
        custrbean.setCus_Tel(getView().GetEtList().get(5).getText().toString());

        custrbean.setCus_Photo_id(Cus_Code);
        custrbean.setCus_Finish("1");
        custrbean.setCus_UpLoaded("0");
        custrbean.setCus_Uploaded_DateTime("");
//        if(is_exist){
//            UnLockInfo.updateCustomerInfo(Cus_Code, custrbean);
//        }else{
//            while(!UnLockInfo.saveCustomerInfo(custrbean));
//        }
        busbean.setPPBS_Code(PPBS_Code);
        busbean.setCus_Code(Cus_Code);
        busbean.setPPBS_Area(getView().GetTvList().get(0).getText().toString().trim());
        busbean.setPPBS_AreaCode(PPBS_AreaCode);
        busbean.setPPBS_Addr(getView().GetEtList().get(6).getText().toString());
        busbean.setPPBS_Resaon(getView().GetTvList().get(1).getText().toString().trim());
         busbean.setPPBS_ResaonCode(PPBS_ResaonCode);
        busbean.setPPBS_110(getView().GetTvList().get(2).getText().toString().trim());
        busbean.setPPBS_LockTypeCode(PPBS_LockTypeCode);
        busbean.setPPBS_LockType(getView().GetTvList().get(3).getText().toString().trim());
        busbean.setPPBS_Photo_Code(PPBS_Code);
        busbean.setPPBS_Unlock_Charge("");
        busbean.setPPBS_Material_Cost("");
        busbean.setPPBS_Finish("1");
        busbean.setPPBS_Unlock_Person(SPUtils.getInstance(mContext).getString(SPConstant.User_Number,""));
//        busbean.setPPBS_Total_Cost(edtTotal.getText().toString());
//        while(!UnLockInfo.saveBusinessInfo(busbean));

        custrphotobean.setPhoto_Code(Cus_Code);
//        custrphotobean.setPhoto_Content(bitmap_idcard);
//        custrphotobean.setPhoto_InputTime(CommonUtils.getDateTime5());
        custrphotobean.setPhoto_Type("1");
        custrphotobean.setPhoto_Desc(Cus_Code);
//        if(is_exist){
//            UnLockInfo.updatePhotoInfo(Cus_Code,custrphotobean);
//        }else{
//            while(!UnLockInfo.savePhotoInfo(custrphotobean));
//        }
        busphotobean.setPhoto_Code(PPBS_Code);
//        busphotobean.setPhoto_Content(bitmap_locktype);
//        busphotobean.setPhoto_InputTime(CommonUtils.getDateTime5());
        busphotobean.setPhoto_Type("2");
        busphotobean.setPhoto_Desc(PPBS_Code);
//        while(!UnLockInfo.savePhotoInfo(busphotobean));
//        proDialog.dismiss();
        UIUtils.showToast("登记成功");
    }
    private void clear(){
        getView().GetEtList().get(0).setText("");
        getView().GetEtList().get(1).setText("");
        getView().GetEtList().get(2).setText("");
        getView().GetEtList().get(3).setText("");
        getView().GetEtList().get(4).setText("");
        getView().GetEtList().get(5).setText("");
        getView().GetEtList().get(6).setText("");
        getView().GetTvList().get(0).setText("");
        getView().GetTvList().get(1).setText("");
        getView().GetTvList().get(2).setText("");
        getView().GetTvList().get(3).setText("");
    }

    @Override
    public void readInfoSuccess(CardInfo cardInfo) {
        getView().GetEtList().get(0).setText(cardInfo.Name.trim());
        getView().GetEtList().get(1).setText(cardInfo.Gender);
        getView().GetEtList().get(2).setText(cardInfo.NationalString);
//        getView().GetEtList().get(3).setText(cardInfo.Birthday);
        getView().GetEtList().get(3).setText(cardInfo.Address.trim());
        getView().GetEtList().get(4).setText(cardInfo.IndentityCard);
//        custrbean.setCus_NationCode(cardInfo.National);
//        custrbean.setCus_Date_Issue_1(cardInfo.StartDate);
//        custrbean.setCus_Date_Issue_2(cardInfo.EndDate);
//        custrbean.setCus_Issuing_Authority(cardInfo.Issued.trim());
    }

    @Override
    public void readBmpSuccess(Bitmap bitmap) {
//        bitmap_idcard = bitmap;
        getView().GetImgList().get(0).setImageBitmap(bitmap);
    }

    @Override
    public void readError(String error) {
//        getView().GetTvList().get(4).setText(error);
    }

    @Override
    public void readStatus(String status) {
//        getView().GetTvList().get(4).setText(status);
    }
}

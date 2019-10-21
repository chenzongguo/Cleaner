package cn.njthl.cleaner.db.model;

import org.litepal.crud.LitePalSupport;

public class Customer extends LitePalSupport {
    String Cus_Code = "Cus_Code";  //客户编码
    String Cus_Name = "Cus_Name";	//姓名
    String Cus_Sex = "Cus_Sex";//性别
    String Cus_SexCode = "Cus_SexCode";//性别
    String Cus_Nation = "Cus_Nation";//民族
    String Cus_NationCode = "Cus_NationCode";//民族编码
    String Cus_Birthday = "Cus_Birthday";//出生日期
    String Cus_Number = "Cus_Number";//证件号码
    String Cus_Addr = "Cus_Addr";//地址
    String Cus_Date_Issue_1 = "Cus_Date_Issue_1";//签发日期1
    String Cus_Date_Issue_2 = "Cus_Date_Issue_2";//签发日期2
    String Cus_Issuing_Authority = "Cus_Issuing_Authority";//签发机关
    String Cus_Photo_id = "Cus_Photo_id";//照片==图片表主键
    String Cus_Tel = "Cus_Tel";//联系电话
    String Cus_Mobile = "Cus_Mobile";//客户手机
    String Cus_InputTime = "Cus_InputTime";//入库时间
    String Cus_Finish = "Cus_Finish";//客户信息完成标记(0.未，1.已)
    String Cus_UpLoaded = "Cus_UpLoaded";//上传标记(0.未，1.已)
    String Cus_Uploaded_DateTime = "Cus_Uploaded_DateTime";//上传时间

    public String getCus_Code() {
        return Cus_Code;
    }

    public void setCus_Code(String cus_Code) {
        Cus_Code = cus_Code;
    }

    public String getCus_Name() {
        return Cus_Name;
    }

    public void setCus_Name(String cus_Name) {
        Cus_Name = cus_Name;
    }

    public String getCus_Sex() {
        return Cus_Sex;
    }

    public void setCus_Sex(String cus_Sex) {
        Cus_Sex = cus_Sex;
    }

    public String getCus_SexCode() {
        return Cus_SexCode;
    }

    public void setCus_SexCode(String cus_SexCode) {
        Cus_SexCode = cus_SexCode;
    }

    public String getCus_Nation() {
        return Cus_Nation;
    }

    public void setCus_Nation(String cus_Nation) {
        Cus_Nation = cus_Nation;
    }

    public String getCus_NationCode() {
        return Cus_NationCode;
    }

    public void setCus_NationCode(String cus_NationCode) {
        Cus_NationCode = cus_NationCode;
    }

    public String getCus_Birthday() {
        return Cus_Birthday;
    }

    public void setCus_Birthday(String cus_Birthday) {
        Cus_Birthday = cus_Birthday;
    }

    public String getCus_Number() {
        return Cus_Number;
    }

    public void setCus_Number(String cus_Number) {
        Cus_Number = cus_Number;
    }

    public String getCus_Addr() {
        return Cus_Addr;
    }

    public void setCus_Addr(String cus_Addr) {
        Cus_Addr = cus_Addr;
    }

    public String getCus_Date_Issue_1() {
        return Cus_Date_Issue_1;
    }

    public void setCus_Date_Issue_1(String cus_Date_Issue_1) {
        Cus_Date_Issue_1 = cus_Date_Issue_1;
    }

    public String getCus_Date_Issue_2() {
        return Cus_Date_Issue_2;
    }

    public void setCus_Date_Issue_2(String cus_Date_Issue_2) {
        Cus_Date_Issue_2 = cus_Date_Issue_2;
    }

    public String getCus_Issuing_Authority() {
        return Cus_Issuing_Authority;
    }

    public void setCus_Issuing_Authority(String cus_Issuing_Authority) {
        Cus_Issuing_Authority = cus_Issuing_Authority;
    }

    public String getCus_Photo_id() {
        return Cus_Photo_id;
    }

    public void setCus_Photo_id(String cus_Photo_id) {
        Cus_Photo_id = cus_Photo_id;
    }

    public String getCus_Tel() {
        return Cus_Tel;
    }

    public void setCus_Tel(String cus_Tel) {
        Cus_Tel = cus_Tel;
    }

    public String getCus_Mobile() {
        return Cus_Mobile;
    }

    public void setCus_Mobile(String cus_Mobile) {
        Cus_Mobile = cus_Mobile;
    }

    public String getCus_InputTime() {
        return Cus_InputTime;
    }

    public void setCus_InputTime(String cus_InputTime) {
        Cus_InputTime = cus_InputTime;
    }

    public String getCus_Finish() {
        return Cus_Finish;
    }

    public void setCus_Finish(String cus_Finish) {
        Cus_Finish = cus_Finish;
    }

    public String getCus_UpLoaded() {
        return Cus_UpLoaded;
    }

    public void setCus_UpLoaded(String cus_UpLoaded) {
        Cus_UpLoaded = cus_UpLoaded;
    }

    public String getCus_Uploaded_DateTime() {
        return Cus_Uploaded_DateTime;
    }

    public void setCus_Uploaded_DateTime(String cus_Uploaded_DateTime) {
        Cus_Uploaded_DateTime = cus_Uploaded_DateTime;
    }
}

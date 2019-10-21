package cn.njthl.cleaner.db.model;

import org.litepal.crud.LitePalSupport;

public class UnlockBusiness extends LitePalSupport {
    String PPBS_Code = "PPBS_Code";  //记录编码
    String Cus_Code = "Cus_Code";	//客户编码
    String Company_Code = "Company_Code";//无
    String PPBS_Object = "PPBS_Object";//无
    String PPBS_Area = "PPBS_Area";//开锁区域
    String PPBS_AreaCode = "PPBS_AreaCode";//开锁区域编码
    String PPBS_Addr = "PPBS_Addr";//开锁地址
    String PPBS_Resaon = "PPBS_Resaon";//开锁原因
    String PPBS_ResaonCode = "PPBS_ResaonCode";//开锁原因编码
    String PPBS_LockType = "PPBS_LockType";//锁类型(字典)
    String PPBS_LockTypeCode = "PPBS_LockTypeCode";//锁类型编码
    String PPBS_Photo_Code = "PPBS_Photo_Code";//锁具标的物特征[外键,表h_Photo]
    String PPBS_Unlock_Person = "PPBS_Unlock_Person";//开锁人（身份证号）
    String PPBS_110 = "PPBS_110";//业务来源
    String PPBS_110Code = "PPBS_110Code";//业务来源
    String PPBS_Bill_Code = "PPBS_Bill_Code";//开锁客户联编号(无)
    String PPBS_Unlock_DateTime = "PPBS_Unlock_DateTime";//开锁时间
    String PPBS_Unlock_Charge = "PPBS_Unlock_Charge";//开锁服务费
    String PPBS_Material_Cost = "PPBS_Material_Cost";//开锁材料费
    String PPBS_Total_Cost = "PPBS_Total_Cost";//费用合计
    String PPBS_Reg_Person = "PPBS_Reg_Person";//登记人
    String PPBS_Reg_DateTime = "PPBS_Reg_DateTime";//登记时间
    String PPBS_RegCompany_Code = "PPBS_RegCompany_Code";//机构编码
    String PPBS_Finish = "PPBS_Finish";//业务完成标记
    String PPBS_UpLoaded = "PPBS_UpLoaded";//上传标记
    String PPBS_UpLoaded_DateTime = "PPBS_UpLoaded_DateTime";//上传时间

    public String getPPBS_Code() {
        return PPBS_Code;
    }

    public void setPPBS_Code(String PPBS_Code) {
        this.PPBS_Code = PPBS_Code;
    }

    public String getCus_Code() {
        return Cus_Code;
    }

    public void setCus_Code(String cus_Code) {
        Cus_Code = cus_Code;
    }

    public String getCompany_Code() {
        return Company_Code;
    }

    public void setCompany_Code(String company_Code) {
        Company_Code = company_Code;
    }

    public String getPPBS_Object() {
        return PPBS_Object;
    }

    public void setPPBS_Object(String PPBS_Object) {
        this.PPBS_Object = PPBS_Object;
    }

    public String getPPBS_Area() {
        return PPBS_Area;
    }

    public void setPPBS_Area(String PPBS_Area) {
        this.PPBS_Area = PPBS_Area;
    }

    public String getPPBS_AreaCode() {
        return PPBS_AreaCode;
    }

    public void setPPBS_AreaCode(String PPBS_AreaCode) {
        this.PPBS_AreaCode = PPBS_AreaCode;
    }

    public String getPPBS_Addr() {
        return PPBS_Addr;
    }

    public void setPPBS_Addr(String PPBS_Addr) {
        this.PPBS_Addr = PPBS_Addr;
    }

    public String getPPBS_Resaon() {
        return PPBS_Resaon;
    }

    public void setPPBS_Resaon(String PPBS_Resaon) {
        this.PPBS_Resaon = PPBS_Resaon;
    }

    public String getPPBS_ResaonCode() {
        return PPBS_ResaonCode;
    }

    public void setPPBS_ResaonCode(String PPBS_ResaonCode) {
        this.PPBS_ResaonCode = PPBS_ResaonCode;
    }

    public String getPPBS_LockType() {
        return PPBS_LockType;
    }

    public void setPPBS_LockType(String PPBS_LockType) {
        this.PPBS_LockType = PPBS_LockType;
    }

    public String getPPBS_LockTypeCode() {
        return PPBS_LockTypeCode;
    }

    public void setPPBS_LockTypeCode(String PPBS_LockTypeCode) {
        this.PPBS_LockTypeCode = PPBS_LockTypeCode;
    }

    public String getPPBS_Photo_Code() {
        return PPBS_Photo_Code;
    }

    public void setPPBS_Photo_Code(String PPBS_Photo_Code) {
        this.PPBS_Photo_Code = PPBS_Photo_Code;
    }

    public String getPPBS_Unlock_Person() {
        return PPBS_Unlock_Person;
    }

    public void setPPBS_Unlock_Person(String PPBS_Unlock_Person) {
        this.PPBS_Unlock_Person = PPBS_Unlock_Person;
    }

    public String getPPBS_110() {
        return PPBS_110;
    }

    public void setPPBS_110(String PPBS_110) {
        this.PPBS_110 = PPBS_110;
    }

    public String getPPBS_110Code() {
        return PPBS_110Code;
    }

    public void setPPBS_110Code(String PPBS_110Code) {
        this.PPBS_110Code = PPBS_110Code;
    }

    public String getPPBS_Bill_Code() {
        return PPBS_Bill_Code;
    }

    public void setPPBS_Bill_Code(String PPBS_Bill_Code) {
        this.PPBS_Bill_Code = PPBS_Bill_Code;
    }

    public String getPPBS_Unlock_DateTime() {
        return PPBS_Unlock_DateTime;
    }

    public void setPPBS_Unlock_DateTime(String PPBS_Unlock_DateTime) {
        this.PPBS_Unlock_DateTime = PPBS_Unlock_DateTime;
    }

    public String getPPBS_Unlock_Charge() {
        return PPBS_Unlock_Charge;
    }

    public void setPPBS_Unlock_Charge(String PPBS_Unlock_Charge) {
        this.PPBS_Unlock_Charge = PPBS_Unlock_Charge;
    }

    public String getPPBS_Material_Cost() {
        return PPBS_Material_Cost;
    }

    public void setPPBS_Material_Cost(String PPBS_Material_Cost) {
        this.PPBS_Material_Cost = PPBS_Material_Cost;
    }

    public String getPPBS_Total_Cost() {
        return PPBS_Total_Cost;
    }

    public void setPPBS_Total_Cost(String PPBS_Total_Cost) {
        this.PPBS_Total_Cost = PPBS_Total_Cost;
    }

    public String getPPBS_Reg_Person() {
        return PPBS_Reg_Person;
    }

    public void setPPBS_Reg_Person(String PPBS_Reg_Person) {
        this.PPBS_Reg_Person = PPBS_Reg_Person;
    }

    public String getPPBS_Reg_DateTime() {
        return PPBS_Reg_DateTime;
    }

    public void setPPBS_Reg_DateTime(String PPBS_Reg_DateTime) {
        this.PPBS_Reg_DateTime = PPBS_Reg_DateTime;
    }

    public String getPPBS_RegCompany_Code() {
        return PPBS_RegCompany_Code;
    }

    public void setPPBS_RegCompany_Code(String PPBS_RegCompany_Code) {
        this.PPBS_RegCompany_Code = PPBS_RegCompany_Code;
    }

    public String getPPBS_Finish() {
        return PPBS_Finish;
    }

    public void setPPBS_Finish(String PPBS_Finish) {
        this.PPBS_Finish = PPBS_Finish;
    }

    public String getPPBS_UpLoaded() {
        return PPBS_UpLoaded;
    }

    public void setPPBS_UpLoaded(String PPBS_UpLoaded) {
        this.PPBS_UpLoaded = PPBS_UpLoaded;
    }

    public String getPPBS_UpLoaded_DateTime() {
        return PPBS_UpLoaded_DateTime;
    }

    public void setPPBS_UpLoaded_DateTime(String PPBS_UpLoaded_DateTime) {
        this.PPBS_UpLoaded_DateTime = PPBS_UpLoaded_DateTime;
    }
}

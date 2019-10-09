package com.thl.cleaner.db.model;

import org.litepal.crud.LitePalSupport;

public class SysUser extends LitePalSupport {
    String User_Code = "User_Code";  //用户编码
    String User_Id = "User_Id";	//用户名
    String User_Pwd = "User_Pwd";//用户密码
    String User_Name = "User_Name";//姓名
    String User_Number = "User_Number";//用户身份证号码
    String User_Power = "User_Power";//权限
    String User_Added_Type = "User_Added_Type";//是否为本地添加用户
    String User_En_Tertime = "User_En_Tertime";//入库时间

    public String getUser_Code() {
        return User_Code;
    }

    public void setUser_Code(String user_Code) {
        User_Code = user_Code;
    }

    public String getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(String user_Id) {
        User_Id = user_Id;
    }

    public String getUser_Pwd() {
        return User_Pwd;
    }

    public void setUser_Pwd(String user_Pwd) {
        User_Pwd = user_Pwd;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Number() {
        return User_Number;
    }

    public void setUser_Number(String user_Number) {
        User_Number = user_Number;
    }

    public String getUser_Power() {
        return User_Power;
    }

    public void setUser_Power(String user_Power) {
        User_Power = user_Power;
    }

    public String getUser_Added_Type() {
        return User_Added_Type;
    }

    public void setUser_Added_Type(String user_Added_Type) {
        User_Added_Type = user_Added_Type;
    }

    public String getUser_En_Tertime() {
        return User_En_Tertime;
    }

    public void setUser_En_Tertime(String user_En_Tertime) {
        User_En_Tertime = user_En_Tertime;
    }
}

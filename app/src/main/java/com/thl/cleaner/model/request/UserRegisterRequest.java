package com.thl.cleaner.model.request;

public class UserRegisterRequest {
    private String type="";//注册方式标识(1账号密码2微信)
    private String user_phone="";//登陆手机号
    private String user_pwd="";//登陆密码
    private String role_id="";//权限id
    private String openid="";//微信openid
    private String head_portrait="";//头像

    public UserRegisterRequest(String user_phone,String user_pwd){
        this.user_phone = user_phone;
        this.user_pwd = user_pwd;
        this.type = "1";
        this.role_id = "2";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getHead_portrait() {
        return head_portrait;
    }

    public void setHead_portrait(String head_portrait) {
        this.head_portrait = head_portrait;
    }
}

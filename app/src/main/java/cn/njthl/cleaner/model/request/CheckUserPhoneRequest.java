package cn.njthl.cleaner.model.request;

public class CheckUserPhoneRequest {
    private String user_phone="";//登陆手机号
    public CheckUserPhoneRequest(String user_phone){
        this.user_phone = user_phone;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}

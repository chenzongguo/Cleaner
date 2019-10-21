package cn.njthl.cleaner.model.request;

public class CheckCaptchaRequest {
    private String phone_num;

    private String captcha;

    public CheckCaptchaRequest(String phone_num, String captcha){
        this.phone_num = phone_num;
        this.captcha = captcha;
    }
    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}

package com.thl.cleaner.model.request;

public class SendCaptchaRequest {
    private String phone_num;

    public SendCaptchaRequest(String phone_num){
        this.phone_num = phone_num;
    }
    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }


}

package cn.njthl.cleaner.model.request;

import cn.njthl.cleaner.util.SPUtils;
import cn.njthl.cleaner.util.TimeUtils;

public class GetTokenRequest {
    private String appid;

    private String time;

    private String ciphertext;

    public GetTokenRequest(String appid) {
        this.appid = appid;
        this.time = TimeUtils.getDateTime16();
        this.ciphertext = SPUtils.MD5(appid+time);
    }
}

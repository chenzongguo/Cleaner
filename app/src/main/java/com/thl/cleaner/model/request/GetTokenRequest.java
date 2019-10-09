package com.thl.cleaner.model.request;

import com.thl.cleaner.util.SPUtils;
import com.thl.cleaner.util.TimeUtils;

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

package com.thl.cleaner.model.request;

public class ChangeStateRequest {
    private String imei;
    private String update_status;

    public ChangeStateRequest(String imei, String update_status) {
        this.imei = imei;
        this.update_status = update_status;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getUpdate_status() {
        return update_status;
    }

    public void setUpdate_status(String update_status) {
        this.update_status = update_status;
    }

}

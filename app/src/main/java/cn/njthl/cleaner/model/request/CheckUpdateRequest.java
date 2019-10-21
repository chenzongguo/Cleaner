package cn.njthl.cleaner.model.request;


import cn.njthl.cleaner.app.MyApp;
import cn.njthl.cleaner.util.SystemUtil;

public class CheckUpdateRequest {
    private String imei;
    private String version_code;
    private String version_name;
    private String user_name;
    private String id_number;
    private String phone_models;
    private String system_version;

    public CheckUpdateRequest(String user_name, String id_number) {
        this.imei = SystemUtil.getIMEI(MyApp.getInstance());
        this.version_code = "3";
        this.version_name = "1.0";
        this.user_name = user_name;
        this.id_number = id_number;
        this.phone_models = SystemUtil.getSystemModel();
        this.system_version = SystemUtil.getSystemVersion();
    }


    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getVersion_code() {
        return version_code;
    }

    public void setVersion_code(String version_code) {
        this.version_code = version_code;
    }

    public String getVersion_name() {
        return version_name;
    }

    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getPhone_models() {
        return phone_models;
    }

    public void setPhone_models(String phone_models) {
        this.phone_models = phone_models;
    }

    public String getSystem_version() {
        return system_version;
    }

    public void setSystem_version(String system_version) {
        this.system_version = system_version;
    }


}

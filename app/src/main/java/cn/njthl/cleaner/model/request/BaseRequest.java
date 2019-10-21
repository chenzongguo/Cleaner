package cn.njthl.cleaner.model.request;

public class BaseRequest {
    private String token;
    private String params;

    public BaseRequest(String token,String params){
        this.token = token;
        this.params = params;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

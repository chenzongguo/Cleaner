package cn.njthl.cleaner.model.response;

import java.util.List;

import cn.njthl.cleaner.model.Bean.UserBean;

public class GetUserListResponse {

    private String code;

    private String errMessage;

    private List<UserBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public List<UserBean> getData() {
        return data;
    }

    public void setData(List<UserBean> data) {
        this.data = data;
    }
}

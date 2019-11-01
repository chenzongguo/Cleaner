package cn.njthl.cleaner.model.response;

public class UserLoginResponse {
    private String code;

    private String errMessage;

    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data{
        private String user_id;
        private String user_token;
        private String role_id;
        private String is_complete;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_token() {
            return user_token;
        }

        public void setUser_token(String user_token) {
            this.user_token = user_token;
        }

        public String getRole_id() {
            return role_id;
        }
        public void setRole_id(String role_id) {
            this.role_id = role_id;
        }

        public String getIs_complete() {
            return is_complete;
        }

        public void setIs_complete(String is_complete) {
            this.is_complete = is_complete;
        }
    }
}

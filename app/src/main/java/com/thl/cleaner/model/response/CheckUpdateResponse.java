package com.thl.cleaner.model.response;

public class CheckUpdateResponse {
    private String code;

    private String errMessage;

    private Data data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return errMessage;
    }

    public void setMessage(String message) {
        this.errMessage = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data{
        private String new_version_code;
        private String update_type;
        private String file_name;
        private String download_address;
        private String md5_value;
        private String update_content;

        public String getNew_version_code() {
            return new_version_code;
        }

        public void setNew_version_code(String new_version_code) {
            this.new_version_code = new_version_code;
        }

        public String getUpdate_type() {
            return update_type;
        }

        public void setUpdate_type(String update_type) {
            this.update_type = update_type;
        }

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }

        public String getDownload_address() {
            return download_address;
        }

        public void setDownload_address(String download_address) {
            this.download_address = download_address;
        }

        public String getMd5_value() {
            return md5_value;
        }

        public void setMd5_value(String md5_value) {
            this.md5_value = md5_value;
        }

        public String getUpdate_content() {
            return update_content;
        }

        public void setUpdate_content(String update_content) {
            this.update_content = update_content;
        }
    }
}

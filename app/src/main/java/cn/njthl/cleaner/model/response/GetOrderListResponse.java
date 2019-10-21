package cn.njthl.cleaner.model.response;

import cn.njthl.cleaner.model.Bean.CleanerOrderBean;

import java.util.List;

public class GetOrderListResponse{
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
        private String data_number;
        private String isEnd;//0无1有
        private List<CleanerOrderBean> paging_data;

        public String getData_number() {
            return data_number;
        }

        public void setData_number(String data_number) {
            this.data_number = data_number;
        }

        public String getIsEnd() {
            return isEnd;
        }

        public void setIsEnd(String isEnd) {
            this.isEnd = isEnd;
        }

        public List<CleanerOrderBean> getPaging_data() {
            return paging_data;
        }

        public void setPaging_data(List<CleanerOrderBean> paging_data) {
            this.paging_data = paging_data;
        }
    }

}

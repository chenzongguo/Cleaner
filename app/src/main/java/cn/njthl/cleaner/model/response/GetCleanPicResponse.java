package cn.njthl.cleaner.model.response;

public class GetCleanPicResponse {
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
        private String pic_id;
        private String external_id;
        private String clean_remark;
        private String pic_one ="";//照片1
        private String pic_two ="";//照片1
        private String pic_three ="";//照片1
        private String pic_four ="";//照片1
        private String pic_five ="";//照片1
        private String pic_six ="";//照片1
        private String pic_seven ="";//照片1
        private String pic_eight ="";//照片1

        public String getPic_id() {
            return pic_id;
        }

        public void setPic_id(String pic_id) {
            this.pic_id = pic_id;
        }

        public String getExternal_id() {
            return external_id;
        }

        public void setExternal_id(String external_id) {
            this.external_id = external_id;
        }

        public String getClean_remark() {
            return clean_remark;
        }

        public void setClean_remark(String clean_remark) {
            this.clean_remark = clean_remark;
        }

        public String getPic_one() {
            return pic_one;
        }

        public void setPic_one(String pic_one) {
            this.pic_one = pic_one;
        }

        public String getPic_two() {
            return pic_two;
        }

        public void setPic_two(String pic_two) {
            this.pic_two = pic_two;
        }

        public String getPic_three() {
            return pic_three;
        }

        public void setPic_three(String pic_three) {
            this.pic_three = pic_three;
        }

        public String getPic_four() {
            return pic_four;
        }

        public void setPic_four(String pic_four) {
            this.pic_four = pic_four;
        }

        public String getPic_five() {
            return pic_five;
        }

        public void setPic_five(String pic_five) {
            this.pic_five = pic_five;
        }

        public String getPic_six() {
            return pic_six;
        }

        public void setPic_six(String pic_six) {
            this.pic_six = pic_six;
        }

        public String getPic_seven() {
            return pic_seven;
        }

        public void setPic_seven(String pic_seven) {
            this.pic_seven = pic_seven;
        }

        public String getPic_eight() {
            return pic_eight;
        }

        public void setPic_eight(String pic_eight) {
            this.pic_eight = pic_eight;
        }
    }
}

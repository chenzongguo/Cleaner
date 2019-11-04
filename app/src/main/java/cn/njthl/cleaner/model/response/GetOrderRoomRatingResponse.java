package cn.njthl.cleaner.model.response;

public class GetOrderRoomRatingResponse {
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
        private String user_rating_id;//
        private String order_id;//
        private String order_room_id;//
        private String cleanliness_star;//
        private String order_speed_star;//
        private String rating_reason;//
        private String rating_explain;//
        private String rating_pic_one;//
        private String rating_pic_two;//
        private String rating_pic_three;//
        private String rating_pic_four;//
        private String rating_pic_five;//
        private String rating_pic_six;//
        private String rating_pic_seven;//
        private String rating_pic_eight;//
        private String create_time;//

        public String getUser_rating_id() {
            return user_rating_id;
        }

        public void setUser_rating_id(String user_rating_id) {
            this.user_rating_id = user_rating_id;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getOrder_room_id() {
            return order_room_id;
        }

        public void setOrder_room_id(String order_room_id) {
            this.order_room_id = order_room_id;
        }

        public String getCleanliness_star() {
            return cleanliness_star;
        }

        public void setCleanliness_star(String cleanliness_star) {
            this.cleanliness_star = cleanliness_star;
        }

        public String getOrder_speed_star() {
            return order_speed_star;
        }

        public void setOrder_speed_star(String order_speed_star) {
            this.order_speed_star = order_speed_star;
        }

        public String getRating_reason() {
            return rating_reason;
        }

        public void setRating_reason(String rating_reason) {
            this.rating_reason = rating_reason;
        }

        public String getRating_explain() {
            return rating_explain;
        }

        public void setRating_explain(String rating_explain) {
            this.rating_explain = rating_explain;
        }

        public String getRating_pic_one() {
            return rating_pic_one;
        }

        public void setRating_pic_one(String rating_pic_one) {
            this.rating_pic_one = rating_pic_one;
        }

        public String getRating_pic_two() {
            return rating_pic_two;
        }

        public void setRating_pic_two(String rating_pic_two) {
            this.rating_pic_two = rating_pic_two;
        }

        public String getRating_pic_three() {
            return rating_pic_three;
        }

        public void setRating_pic_three(String rating_pic_three) {
            this.rating_pic_three = rating_pic_three;
        }

        public String getRating_pic_four() {
            return rating_pic_four;
        }

        public void setRating_pic_four(String rating_pic_four) {
            this.rating_pic_four = rating_pic_four;
        }

        public String getRating_pic_five() {
            return rating_pic_five;
        }

        public void setRating_pic_five(String rating_pic_five) {
            this.rating_pic_five = rating_pic_five;
        }

        public String getRating_pic_six() {
            return rating_pic_six;
        }

        public void setRating_pic_six(String rating_pic_six) {
            this.rating_pic_six = rating_pic_six;
        }

        public String getRating_pic_seven() {
            return rating_pic_seven;
        }

        public void setRating_pic_seven(String rating_pic_seven) {
            this.rating_pic_seven = rating_pic_seven;
        }

        public String getRating_pic_eight() {
            return rating_pic_eight;
        }

        public void setRating_pic_eight(String rating_pic_eight) {
            this.rating_pic_eight = rating_pic_eight;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }
    }
}

package com.thl.cleaner.model.request.cleaner;

import java.util.List;

public class FinishOrderRoomRequest {
    private String order_id ="";//用户id
//    private String user_id ="";//用户id
    private String order_room_id ="";//订单房间id
    private String user_remark ="";//保洁员备注
    private Pic_array pic_array;

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

    public String getUser_remark() {
        return user_remark;
    }

    public void setUser_remark(String user_remark) {
        this.user_remark = user_remark;
    }

    public Pic_array getPic_array() {
        return pic_array;
    }

    public void setPic_array(Pic_array pic_array) {
        this.pic_array = pic_array;
    }

    public static class Pic_array{
        private String pic_one ="";//照片1
        private String pic_two ="";//照片1
        private String pic_three ="";//照片1
        private String pic_four ="";//照片1
        private String pic_five ="";//照片1
        private String pic_six ="";//照片1
        private String pic_seven ="";//照片1
        private String pic_eight ="";//照片1

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

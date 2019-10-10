package com.thl.cleaner.model.response.cleaner;

import com.thl.cleaner.model.Bean.OrderGoodsBean;
import com.thl.cleaner.model.Bean.OrderServicesBean;

import java.util.List;

public class CleanerOrderResponse {
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
        private String order_id;
        private String order_room_id;
        private String corp_id;
        private String corp_name;
        private String corp_addr;
        private String lon;
        private String lat;
        private String corp_room_id;
        private String corp_room_name;
        private String room_type_id;
        private String room_type_name;
        private String bed_num;
        private String room_area_id;
        private String room_area_name;
        private String order_room_remark;
        private String order_room_state;
        private String door_time;
        private String is_overtime;
        private String dispatch_time;
        private String receipt_time;
        private String remark;
        private String user_remark;
        private List<OrderGoodsBean> order_goods_data;
        private List<OrderServicesBean> order_services_data;
//        private String rating_data;

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

        public String getCorp_id() {
            return corp_id;
        }

        public void setCorp_id(String corp_id) {
            this.corp_id = corp_id;
        }

        public String getCorp_name() {
            return corp_name;
        }

        public void setCorp_name(String corp_name) {
            this.corp_name = corp_name;
        }

        public String getCorp_addr() {
            return corp_addr;
        }

        public void setCorp_addr(String corp_addr) {
            this.corp_addr = corp_addr;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getCorp_room_id() {
            return corp_room_id;
        }

        public void setCorp_room_id(String corp_room_id) {
            this.corp_room_id = corp_room_id;
        }

        public String getCorp_room_name() {
            return corp_room_name;
        }

        public void setCorp_room_name(String corp_room_name) {
            this.corp_room_name = corp_room_name;
        }

        public String getRoom_type_id() {
            return room_type_id;
        }

        public void setRoom_type_id(String room_type_id) {
            this.room_type_id = room_type_id;
        }

        public String getRoom_type_name() {
            return room_type_name;
        }

        public void setRoom_type_name(String room_type_name) {
            this.room_type_name = room_type_name;
        }

        public String getBed_num() {
            return bed_num;
        }

        public void setBed_num(String bed_num) {
            this.bed_num = bed_num;
        }

        public String getRoom_area_id() {
            return room_area_id;
        }

        public void setRoom_area_id(String room_area_id) {
            this.room_area_id = room_area_id;
        }

        public String getRoom_area_name() {
            return room_area_name;
        }

        public void setRoom_area_name(String room_area_name) {
            this.room_area_name = room_area_name;
        }

        public String getOrder_room_remark() {
            return order_room_remark;
        }

        public void setOrder_room_remark(String order_room_remark) {
            this.order_room_remark = order_room_remark;
        }

        public String getDoor_time() {
            return door_time;
        }

        public void setDoor_time(String door_time) {
            this.door_time = door_time;
        }

        public String getIs_overtime() {
            return is_overtime;
        }

        public void setIs_overtime(String is_overtime) {
            this.is_overtime = is_overtime;
        }

        public String getDispatch_time() {
            return dispatch_time;
        }

        public void setDispatch_time(String dispatch_time) {
            this.dispatch_time = dispatch_time;
        }

        public String getReceipt_time() {
            return receipt_time;
        }

        public void setReceipt_time(String receipt_time) {
            this.receipt_time = receipt_time;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getUser_remark() {
            return user_remark;
        }

        public void setUser_remark(String user_remark) {
            this.user_remark = user_remark;
        }

        public List<OrderGoodsBean> getOrder_goods_data() {
            return order_goods_data;
        }

        public void setOrder_goods_data(List<OrderGoodsBean> order_goods_data) {
            this.order_goods_data = order_goods_data;
        }

        public List<OrderServicesBean> getOrder_services_data() {
            return order_services_data;
        }

        public void setOrder_services_data(List<OrderServicesBean> order_services_data) {
            this.order_services_data = order_services_data;
        }

//        public String getRating_data() {
//            return rating_data;
//        }
//
//        public void setRating_data(String rating_data) {
//            this.rating_data = rating_data;
//        }

        public String getOrder_room_state() {
            return order_room_state;
        }

        public void setOrder_room_state(String order_room_state) {
            this.order_room_state = order_room_state;
        }
    }
}

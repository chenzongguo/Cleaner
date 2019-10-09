package com.thl.cleaner.model.response;

import com.thl.cleaner.model.Bean.OrderRoomBean;

import java.util.List;

public class GetOrderResponse {
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
        private String corp_id;
        private String corp_name;
        private String corp_addr;
        private String lon;
        private String lat;
        private String wx_user_id;
        private String door_time;
        private String contacts;
        private String contact_phone;
        private String remark;
        private String payable_price;
        private String discount_price;
        private String payment_price;
        private String create_time;
        private String partner_id;
        private String partner_name;
        private String over_time;
        private String is_complaint;
        private String chargeback_time;
        private String chargeback_reason;
        private List<OrderRoomBean> corp_room_data;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
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

        public String getWx_user_id() {
            return wx_user_id;
        }

        public void setWx_user_id(String wx_user_id) {
            this.wx_user_id = wx_user_id;
        }

        public String getDoor_time() {
            return door_time;
        }

        public void setDoor_time(String door_time) {
            this.door_time = door_time;
        }

        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts;
        }

        public String getContact_phone() {
            return contact_phone;
        }

        public void setContact_phone(String contact_phone) {
            this.contact_phone = contact_phone;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getPayable_price() {
            return payable_price;
        }

        public void setPayable_price(String payable_price) {
            this.payable_price = payable_price;
        }

        public String getDiscount_price() {
            return discount_price;
        }

        public void setDiscount_price(String discount_price) {
            this.discount_price = discount_price;
        }

        public String getPayment_price() {
            return payment_price;
        }

        public void setPayment_price(String payment_price) {
            this.payment_price = payment_price;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getPartner_id() {
            return partner_id;
        }

        public void setPartner_id(String partner_id) {
            this.partner_id = partner_id;
        }

        public String getPartner_name() {
            return partner_name;
        }

        public void setPartner_name(String partner_name) {
            this.partner_name = partner_name;
        }

        public String getOver_time() {
            return over_time;
        }

        public void setOver_time(String over_time) {
            this.over_time = over_time;
        }

        public String getIs_complaint() {
            return is_complaint;
        }

        public void setIs_complaint(String is_complaint) {
            this.is_complaint = is_complaint;
        }

        public String getChargeback_time() {
            return chargeback_time;
        }

        public void setChargeback_time(String chargeback_time) {
            this.chargeback_time = chargeback_time;
        }

        public String getChargeback_reason() {
            return chargeback_reason;
        }

        public void setChargeback_reason(String chargeback_reason) {
            this.chargeback_reason = chargeback_reason;
        }

        public List<OrderRoomBean> getCorp_room_data() {
            return corp_room_data;
        }

        public void setCorp_room_data(List<OrderRoomBean> corp_room_data) {
            this.corp_room_data = corp_room_data;
        }
    }
}

package com.thl.cleaner.model.Bean;

import java.util.List;

public class OrderRoomBean {
    public String getOrder_room_id() {
        return order_room_id;
    }

    public void setOrder_room_id(String order_room_id) {
        this.order_room_id = order_room_id;
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

    public List<OrderGoodsBean> getOrder_goods_data() {
        return order_goods_data;
    }

    public void setOrder_goods_data(List<OrderGoodsBean> order_goods_data) {
        this.order_goods_data = order_goods_data;
    }

    public String getOrder_services_data() {
        return order_services_data;
    }

    public void setOrder_services_data(String order_services_data) {
        this.order_services_data = order_services_data;
    }

    public String getRating_data() {
        return rating_data;
    }

    public void setRating_data(String rating_data) {
        this.rating_data = rating_data;
    }

    private String order_room_id ="";
    private String corp_room_id ="";
    private String corp_room_name ="";
    private String room_type_id ="";
    private String bed_num ="";
    private String room_area_id ="";
    private List<OrderGoodsBean> order_goods_data;
    private String order_services_data ="";
    private String rating_data ="";
}

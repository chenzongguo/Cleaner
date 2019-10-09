package com.thl.cleaner.model.request.cleaner;

public class CleanerOrderListRequest {
    private String user_id ="";//商户id
    private String order_room_state ="";//订单房间状态
    private String is_working ="";//订单房间状态
    private String start_number ="";//开始位置
    private String select_number ="";//查询条数

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOrder_room_state() {
        return order_room_state;
    }

    public void setOrder_room_state(String order_room_state) {
        this.order_room_state = order_room_state;
    }

    public String getStart_number() {
        return start_number;
    }

    public void setStart_number(String start_number) {
        this.start_number = start_number;
    }

    public String getSelect_number() {
        return select_number;
    }

    public void setSelect_number(String select_number) {
        this.select_number = select_number;
    }

    public String getIs_working() {
        return is_working;
    }

    public void setIs_working(String is_working) {
        this.is_working = is_working;
    }
}

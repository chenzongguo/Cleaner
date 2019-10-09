package com.thl.cleaner.model.request;

public class GetOrderListRequest {
    private String type;//查询标识(1全部2商户3微信用户)
    private String partner_id;//商户id
    private String wx_user_id;//微信用户id
    private String order_state;//订单状态
    private String create_start_time;//下单开始时间
    private String create_stop_time;//下单结束时间
//    private String current_page;//
    private String start_number;//开始位置
    private String select_number;//查询条数

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(String partner_id) {
        this.partner_id = partner_id;
    }

    public String getWx_user_id() {
        return wx_user_id;
    }

    public void setWx_user_id(String wx_user_id) {
        this.wx_user_id = wx_user_id;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public String getCreate_start_time() {
        return create_start_time;
    }

    public void setCreate_start_time(String create_start_time) {
        this.create_start_time = create_start_time;
    }

    public String getCreate_stop_time() {
        return create_stop_time;
    }

    public void setCreate_stop_time(String create_stop_time) {
        this.create_stop_time = create_stop_time;
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
}

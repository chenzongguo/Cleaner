package com.thl.cleaner.model.request.cleaner;

public class FinishOrderRoomRequest {
    private String order_id ="";//用户id
//    private String user_id ="";//用户id
    private String order_room_id ="";//订单房间id
    private String user_remark ="";//保洁员备注
    private String service_pic_one ="";//照片1
    private String service_pic_two ="";//照片1
    private String service_pic_three ="";//照片1

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

    public String getService_pic_one() {
        return service_pic_one;
    }

    public void setService_pic_one(String service_pic_one) {
        this.service_pic_one = service_pic_one;
    }

    public String getService_pic_two() {
        return service_pic_two;
    }

    public void setService_pic_two(String service_pic_two) {
        this.service_pic_two = service_pic_two;
    }

    public String getService_pic_three() {
        return service_pic_three;
    }

    public void setService_pic_three(String service_pic_three) {
        this.service_pic_three = service_pic_three;
    }
}

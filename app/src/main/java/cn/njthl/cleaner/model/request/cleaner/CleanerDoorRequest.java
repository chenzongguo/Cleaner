package cn.njthl.cleaner.model.request.cleaner;

public class CleanerDoorRequest {
    private String user_id ="";//用户id
    private String order_room_id ="";//订单房间id
    private String lon ="";//经度
    private String lat ="";//纬度

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOrder_room_id() {
        return order_room_id;
    }

    public void setOrder_room_id(String order_room_id) {
        this.order_room_id = order_room_id;
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
}

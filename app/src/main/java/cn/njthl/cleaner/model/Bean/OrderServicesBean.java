package cn.njthl.cleaner.model.Bean;

public class OrderServicesBean {
    private String order_service_id ="";
    private String corp_room_id ="";
    private String corp_room_name ="";
    private String service_id ="";
    private String service_name ="";
    private String service_pic;

    public String getOrder_service_id() {
        return order_service_id;
    }

    public void setOrder_service_id(String order_service_id) {
        this.order_service_id = order_service_id;
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

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_pic() {
        return service_pic;
    }

    public void setService_pic(String service_pic) {
        this.service_pic = service_pic;
    }
}

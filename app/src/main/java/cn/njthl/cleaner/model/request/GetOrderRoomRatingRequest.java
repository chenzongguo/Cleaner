package cn.njthl.cleaner.model.request;

public class GetOrderRoomRatingRequest {
    private String type;
    private String user_rating_id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_rating_id() {
        return user_rating_id;
    }

    public void setUser_rating_id(String user_rating_id) {
        this.user_rating_id = user_rating_id;
    }
}

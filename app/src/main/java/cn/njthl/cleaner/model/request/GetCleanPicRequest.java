package cn.njthl.cleaner.model.request;

public class GetCleanPicRequest {
    private String type;//查询标识(1全部2商户3微信用户)
    private String pic_id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPic_id() {
        return pic_id;
    }

    public void setPic_id(String pic_id) {
        this.pic_id = pic_id;
    }
}

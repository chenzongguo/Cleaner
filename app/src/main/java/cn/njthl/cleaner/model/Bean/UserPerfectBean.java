package cn.njthl.cleaner.model.Bean;

public class UserPerfectBean {
    private String type;
    private String user_id;//用户id
    private String role_id;//权限id
    private String name;//姓名
    private String sex;//性别(男1女2)
    private String cert_no;//身份证号码
    private String contact_phone;//联系电话
    private String age;//年龄
//    private String wx_openid;//总价
//    private String head_portrait;//头像
    private String partner_name;
    private String idcard_face_pic;
    private String idcard_back_pic;
    private String live_face_pic;
    private String service_type;//服务类型
//    private String entry_time;//入职时间
//    private String is_auth;//是否认证

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCert_no() {
        return cert_no;
    }

    public void setCert_no(String cert_no) {
        this.cert_no = cert_no;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPartner_name() {
        return partner_name;
    }

    public void setPartner_name(String partner_name) {
        this.partner_name = partner_name;
    }

    public String getIdcard_face_pic() {
        return idcard_face_pic;
    }

    public void setIdcard_face_pic(String idcard_face_pic) {
        this.idcard_face_pic = idcard_face_pic;
    }

    public String getIdcard_back_pic() {
        return idcard_back_pic;
    }

    public void setIdcard_back_pic(String idcard_back_pic) {
        this.idcard_back_pic = idcard_back_pic;
    }

    public String getLive_face_pic() {
        return live_face_pic;
    }

    public void setLive_face_pic(String live_face_pic) {
        this.live_face_pic = live_face_pic;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }
}

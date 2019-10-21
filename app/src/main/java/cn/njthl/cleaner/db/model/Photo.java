package cn.njthl.cleaner.db.model;

import org.litepal.crud.LitePalSupport;

public class Photo extends LitePalSupport {
    String Photo_Code = "Photo_Code";  //图片编码
    byte[] Photo_Content;	//图片内容
    String Photo_InputTime = "Photo_InputTime";//图片入库时间(yyyyMMddHHmmss)
    String Photo_Type = "Photo_Type";//图片类型(照片来源)
    String Photo_Desc = "Photo_Desc";//图片说明
    String Photo_Uploaded = "Photo_Uploaded";//上传标记
    String Photo_Uploaded_DateTime = "Photo_Uploaded_DateTime";//上传时间

    public String getPhoto_Code() {
        return Photo_Code;
    }

    public void setPhoto_Code(String photo_Code) {
        Photo_Code = photo_Code;
    }

    public byte[] getPhoto_Content() {
        return Photo_Content;
    }

    public void setPhoto_Content(byte[] photo_Content) {
        Photo_Content = photo_Content;
    }

    public String getPhoto_InputTime() {
        return Photo_InputTime;
    }

    public void setPhoto_InputTime(String photo_InputTime) {
        Photo_InputTime = photo_InputTime;
    }

    public String getPhoto_Type() {
        return Photo_Type;
    }

    public void setPhoto_Type(String photo_Type) {
        Photo_Type = photo_Type;
    }

    public String getPhoto_Desc() {
        return Photo_Desc;
    }

    public void setPhoto_Desc(String photo_Desc) {
        Photo_Desc = photo_Desc;
    }

    public String getPhoto_Uploaded() {
        return Photo_Uploaded;
    }

    public void setPhoto_Uploaded(String photo_Uploaded) {
        Photo_Uploaded = photo_Uploaded;
    }

    public String getPhoto_Uploaded_DateTime() {
        return Photo_Uploaded_DateTime;
    }

    public void setPhoto_Uploaded_DateTime(String photo_Uploaded_DateTime) {
        Photo_Uploaded_DateTime = photo_Uploaded_DateTime;
    }
}

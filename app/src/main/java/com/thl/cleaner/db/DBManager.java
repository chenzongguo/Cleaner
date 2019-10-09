package com.thl.cleaner.db;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

import com.thl.cleaner.db.model.Customer;
import com.thl.cleaner.db.model.Photo;
import com.thl.cleaner.db.model.SysUser;
import com.thl.cleaner.db.model.UnlockBusiness;
import com.thl.cleaner.util.TimeUtils;

import org.litepal.LitePal;

import java.util.List;

public class DBManager {
    private static DBManager mInstance;

    public static DBManager getInstance() {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager();
                }
            }
        }
        return mInstance;
    }

    /*================== SysUser begin ==================*/

    public synchronized void saveOrUpdateSysUser(SysUser sysUser) {
        if (sysUser != null) {
            sysUser.saveOrUpdate("User_Number = ?", sysUser.getUser_Number());
        }
    }
    public synchronized void deleteSysUser(SysUser sysUser) {
        LitePal.deleteAll(SysUser.class, "User_Number = ?", sysUser.getUser_Number());
    }

    public synchronized SysUser getSysUserByUser_Number(String user_Number) {
        if (!TextUtils.isEmpty(user_Number)) {
            List<SysUser> sysUserlist = LitePal.where("User_Number = ?", user_Number).find(SysUser.class);
            if (sysUserlist != null && sysUserlist.size()>0)
                return sysUserlist.get(0);
        }
        return null;
    }

    public synchronized SysUser getSysUserByPwd(String nameStr,String pwdStr) {
        if (!TextUtils.isEmpty(nameStr)&&!TextUtils.isEmpty(pwdStr)) {
            List<SysUser> sysUserlist = LitePal.where("User_Id = ? and User_Pwd = ?", nameStr,pwdStr).find(SysUser.class);
            if (sysUserlist != null && sysUserlist.size()>0)
                return sysUserlist.get(0);
        }
        return null;
    }
    /*================== SysUser end ==================*/
    /*================== Customer begin ==================*/

    public synchronized  void saveCustomerInfo(Customer customer){
        if (customer != null) {
            customer.save();
        }
    }
    public synchronized void updateCustomerInfo(String code){
        if (TextUtils.isEmpty(code))
            return;
        ContentValues values = new ContentValues();
        values.put("Cus_UpLoaded", "1");
        values.put("Cus_Uploaded_DateTime", TimeUtils.getDateTime6());
        LitePal.updateAll(Customer.class, values, "Cus_Code = ?", code);
    }

    public synchronized void updateCustomerInfo(String code, Customer customer) {
        if(customer!=null&&!TextUtils.isEmpty(code))
            customer.updateAll("Cus_Code = ? ", code);
    }

    public synchronized List<Customer> getCustomerAllValue(String name
            , String cardnum, String phonenum, String area, String PPBS_110) {
//        ArrayList<Customer> depotList = new ArrayList<Customer>();
        String sql ="Cus_Finish ='1' ";
        if (name != null && !"".equals(name.trim())) {
            sql += " and Cus_Name = '"+name.trim()+"'";
        }
        if (cardnum != null && !"".equals(cardnum.trim())) {
            sql += " and Cus_Number  = '"+cardnum.trim()+"'";
        }
        if (phonenum != null && !"".equals(phonenum.trim())) {
            sql += " and Cus_Tel   = '"+phonenum.trim()+"'";
        }
        List<Customer> Customerlist = LitePal.where(sql).find(Customer.class);
        return Customerlist;
    }

    public synchronized  String queryCustomer(String cardnum) {
        if (TextUtils.isEmpty(cardnum))
            return null;
        List<Customer> customerlist = LitePal.where("Cus_Number = ?", cardnum).find(Customer.class);
        if (customerlist != null && customerlist.size()>0)
            return customerlist.get(0).getCus_Code();
        else
            return null;
    }

    /**
     * 获取未上传的客户信息
     * @return
     */
    public synchronized  List<Customer> getCustomerValue() {
        List<Customer> Customerlist = LitePal.where("Cus_UpLoaded = ?", "0").find(Customer.class);
        return Customerlist;
    }

    /*================== Customer end ==================*/

    /*================== Business begin ==================*/

    public synchronized  void saveBusinessInfo(UnlockBusiness lockBusiness){
        if (lockBusiness != null) {
            lockBusiness.save();
        }
    }

    /**
     * 根据客户信息查询开锁业务信息
     *
     */


    public synchronized  UnlockBusiness getBusinessInfo(String cus_Code) {
        if (TextUtils.isEmpty(cus_Code))
            return null;
        List<UnlockBusiness> businesslist = LitePal.where("Cus_Code = ?", cus_Code).find(UnlockBusiness.class);
        if (businesslist != null && businesslist.size()>0)
            return businesslist.get(0);
        else
            return null;
    }

    /**
     * 查询所有未上传开锁业务信息
     *
     */
    public synchronized List<UnlockBusiness> getAllBusinessInfo() {
        List<UnlockBusiness> businesslist = LitePal.where("PPBS_UpLoaded = ?", "0").find(UnlockBusiness.class);
        if (businesslist != null && businesslist.size()>0)
            return businesslist;
        else
            return null;
    }

    /**
     * 更新开锁业务信息上传标志位
     */
    public synchronized void updateBusinessInfo(String code){
        if (TextUtils.isEmpty(code))
            return;
        ContentValues values = new ContentValues();
        values.put("PPBS_UpLoaded", "1");
        values.put("PPBS_UpLoaded_DateTime", TimeUtils.getDateTime6());
        LitePal.updateAll(UnlockBusiness.class, values, "PPBS_Code = ?", code);
    }

    /*================== Business end ==================*/

    /*================== Photo begin ==================*/
    /** 存储照片信息
     *
     */
    public synchronized void savePhotoInfo(Photo photo) {
        if (photo != null) {
            photo.save();
        }
    }

    /**
     * 更新上传照片
     */
    public synchronized void updatePhotoInfo(String code){
        if (TextUtils.isEmpty(code))
            return;
        ContentValues values = new ContentValues();
        values.put("Photo_Uploaded", "1");
        values.put("Photo_Uploaded_DateTime", TimeUtils.getDateTime6());
        LitePal.updateAll(Photo.class, values, "Photo_Code = ?", code);
    }
    /**
     * 更新已经存在的客户照片
     */
    public synchronized void updatePhotoInfo(String code,Photo photo) {
        if(photo!=null&&!TextUtils.isEmpty(code))
            photo.updateAll("Photo_Code = ? ", code);
    }

    /**
     * 查询照片信息
     *
     */
    public synchronized static Bitmap getPhotoInfo(String Photo_Code) {
        Bitmap bitmap = null;
        if(TextUtils.isEmpty(Photo_Code))
            return bitmap;
        List<Photo> Photolist = LitePal.where("Photo_Code = ?", Photo_Code).find(Photo.class);
        if (Photolist != null && Photolist.size()>0){
            byte[] bytes = Photolist.get(0).getPhoto_Content();
            bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, null);
            return bitmap;
        } else
            return bitmap;
    }

    /**
     * 查询未上传的照片列表
     *
     * return List<PhotoBean>
     */
    public synchronized static List<Photo> GetNotUploadPhotoInfo() {
        List<Photo> photolist = LitePal.where("Photo_Uploaded = ?", "0").find(Photo.class);
        if (photolist != null && photolist.size()>0)
            return photolist;
        else
            return null;
    }
}

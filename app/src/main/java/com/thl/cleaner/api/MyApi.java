package com.thl.cleaner.api;

import com.thl.cleaner.model.response.BaseResponse;
import com.thl.cleaner.model.response.CheckUpdateResponse;
import com.thl.cleaner.model.response.GetOrderListResponse;
import com.thl.cleaner.model.response.GetOrderResponse;
import com.thl.cleaner.model.response.UserLoginResponse;
import com.thl.cleaner.model.response.cleaner.CleanerOrderListResponse;
import com.thl.cleaner.model.response.cleaner.CleanerOrderResponse;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @创建者 CSDN_LQR
 * @描述 server端api
 */

public interface MyApi {

//    public static final String BASE_URL = "http://218.94.111.86:8091/";
//    public static final String BASE_URL = "http://192.168.20.190:8080/";
    public static final String BASE_URL = "http://218.94.111.86:8091/";


    //检查手机是否被注册
//    @POST("user/check_phone_available")
//    Observable<CheckPhoneResponse> checkPhoneAvailable(@Body RequestBody body);

    //获取是否需要更新
    @POST("LockUpdate/checkUpdate")
    Observable<CheckUpdateResponse> checkUpdate(@Body RequestBody jsonString);

    //更新设备的状态（1已下载，2已更新）
    @POST("LockUpdate/changeState")
    Observable<CheckUpdateResponse> changeState(@Body RequestBody jsonString);

    //获取接口token
    @POST("hsp/tool/getToken.do")
    Observable<BaseResponse> getToken(@Body RequestBody jsonString);

    //获取短信验证码
    @POST("hsp/tool/sendCaptcha.do")
    Observable<BaseResponse> sendCaptcha(@Body RequestBody jsonString);
    //验证短信验证码
    @POST("hsp/tool/checkCaptcha.do")
    Observable<BaseResponse> checkCaptcha(@Body RequestBody jsonString);

    //用户注册
    @POST("hsp/user/userRegister.do")
    Observable<BaseResponse> userRegister(@Body RequestBody jsonString);

    //用户登录
    @POST("hsp/user/userLogin.do")
    Observable<UserLoginResponse> userLogin(@Body RequestBody jsonString);

    //token登录
    @POST("hsp/tool/checkUserToken.do")
    Observable<BaseResponse> checkUserToken(@Body RequestBody jsonString);

    //订单信息查询
    @POST("hsp/order/getOrderList.do")
    Observable<GetOrderListResponse> getOrderList(@Body RequestBody jsonString);

    //订单详情查询
    @POST("hsp/order/getOrder.do")
    Observable<GetOrderResponse> getOrder(@Body RequestBody jsonString);

    //商户接单
    @POST("hsp/order/parnterReceipt.do")
    Observable<BaseResponse> parnterReceipt(@Body RequestBody jsonString);

    //商户派单
    @POST("hsp/order/updateOrderRoomState.do")
    Observable<BaseResponse> updateOrderRoomState(@Body RequestBody jsonString);

    //保洁员订单查询
    @POST("hsp/cleaner/cleanerOrderList.do")
    Observable<CleanerOrderListResponse> cleanerOrderList(@Body RequestBody jsonString);

    //保洁员订单详情
    @POST("hsp/cleaner/cleanerOrder.do")
    Observable<CleanerOrderResponse> cleanerOrder(@Body RequestBody jsonString);

    //保洁员上门
    @POST("hsp/cleaner/cleanerDoor.do")
    Observable<BaseResponse> cleanerDoor(@Body RequestBody jsonString);

    //保洁员上门
    @POST("hsp/order/finishOrderRoom.do")
    Observable<BaseResponse> finishOrderRoom(@Body RequestBody jsonString);
}

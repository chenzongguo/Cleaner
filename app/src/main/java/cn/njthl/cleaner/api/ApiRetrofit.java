package cn.njthl.cleaner.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cn.njthl.cleaner.api.base.BaseApiRetrofit;
import cn.njthl.cleaner.model.request.BaseRequest;
import cn.njthl.cleaner.model.request.ChangeStateRequest;
import cn.njthl.cleaner.model.request.CheckCaptchaRequest;
import cn.njthl.cleaner.model.request.CheckUpdateRequest;
import cn.njthl.cleaner.model.request.GetCleanPicRequest;
import cn.njthl.cleaner.model.request.GetOrderListRequest;
import cn.njthl.cleaner.model.request.GetOrderRequest;
import cn.njthl.cleaner.model.request.GetTokenRequest;
import cn.njthl.cleaner.model.request.ParnterReceiptRequest;
import cn.njthl.cleaner.model.request.SendCaptchaRequest;
import cn.njthl.cleaner.model.request.UpdateOrderRoomStateRequest;
import cn.njthl.cleaner.model.request.UserLoginRequest;
import cn.njthl.cleaner.model.request.UserRegisterRequest;
import cn.njthl.cleaner.model.request.UserTokenRequest;
import cn.njthl.cleaner.model.request.cleaner.CleanerDoorRequest;
import cn.njthl.cleaner.model.request.cleaner.CleanerOrderListRequest;
import cn.njthl.cleaner.model.request.cleaner.CleanerOrderRequest;
import cn.njthl.cleaner.model.request.cleaner.FinishOrderRoomRequest;
import cn.njthl.cleaner.model.response.BaseResponse;
import cn.njthl.cleaner.model.response.CheckUpdateResponse;
import cn.njthl.cleaner.model.response.GetCleanPicResponse;
import cn.njthl.cleaner.model.response.GetOrderListResponse;
import cn.njthl.cleaner.model.response.GetOrderResponse;
import cn.njthl.cleaner.model.response.UserLoginResponse;
import cn.njthl.cleaner.model.response.cleaner.CleanerOrderListResponse;
import cn.njthl.cleaner.model.response.cleaner.CleanerOrderResponse;
import cn.njthl.cleaner.util.LogUtils;

import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * @创建者 CSDN_LQR
 * @描述 使用Retrofit对网络请求进行配置
 */
public class ApiRetrofit extends BaseApiRetrofit {

    public MyApi mApi;
    public static ApiRetrofit mInstance;

    private ApiRetrofit() {
        super();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //在构造方法中完成对Retrofit接口的初始化
        mApi = new Retrofit.Builder()
                .baseUrl(MyApi.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(MyApi.class);
    }

    public static ApiRetrofit getInstance() {
        if (mInstance == null) {
            synchronized (ApiRetrofit.class) {
                if (mInstance == null) {
                    mInstance = new ApiRetrofit();
                }
            }
        }
        return mInstance;
    }

    private RequestBody getRequestBody(Object obj) {
        String data = new Gson().toJson(obj);
        String route = new Gson().toJson(new BaseRequest("89CA7BFA98871245FF2B80F3167FB912",data));
        LogUtils.sf(route);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
//        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route);
        return body;
    }

    private RequestBody getUserTokenRequestBody(Object obj) {
        String data = new Gson().toJson(obj);
        String route = new Gson().toJson(new UserTokenRequest("89CA7BFA98871245FF2B80F3167FB912",data));
        LogUtils.sf(route);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
//        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route);
        return body;
    }




    //获取是否需要更新
    public Observable<CheckUpdateResponse> checkUpdate(String user_name, String id_number) {
        return mApi.checkUpdate(getRequestBody(new CheckUpdateRequest(user_name,id_number)));
    }

    //更改设备更新状态
    public Observable<CheckUpdateResponse> changeState(String imei, String update_status) {
        return mApi.changeState(getRequestBody(new ChangeStateRequest(imei,update_status)));
    }

    //获取token
    public Observable<BaseResponse> getToken(String appid) {
        return mApi.getToken(getRequestBody(new GetTokenRequest(appid)));
    }

    //获取验证码
    public Observable<BaseResponse> sendCaptcha( String phone) {
        return mApi.sendCaptcha(getRequestBody(new SendCaptchaRequest(phone)));
    }

    //验证验证码
    public Observable<BaseResponse> checkCaptcha( String phone, String captcha) {
        return mApi.checkCaptcha(getRequestBody(new CheckCaptchaRequest(phone,captcha)));
    }

    //用户注册
    public Observable<BaseResponse> userRegister( String phone, String pwd) {
        return mApi.userRegister(getRequestBody(new UserRegisterRequest(phone,pwd)));
    }

    //用户登录
    public Observable<UserLoginResponse> userLogin(UserLoginRequest userLoginRequest) {
        return mApi.userLogin(getRequestBody(userLoginRequest));
    }

    //用户token验证登录
    public Observable<BaseResponse> checkUserToken() {
        return mApi.checkUserToken(getUserTokenRequestBody(""));
    }


    //商户信息完善

    //订单信息查询
    public Observable<GetOrderListResponse> getOrderList(GetOrderListRequest getOrderListRequest) {
        return mApi.getOrderList(getUserTokenRequestBody(getOrderListRequest));
    }

    //订单详情信息查询
    public Observable<GetOrderResponse> getOrder(GetOrderRequest getOrderRequest) {
        return mApi.getOrder(getUserTokenRequestBody(getOrderRequest));
    }

    //商户接单
    public Observable<BaseResponse> parnterReceipt(ParnterReceiptRequest parnterReceiptRequest) {
        return mApi.parnterReceipt(getUserTokenRequestBody(parnterReceiptRequest));
    }
    //商户派单保洁员接单
    public Observable<BaseResponse> updateOrderRoomState(UpdateOrderRoomStateRequest updateOrderRoomStateRequest) {
        return mApi.updateOrderRoomState(getUserTokenRequestBody(updateOrderRoomStateRequest));
    }

    //
    public Observable<CleanerOrderListResponse> cleanerOrderList(CleanerOrderListRequest cleanerOrderListRequest) {
        return mApi.cleanerOrderList(getUserTokenRequestBody(cleanerOrderListRequest));
    }

    //
    public Observable<CleanerOrderResponse> cleanerOrder(CleanerOrderRequest cleanerOrderRequest) {
        return mApi.cleanerOrder(getUserTokenRequestBody(cleanerOrderRequest));
    }

    //
    public Observable<BaseResponse> cleanerDoor(CleanerDoorRequest cleanerDoorRequest) {
        return mApi.cleanerDoor(getUserTokenRequestBody(cleanerDoorRequest));
    }

    //
    public Observable<BaseResponse> finishOrderRoom(FinishOrderRoomRequest finishOrderRoomRequest) {
        return mApi.finishOrderRoom(getUserTokenRequestBody(finishOrderRoomRequest));
    }

    //商户接单
    public Observable<GetCleanPicResponse> getCleanPic(GetCleanPicRequest getCleanPicRequest) {
        return mApi.getCleanPic(getUserTokenRequestBody(getCleanPicRequest));
    }
}

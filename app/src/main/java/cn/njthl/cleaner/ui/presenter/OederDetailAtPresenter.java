package cn.njthl.cleaner.ui.presenter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import cn.njthl.cleaner.api.ApiRetrofit;
import cn.njthl.cleaner.model.Bean.OrderRoomBean;
import cn.njthl.cleaner.model.request.UpdateOrderRoomStateRequest;
import cn.njthl.cleaner.model.request.cleaner.CleanerDoorRequest;
import cn.njthl.cleaner.model.request.cleaner.CleanerOrderRequest;
import cn.njthl.cleaner.model.response.cleaner.CleanerOrderResponse;
import cn.njthl.cleaner.ui.activity.CompelteActivity;
import cn.njthl.cleaner.ui.activity.OrderCompleteActivity;
import cn.njthl.cleaner.ui.adapter.OrderRoomAdapter;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.IOrderDetailAtView;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class OederDetailAtPresenter extends BasePresenter<IOrderDetailAtView> {

    private OrderRoomAdapter orderRoomAdapter;
    private List<OrderRoomBean> orderRoomBeanList;
    private CleanerOrderResponse cleanerOrderResponse;
    private Boolean OrderAllocation = false;
    private int room_state;
    private String order_room_id;
    private LocationManager locationManager;
    private String provider;

    //    private String order_state;
    public OederDetailAtPresenter(BaseActivity context) {
        super(context);
    }

    public void getConversations() {
        loadData();

    }

    private void loadData() {
        order_room_id = mContext.getIntent().getStringExtra("order_room_id");
//        order_state = mContext.getIntent().getStringExtra("order_state");
//        if(order_state.equals("3")){
//            getView().getBtnParnterReceipt().setText("去派单");
//            OrderAllocation = true;
//        }
        CleanerOrderRequest cleanerOrderRequest = new CleanerOrderRequest();
        cleanerOrderRequest.setOrder_room_id(order_room_id);
        ApiRetrofit.getInstance().cleanerOrder(cleanerOrderRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cleanerOrderResponse -> {
                    String code = cleanerOrderResponse.getCode();
                    if ("000".equals(code)) {
                        this.cleanerOrderResponse = cleanerOrderResponse;
//                        orderRoomBeanList =  getOrderResponse.getData().getCorp_room_data();
//                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
//                        registerReceiver();
//                        setAdapter();
                        initView(cleanerOrderResponse);
                    } else {
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
//    private void setAdapter(){
//
//        if(orderRoomAdapter == null)
//            orderRoomAdapter = new OrderRoomAdapter(mContext,orderRoomBeanList);
////        orderRoomAdapter.setOnClick(this);
//        getView().getLvRoomInfo().setAdapter(orderRoomAdapter);
//        getView().getLvRoomInfo().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(mContext,"单个房间长按派单",Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//        getView().getLvRoomInfo().setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(mContext,"listview点击事件",Toast.LENGTH_SHORT).show();
//                mContext.jumpToActivityAndClearTask(OrderDetailActivity.class);
//            }
//        });
//    }

    private void initView(CleanerOrderResponse cleanerOrderResponse) {
        getView().getTvCorpName().setText(cleanerOrderResponse.getData().getCorp_name());
        getView().getTvAddress().setText(cleanerOrderResponse.getData().getCorp_addr());
        getView().getTvRoomName().setText(cleanerOrderResponse.getData().getCorp_room_name());
        getView().getTvRoomType().setText(cleanerOrderResponse.getData().getRoom_type_name());
//        getView().getTvCreateTime().setText(cleanerOrderResponse.getData().get);
        getView().getTvTime().setText(cleanerOrderResponse.getData().getDoor_time());
//        getView().getTvContacts().setText(cleanerOrderResponse.getData().getRoom_type_name());
//        getView().getTvContactPhone().setText(cleanerOrderResponse.getData().get);
//        getView().getTvBedNum().setText(cleanerOrderResponse.getData().getBed_num());
        getView().getTvOrderId().setText(cleanerOrderResponse.getData().getOrder_id());
//        getView().getTvRemark().setText(cleanerOrderResponse.getData().getRemark());
        if (cleanerOrderResponse.getData().getOrder_room_state().equals("2")) {
            getView().getBtnParnterReceipt().setText("确认接单");
            getView().getTvRoomState().setText("待确认");
            OrderAllocation = true;
            room_state = 2;
        }

        if (cleanerOrderResponse.getData().getOrder_room_state().equals("3")) {
            getView().getBtnParnterReceipt().setText("确认到店");
            getView().getTvRoomState().setText("待上门");
            OrderAllocation = true;
            room_state = 3;
        }
        if (cleanerOrderResponse.getData().getOrder_room_state().equals("4")) {
            getView().getBtnParnterReceipt().setText("完成订单");
            getView().getTvRoomState().setText("待打扫");
            OrderAllocation = true;
            room_state = 4;
        }
        if (cleanerOrderResponse.getData().getOrder_room_state().equals("5")) {
            getView().getRlyCompelte().setVisibility(View.VISIBLE);
            getView().getRlyNoCompelte().setVisibility(View.GONE);
            if("1".equals(cleanerOrderResponse.getData().getIs_rating()))
                getView().getBtnEvaluation().setVisibility(View.VISIBLE);
            getView().getBtnParnterReceipt().setText("已打扫");
            getView().getTvRoomState().setText("用户已确认");
            getView().getBtnParnterReceipt().setEnabled(false);
            OrderAllocation = true;
            room_state = 5;
        }
        if (cleanerOrderResponse.getData().getOrder_room_state().equals("7")) {
            getView().getRlyCompelte().setVisibility(View.VISIBLE);
            getView().getRlyNoCompelte().setVisibility(View.GONE);
            getView().getBtnParnterReceipt().setText("已打扫");
            getView().getTvRoomState().setText("已打扫");
            getView().getBtnParnterReceipt().setEnabled(false);
            OrderAllocation = true;
            room_state = 5;
        }
    }

    public void ParnterReceipt() {
        if (room_state == 2) {
            UpdateOrderRoomStateRequest updateOrderRoomStateRequest = new UpdateOrderRoomStateRequest();
            updateOrderRoomStateRequest.setType("2");
            updateOrderRoomStateRequest.setUser_id("5");
            updateOrderRoomStateRequest.setOrder_id(cleanerOrderResponse.getData().getOrder_id());
            updateOrderRoomStateRequest.setOrder_room_id(cleanerOrderResponse.getData().getOrder_room_id());
            ApiRetrofit.getInstance().updateOrderRoomState(updateOrderRoomStateRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(getBaseResponse -> {
                        String code = getBaseResponse.getCode();
                        if ("000".equals(code)) {
                            room_state = 3;
                            getView().getBtnParnterReceipt().setText("确认到店");
//                            getView().getBtnParnterReceipt().setEnabled(false);
                            getView().getTvRoomState().setText("待上门");
                            Toast.makeText(mContext, "订单确认成功", Toast.LENGTH_SHORT).show();
                        } else {
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(mContext, getBaseResponse.getErrMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        } else if (room_state == 3) {
            CleanerDoorRequest cleanerDoorRequest = new CleanerDoorRequest();
            cleanerDoorRequest.setLat("31.97774");
            cleanerDoorRequest.setLon("118.73391");

//            cleanerDoorRequest.setLat("32.055717");
//            cleanerDoorRequest.setLon("118.74584");
//            if (!getLocation(cleanerDoorRequest)) {
//                return;
//            }
            cleanerDoorRequest.setUser_id("5");
            cleanerDoorRequest.setOrder_room_id(cleanerOrderResponse.getData().getOrder_room_id());
            ApiRetrofit.getInstance().cleanerDoor(cleanerDoorRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(getBaseResponse -> {
                        String code = getBaseResponse.getCode();
                        if ("000".equals(code)) {
                            room_state = 4;
                            getView().getBtnParnterReceipt().setText("完成订单");
//                            getView().getBtnParnterReceipt().setEnabled(false);
                            Toast.makeText(mContext, "已成功到店", Toast.LENGTH_SHORT).show();
                        } else {
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(mContext, getBaseResponse.getErrMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

        } else if (room_state == 4) {
            Intent intent = new Intent(mContext, OrderCompleteActivity.class);
            intent.putExtra("order_room_id", cleanerOrderResponse.getData().getOrder_room_id());
            intent.putExtra("order_id", cleanerOrderResponse.getData().getOrder_id());
//                intent.putExtra("order_state",cleanerOrderBeanList.get(position).getOrder_room_state());
            mContext.jumpToActivity(intent);
        }

    }

    public void compelte() {
        if (cleanerOrderResponse.getData().getIs_clean().equals("1")) {
            Intent intent = new Intent(mContext, CompelteActivity.class);
            intent.putExtra("pic_id", cleanerOrderResponse.getData().getPic_id());
            mContext.startActivity(intent);
        } else {
            Toast.makeText(mContext, "房间正在打扫中 ", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 获取具体位置的经纬度
     */
    private boolean getLocation(CleanerDoorRequest cleanerDoorRequest) {
        // 获取位置管理服务
        LocationManager locationManager;
        String serviceName = Context.LOCATION_SERVICE;
        locationManager = (LocationManager) mContext.getSystemService(serviceName);
        // 查找到服务信息
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE); // 高精度
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW); // 低功耗
        String provider = locationManager.getBestProvider(criteria, true); // 获取GPS信息
        /**这段代码不需要深究，是locationManager.getLastKnownLocation(provider)自动生成的，不加会出错**/
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return false;
        }
        Location location = locationManager.getLastKnownLocation(provider); // 通过GPS获取位置
        if (location != null) {
            cleanerDoorRequest.setLat(""+location.getLatitude());
            cleanerDoorRequest.setLon(""+location.getLongitude());
            return true;
        } else {
            Toast.makeText(mContext, "无法获取位置信息", Toast.LENGTH_SHORT).show();
            return false;
        }
//        updateLocation(location);
    }

    /**
     * 获取到当前位置的经纬度
     * @param location
     */
    private void updateLocation(Location location) {
        if (location != null) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
        } else {
            Toast.makeText(mContext, "无法获取位置信息", Toast.LENGTH_SHORT).show();
        }
    }

//    private boolean getLocation(CleanerDoorRequest cleanerDoorRequest) {
//        locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
//        // 获取所有可用的位置提供器
//        List<String> providerList = locationManager.getProviders(true);
//        if (providerList.contains(LocationManager.GPS_PROVIDER)) {
//            provider = LocationManager.GPS_PROVIDER;
//        } else if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
//            provider = LocationManager.NETWORK_PROVIDER;
//        } else {
//            // 当没有可用的位置提供器时，弹出Toast提示用户
//            Toast.makeText(mContext, "请打开GPS定位开关", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
////        if (mContext.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && mContext.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
////            // TODO: Consider calling
////            //    Activity#requestPermissions
////            // here to request the missing permissions, and then overriding
////            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
////            //                                          int[] grantResults)
////            // to handle the case where the user grants the permission. See the documentation
////            // for Activity#requestPermissions for more details.
////            return false;
////        }
//
//        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//        if (location != null) {
//            // 显示当前设备的位置信息
////            showLocation(location);
//            cleanerDoorRequest.setLat(""+location.getLatitude());
//            cleanerDoorRequest.setLon(""+location.getLongitude());
//            return true;
//        }
//        Toast.makeText(mContext, "无法获取位置信息", Toast.LENGTH_SHORT).show();
//        return false;
//    }
}

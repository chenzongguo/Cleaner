package com.thl.cleaner.ui.presenter;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.thl.cleaner.api.ApiRetrofit;
import com.thl.cleaner.model.Bean.OrderRoomBean;
import com.thl.cleaner.model.request.GetOrderRequest;
import com.thl.cleaner.model.request.ParnterReceiptRequest;
import com.thl.cleaner.model.request.UpdateOrderRoomStateRequest;
import com.thl.cleaner.model.request.cleaner.CleanerDoorRequest;
import com.thl.cleaner.model.request.cleaner.CleanerOrderRequest;
import com.thl.cleaner.model.response.GetOrderResponse;
import com.thl.cleaner.model.response.cleaner.CleanerOrderResponse;
import com.thl.cleaner.ui.activity.OrderCompleteActivity;
import com.thl.cleaner.ui.activity.OrderDetailActivity;
import com.thl.cleaner.ui.adapter.OrderRoomAdapter;
import com.thl.cleaner.ui.base.BaseActivity;
import com.thl.cleaner.ui.base.BasePresenter;
import com.thl.cleaner.ui.view.IOrderDetailAtView;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OederDetailAtPresenter extends BasePresenter<IOrderDetailAtView> {

    private OrderRoomAdapter orderRoomAdapter;
    private List<OrderRoomBean> orderRoomBeanList;
    private CleanerOrderResponse cleanerOrderResponse;
    private Boolean OrderAllocation = false;
    private int room_state;
    private String order_room_id;
//    private String order_state;
    public OederDetailAtPresenter(BaseActivity context) {
        super(context);
    }

    public void getConversations() {
        loadData();

    }
    private void  loadData(){
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
                    if("000".equals(code)){
                        this.cleanerOrderResponse = cleanerOrderResponse;
//                        orderRoomBeanList =  getOrderResponse.getData().getCorp_room_data();
//                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
//                        registerReceiver();
//                        setAdapter();
                        initView(cleanerOrderResponse);
                    }else{
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

    private void initView(CleanerOrderResponse cleanerOrderResponse){
        getView().getTvCorpName().setText(cleanerOrderResponse.getData().getCorp_name());
        getView().getTvAddress().setText(cleanerOrderResponse.getData().getCorp_addr());
        getView().getTvRoomName().setText(cleanerOrderResponse.getData().getCorp_room_name());
        getView().getTvRoomType().setText(cleanerOrderResponse.getData().getRoom_type_name());
        getView().getTvBedNum().setText(cleanerOrderResponse.getData().getBed_num());
        getView().getTvOrderId().setText(cleanerOrderResponse.getData().getOrder_id());
        getView().getTvRemark().setText(cleanerOrderResponse.getData().getRemark());
        if(cleanerOrderResponse.getData().getOrder_room_state().equals("2")){
            getView().getBtnParnterReceipt().setText("确认接单");
            OrderAllocation = true;
            room_state = 2;
        }

        if(cleanerOrderResponse.getData().getOrder_room_state().equals("3")){
            getView().getBtnParnterReceipt().setText("确认到店");
            OrderAllocation = true;
            room_state = 3;
        }
        if(cleanerOrderResponse.getData().getOrder_room_state().equals("4")){
            getView().getBtnParnterReceipt().setText("完成订单");
            OrderAllocation = true;
            room_state = 4;
        }
        if(cleanerOrderResponse.getData().getOrder_room_state().equals("5")){
            getView().getBtnParnterReceipt().setText("已完成");
            getView().getBtnParnterReceipt().setEnabled(false);
            OrderAllocation = true;
            room_state = 5;
        }
    }

    public void ParnterReceipt(){
        if (room_state == 2){
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
                        if("000".equals(code)){
                            room_state = 3;
                            getView().getBtnParnterReceipt().setText("确认到店");
//                            getView().getBtnParnterReceipt().setEnabled(false);
                            Toast.makeText(mContext, "订单确认成功", Toast.LENGTH_SHORT).show();
                        }else{
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(mContext, getBaseResponse.getErrMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }else if(room_state == 3){
            CleanerDoorRequest cleanerDoorRequest = new CleanerDoorRequest();
            cleanerDoorRequest.setLat("31.97832");
            cleanerDoorRequest.setLon("118.73433");
            cleanerDoorRequest.setUser_id("5");
            cleanerDoorRequest.setOrder_room_id(cleanerOrderResponse.getData().getOrder_room_id());
            ApiRetrofit.getInstance().cleanerDoor(cleanerDoorRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(getBaseResponse -> {
                        String code = getBaseResponse.getCode();
                        if("000".equals(code)){
                            room_state = 4;
                            getView().getBtnParnterReceipt().setText("完成订单");
//                            getView().getBtnParnterReceipt().setEnabled(false);
                            Toast.makeText(mContext, "已成功到店", Toast.LENGTH_SHORT).show();
                        }else{
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(mContext, getBaseResponse.getErrMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

        } else if(room_state == 4){
            Intent intent = new Intent(mContext, OrderCompleteActivity.class);
            intent.putExtra("order_room_id",cleanerOrderResponse.getData().getOrder_room_id());
            intent.putExtra("order_id",cleanerOrderResponse.getData().getOrder_id());
//                intent.putExtra("order_state",cleanerOrderBeanList.get(position).getOrder_room_state());
            mContext.jumpToActivity(intent);
        }

    }
}

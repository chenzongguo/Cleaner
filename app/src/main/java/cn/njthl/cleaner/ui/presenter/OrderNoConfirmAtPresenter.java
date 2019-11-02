package cn.njthl.cleaner.ui.presenter;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import cn.njthl.cleaner.api.ApiRetrofit;
import cn.njthl.cleaner.app.AppConst;
import cn.njthl.cleaner.app.MyApp;
import cn.njthl.cleaner.model.Bean.CleanerOrderBean;
import cn.njthl.cleaner.model.request.cleaner.CleanerOrderListRequest;
import cn.njthl.cleaner.ui.activity.OrderDetailActivity;
import cn.njthl.cleaner.ui.adapter.OrderReceiveAdapter;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.IOrderNoConfirmAtView;

import java.util.List;

import cn.njthl.cleaner.util.SPUtils;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OrderNoConfirmAtPresenter extends BasePresenter<IOrderNoConfirmAtView> implements OrderReceiveAdapter.OnListenerClick{

//    private OrderReceiveAdapter orderReceiveAdapter;
//    private List<CleanerOrderBean> orderBeanList;
    private OrderReceiveAdapter orderReceiveAdapter;
    private List<CleanerOrderBean> cleanerOrderBeanList;

    public OrderNoConfirmAtPresenter(BaseActivity context) {
        super(context);
    }
    public void getConversations() {
        loadData();
    }
    private void  loadData(){
        String order_room_state = mContext.getIntent().getStringExtra("order_room_state");
        CleanerOrderListRequest cleanerOrderListRequest = new CleanerOrderListRequest();
        cleanerOrderListRequest.setUser_id(SPUtils.getInstance(MyApp.getContext()).getString("USER_ID",""));
        cleanerOrderListRequest.setSelect_number("10");
        cleanerOrderListRequest.setStart_number("0");
        cleanerOrderListRequest.setOrder_room_state(order_room_state);
        ApiRetrofit.getInstance().cleanerOrderList(cleanerOrderListRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getOrderListResponse -> {
                    String code = getOrderListResponse.getCode();
                    if("000".equals(code)){
                        cleanerOrderBeanList =  getOrderListResponse.getData().getPaging_data();
//                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
//                        registerReceiver();
                        if(cleanerOrderBeanList!=null && cleanerOrderBeanList.size()>0){
                            setAdapter();
                            getView().getImaNoOrder().setVisibility(View.GONE);
                        }else{
                            getView().getImaNoOrder().setVisibility(View.VISIBLE);
                        }


                    }else{
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void setAdapter(){

        if(orderReceiveAdapter == null)
            orderReceiveAdapter = new OrderReceiveAdapter(mContext,cleanerOrderBeanList);
        orderReceiveAdapter.setOnClick(this);
        getView().getLvOrderNoConfirm().setAdapter(orderReceiveAdapter);
        getView().getLvOrderNoConfirm().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext,"长按点击事件",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        getView().getLvOrderNoConfirm().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext,"listview点击事件",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, OrderDetailActivity.class);
                intent.putExtra("order_room_id",cleanerOrderBeanList.get(position).getOrder_room_id());
//                intent.putExtra("order_state",cleanerOrderBeanList.get(position).getOrder_room_state());
                mContext.jumpToActivity(intent);
//                mContext.jumpToActivityAndClearTop(OrderDetailActivity.class);
            }
        });
    }

    @Override
    public void OrderReceive() {

    }

//    @Override
//    public void OrderReceive() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//        builder.setMessage("这是接单按钮?");
//        builder.setTitle("提示");
//        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//            }
//        });
//
//        //添加AlertDialog.Builder对象的setNegativeButton()方法
//        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        builder.create().show();
//    }
}

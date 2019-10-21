package cn.njthl.cleaner.ui.presenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import cn.njthl.cleaner.api.ApiRetrofit;
import cn.njthl.cleaner.model.Bean.CleanerOrderBean;
import cn.njthl.cleaner.model.request.cleaner.CleanerOrderListRequest;
import cn.njthl.cleaner.ui.activity.OrderDetailActivity;
import cn.njthl.cleaner.ui.adapter.OrderAllocationAdapter;
import cn.njthl.cleaner.ui.adapter.OrderReceiveAdapter;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.OrderAllocationFgView;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OrderAllocationFgPresenter extends BasePresenter<OrderAllocationFgView> implements OrderReceiveAdapter.OnListenerClick{
    private OrderAllocationAdapter orderAllocationAdapter;
    private List<CleanerOrderBean> cleanerOrderBeanList;
    public OrderAllocationFgPresenter(BaseActivity context) {
        super(context);
    }


    public void getConversations() {
        loadData();
    }
    private void  loadData(){
        CleanerOrderListRequest cleanerOrderListRequest = new CleanerOrderListRequest();
        cleanerOrderListRequest.setUser_id("5");
        cleanerOrderListRequest.setSelect_number("10");
        cleanerOrderListRequest.setStart_number("0");
//        cleanerOrderListRequest.setOrder_room_state("2");
        cleanerOrderListRequest.setIs_working("0");
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

        if(orderAllocationAdapter == null)
            orderAllocationAdapter = new OrderAllocationAdapter(mContext,cleanerOrderBeanList);
        orderAllocationAdapter.setOnClick(this);
        getView().getLvOrderAllocation().setAdapter(orderAllocationAdapter);
        getView().getLvOrderAllocation().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext,"长按派单",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        getView().getLvOrderAllocation().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext,"listview点击事件",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, OrderDetailActivity.class);
                intent.putExtra("order_room_id",cleanerOrderBeanList.get(position).getOrder_room_id());
//                intent.putExtra("order_state",cleanerOrderBeanList.get(position).getOrder_room_state());
                mContext.jumpToActivity(intent);
            }
        });
    }

    @Override
    public void OrderReceive() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("这是接单按钮?");
        builder.setTitle("提示");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        //添加AlertDialog.Builder对象的setNegativeButton()方法
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }
}
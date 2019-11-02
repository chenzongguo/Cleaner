package cn.njthl.cleaner.ui.presenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import cn.njthl.cleaner.R;
import cn.njthl.cleaner.api.ApiRetrofit;
import cn.njthl.cleaner.app.AppConst;
import cn.njthl.cleaner.app.MyApp;
import cn.njthl.cleaner.model.Bean.CleanerOrderBean;
import cn.njthl.cleaner.model.request.cleaner.CleanerOrderListRequest;
import cn.njthl.cleaner.ui.activity.OrderDetailActivity;
import cn.njthl.cleaner.ui.adapter.OrderReceiveAdapter;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.HomePageFgView;

import java.util.List;

import cn.njthl.cleaner.util.LogUtils;
import cn.njthl.cleaner.util.SPUtils;
import cn.njthl.cleaner.util.UIUtils;
import cn.njthl.cleaner.widget.MyListView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class HomePageFgPresenter extends BasePresenter<HomePageFgView> implements OrderReceiveAdapter.OnListenerClick {
    private OrderReceiveAdapter orderReceiveAdapter;
    private List<CleanerOrderBean> cleanerOrderBeanList;
    private LayoutInflater inflater;

    // ListView头部下拉刷新的布局
    private LinearLayout LlyListNull;
    public HomePageFgPresenter(BaseActivity context) {
        super(context);
    }

    public void getConversations() {
        loadData();

    }
    private void  loadData(){

        if(LlyListNull==null){
            inflater = LayoutInflater.from(mContext);
            LlyListNull = (LinearLayout) inflater.inflate(R.layout.include_list_null, null);
            getView().getLvOrderReceive().addFooterView(LlyListNull);
        }

        CleanerOrderListRequest cleanerOrderListRequest = new CleanerOrderListRequest();
        cleanerOrderListRequest.setUser_id(SPUtils.getInstance(MyApp.getContext()).getString("USER_ID",""));
        cleanerOrderListRequest.setSelect_number("10");
        cleanerOrderListRequest.setStart_number("0");
        cleanerOrderListRequest.setOrder_room_state("2");
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
                            LlyListNull.setVisibility(View.GONE);
                        }else{
                            setAdapter();
                            LlyListNull.setVisibility(View.VISIBLE);
                        }


                    }else{
//                        Toast.makeText(getContext(), getTokenResponse.getStatue(), Toast.LENGTH_SHORT).show();
                    }
                },HomePageFgPresenter.this::loginError);
    }
    private void setAdapter(){

        if(orderReceiveAdapter == null)
        orderReceiveAdapter = new OrderReceiveAdapter(mContext,cleanerOrderBeanList);
        orderReceiveAdapter.setOrderList(cleanerOrderBeanList);
        orderReceiveAdapter.setOnClick(this);
        getView().getLvOrderReceive().setAdapter(orderReceiveAdapter);
        getView().getLvOrderReceive().setonRefreshListener(new MyListView.OnRefreshListener() {

            @Override
            public void onRefresh() {
//                new AsyncTask<Void, Void, Void>() {
//                    protected Void doInBackground(Void... params) {
//                        try {
//                            Thread.sleep(1000);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        return null;
//                    }
//
//                    @Override
//                    protected void onPostExecute(Void result) {
//                        orderReceiveAdapter.notifyDataSetChanged();
//                        getView().getLvOrderReceive().onRefreshComplete();
//                    }
//                }.execute(null, null, null);

                CleanerOrderListRequest cleanerOrderListRequest = new CleanerOrderListRequest();
                cleanerOrderListRequest.setUser_id(SPUtils.getInstance(MyApp.getContext()).getString("USER_ID",""));
                cleanerOrderListRequest.setSelect_number("10");
                cleanerOrderListRequest.setStart_number("0");
                cleanerOrderListRequest.setOrder_room_state("2");
                ApiRetrofit.getInstance().cleanerOrderList(cleanerOrderListRequest)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(getOrderListResponse -> {
                            String code = getOrderListResponse.getCode();
                            if("000".equals(code)){
                                cleanerOrderBeanList =  getOrderListResponse.getData().getPaging_data();
                                orderReceiveAdapter.setOrderList(cleanerOrderBeanList);
//                        showUpdateDialog(checkUpdateResponse.getData().getDownload_address());
//                        registerReceiver();
//                                if(cleanerOrderBeanList!=null && cleanerOrderBeanList.size()>0){
//                                    setAdapter();
//                                    getView().getImaNoOrder().setVisibility(View.GONE);
//                                }else{
//                                    getView().getImaNoOrder().setVisibility(View.VISIBLE);
//                                }
                                if(cleanerOrderBeanList!=null && cleanerOrderBeanList.size()>0){
                                    LlyListNull.setVisibility(View.GONE);
                                }else{
                                    LlyListNull.setVisibility(View.VISIBLE);
                                }
                                orderReceiveAdapter.notifyDataSetChanged();
                                getView().getLvOrderReceive().onRefreshComplete();

                            }else{
                                getView().getLvOrderReceive().onRefreshComplete();
                        Toast.makeText(mContext, getOrderListResponse.getErrMessage(), Toast.LENGTH_SHORT).show();
                            }
                        },HomePageFgPresenter.this::loginError);

            }
        });
        getView().getLvOrderReceive().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(cleanerOrderBeanList.size() == 0)
                    return;
                if (position>0)
                    position = position - 1;
                Intent intent = new Intent(mContext, OrderDetailActivity.class);
                intent.putExtra("order_room_id",cleanerOrderBeanList.get(position).getOrder_room_id());
//                intent.putExtra("order_state",cleanerOrderBeanList.get(position).getOrder_room_state());
                mContext.jumpToActivity(intent);
//                mContext.jumpToActivityAndClearTop(OrderDetailActivity.class);
            }
        });
        if (orderReceiveAdapter != null)
            orderReceiveAdapter.notifyDataSetChanged();
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

    private void loginError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
    }
}

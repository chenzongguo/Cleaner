package cn.njthl.cleaner.ui.presenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import cn.njthl.cleaner.R;
import cn.njthl.cleaner.api.ApiRetrofit;
import cn.njthl.cleaner.app.AppConst;
import cn.njthl.cleaner.app.MyApp;
import cn.njthl.cleaner.model.Bean.CleanerOrderBean;
import cn.njthl.cleaner.model.Bean.OrderBean;
import cn.njthl.cleaner.model.request.GetOrderListRequest;
import cn.njthl.cleaner.model.request.cleaner.CleanerOrderListRequest;
import cn.njthl.cleaner.ui.activity.OrderDetailActivity;
import cn.njthl.cleaner.ui.adapter.OrderAllocationAdapter;
import cn.njthl.cleaner.ui.base.BaseActivity;
import cn.njthl.cleaner.ui.base.BasePresenter;
import cn.njthl.cleaner.ui.view.NewOrderManageFgView;
import cn.njthl.cleaner.util.ButtonUtils;
import cn.njthl.cleaner.util.LogUtils;
import cn.njthl.cleaner.util.SPUtils;
import cn.njthl.cleaner.util.UIUtils;
import cn.njthl.cleaner.widget.MyListView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewOrderManageFgPresenter extends BasePresenter<NewOrderManageFgView> {
    private OrderAllocationAdapter orderAllocationAdapter;
    private List<CleanerOrderBean> cleanerOrderBeanList;
    private LayoutInflater inflater;

    private LinearLayout LlyListNull;
    private String order_room_state = "3";
    public NewOrderManageFgPresenter(BaseActivity context) {
        super(context);
    }

    public void getConversations() {
        loadData();

    }
    public void tableClick(String order_room_state){
        this.order_room_state = order_room_state;
        getView().getTvNoArriveCorp().setTextColor(mContext.getResources().getColor(R.color.black));
        getView().getTvArriveCorp().setTextColor(mContext.getResources().getColor(R.color.black));
        getView().getTvCleanComplete().setTextColor(mContext.getResources().getColor(R.color.black));
        getView().getTvOrderComplete().setTextColor(mContext.getResources().getColor(R.color.black));
        switch (order_room_state){
            case "3":
                getView().getTvNoArriveCorp().setTextColor(mContext.getResources().getColor(R.color.assist_green));
                break;
            case "4":
                getView().getTvArriveCorp().setTextColor(mContext.getResources().getColor(R.color.assist_green));
                break;
            case "5":
                getView().getTvCleanComplete().setTextColor(mContext.getResources().getColor(R.color.assist_green));
                break;
            case "7":
                getView().getTvOrderComplete().setTextColor(mContext.getResources().getColor(R.color.assist_green));
                break;
        }
        loadData();
    }
    private void  loadData(){
        if(LlyListNull==null){
            inflater = LayoutInflater.from(mContext);
            LlyListNull = (LinearLayout) inflater.inflate(R.layout.include_list_null, null);
            getView().getLvOrder().addFooterView(LlyListNull);
        }
        CleanerOrderListRequest cleanerOrderListRequest = new CleanerOrderListRequest();
        cleanerOrderListRequest.setUser_id(SPUtils.getInstance(MyApp.getContext()).getString("USER_ID",""));
        cleanerOrderListRequest.setSelect_number("10");
        cleanerOrderListRequest.setStart_number("0");
        if(order_room_state.equals("5"))
            cleanerOrderListRequest.setIs_complete("0");
        else
            cleanerOrderListRequest.setOrder_room_state(order_room_state);
//        cleanerOrderListRequest.setIs_working("0");
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
                },NewOrderManageFgPresenter.this::loginError);
    }
    private void setAdapter(){

        if(orderAllocationAdapter == null)
            orderAllocationAdapter = new OrderAllocationAdapter(mContext,cleanerOrderBeanList);
        orderAllocationAdapter.setOrderList(cleanerOrderBeanList);
        getView().getLvOrder().setAdapter(orderAllocationAdapter);
        getView().getLvOrder().setonRefreshListener(new MyListView.OnRefreshListener() {

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
                if(order_room_state.equals("5"))
                    cleanerOrderListRequest.setIs_complete("0");
                else
                    cleanerOrderListRequest.setOrder_room_state(order_room_state);
                ApiRetrofit.getInstance().cleanerOrderList(cleanerOrderListRequest)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(getOrderListResponse -> {
                            String code = getOrderListResponse.getCode();
                            if("000".equals(code)){
                                cleanerOrderBeanList =  getOrderListResponse.getData().getPaging_data();
                                orderAllocationAdapter.setOrderList(cleanerOrderBeanList);
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
                                orderAllocationAdapter.notifyDataSetChanged();
                                getView().getLvOrder().onRefreshComplete();

                            }else{
                                getView().getLvOrder().onRefreshComplete();
                                Toast.makeText(mContext, getOrderListResponse.getErrMessage(), Toast.LENGTH_SHORT).show();
                            }
                        },NewOrderManageFgPresenter.this::loginError);

            }
        });
        getView().getLvOrder().setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
            }
        });
        if (orderAllocationAdapter != null)
            orderAllocationAdapter.notifyDataSetChanged();
    }

    private void loginError(Throwable throwable) {
        LogUtils.e(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
    }

}

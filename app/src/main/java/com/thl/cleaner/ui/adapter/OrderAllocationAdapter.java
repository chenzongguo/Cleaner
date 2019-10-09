package com.thl.cleaner.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.thl.cleaner.R;
import com.thl.cleaner.model.Bean.CleanerOrderBean;
import com.thl.cleaner.model.Bean.OrderBean;

import java.util.List;

public class OrderAllocationAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private OrderReceiveAdapter.OnListenerClick onClick;
    private List<CleanerOrderBean> cleanerOrderBeanList;

    public void setOnClick(OrderReceiveAdapter.OnListenerClick onClick) {
        this.onClick = onClick;
    }

    public OrderAllocationAdapter(Context context, List<CleanerOrderBean> orderBeanlist) {
        // TODO Auto-generated constructor stub
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.cleanerOrderBeanList = orderBeanlist;
    }
    @Override
    public int getCount() {
        if(cleanerOrderBeanList!=null)
            return cleanerOrderBeanList.size();
        else
            return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OrderAllocationAdapter.ViewHolder holder;
        if(convertView == null){
            holder = new OrderAllocationAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.item_order, null);
            holder.tvTime = (TextView) convertView.findViewById(R.id.tvTime);
            holder.tvAddress = (TextView) convertView.findViewById(R.id.tvAddress);
            holder.tvPaymentPrice = (TextView) convertView.findViewById(R.id.tvPaymentPrice);
            holder.tvCorpName = (TextView) convertView.findViewById(R.id.tvCorpName);
            holder.btn_receiveOrder = convertView.findViewById(R.id.btn_receive_order);
            convertView.setTag(holder);
        }else{
            holder = (OrderAllocationAdapter.ViewHolder) convertView.getTag();
        }
        holder.btn_receiveOrder.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                onClick.OrderReceive();
            }
        });
        holder.tvTime.setText(cleanerOrderBeanList.get(position).getDoor_time());
        holder.tvAddress.setText(cleanerOrderBeanList.get(position).getCorp_addr());
        holder.tvPaymentPrice.setText(cleanerOrderBeanList.get(position).getCorp_room_name());
        holder.tvCorpName.setText(cleanerOrderBeanList.get(position).getCorp_name());
        if(cleanerOrderBeanList.get(position).getOrder_room_state().equals("3"))
            holder.btn_receiveOrder.setText("到店");

        if(cleanerOrderBeanList.get(position).getOrder_room_state().equals("4"))
            holder.btn_receiveOrder.setText("完成");
        return convertView;
    }
    class ViewHolder{
        TextView tvTime,tvAddress,tvPaymentPrice,tvCorpName;
        Button btn_receiveOrder;
    }

    public interface OnListenerClick{
        void OrderReceive();
    }
    View tv_time;
    }


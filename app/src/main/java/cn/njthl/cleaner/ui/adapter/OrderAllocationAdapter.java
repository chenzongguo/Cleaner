package cn.njthl.cleaner.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import cn.njthl.cleaner.R;
import cn.njthl.cleaner.model.Bean.CleanerOrderBean;

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
    public void setOrderList(List<CleanerOrderBean> orderBeanlist){
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
            holder.tvRoomName = convertView.findViewById(R.id.tvRoomName);
            holder.tvRoomType = (TextView) convertView.findViewById(R.id.tvRoomType);
            convertView.setTag(holder);
        }else{
            holder = (OrderAllocationAdapter.ViewHolder) convertView.getTag();
        }
//        holder.btn_receiveOrder.setOnClickListener(new android.view.View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                onClick.OrderReceive();
//            }
//        });
        holder.tvTime.setText(cleanerOrderBeanList.get(position).getDoor_time());
        holder.tvAddress.setText(cleanerOrderBeanList.get(position).getCorp_addr());
        holder.tvRoomName.setText(cleanerOrderBeanList.get(position).getCorp_room_name());
        holder.tvCorpName.setText(cleanerOrderBeanList.get(position).getCorp_name());
        holder.tvRoomType.setText(cleanerOrderBeanList.get(position).getRoom_type_name());
        if(cleanerOrderBeanList.get(position).getOrder_room_state().equals("3"))
            holder.tvPaymentPrice.setText("待上门");

        if(cleanerOrderBeanList.get(position).getOrder_room_state().equals("4"))
            holder.tvPaymentPrice.setText("待完成");
        return convertView;
    }
    class ViewHolder{
        TextView tvTime,tvAddress,tvPaymentPrice,tvCorpName,tvRoomName,tvRoomType;
//        Button btn_receiveOrder;
    }

    public interface OnListenerClick{
        void OrderReceive();
    }
    View tv_time;
    }


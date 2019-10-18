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


public class OrderReceiveAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private OnListenerClick onClick;
    private List<CleanerOrderBean> cleanerOrderBeanList;

    public void setOnClick(OnListenerClick onClick) {
        this.onClick = onClick;
    }

    public OrderReceiveAdapter(Context context, List<CleanerOrderBean> orderBeanlist) {
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
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_order, null);
            holder.tvRoomName = (TextView) convertView.findViewById(R.id.tvRoomName);
            holder.tvTime = (TextView) convertView.findViewById(R.id.tvTime);
            holder.tvAddress = (TextView) convertView.findViewById(R.id.tvAddress);
            holder.tvPaymentPrice = (TextView) convertView.findViewById(R.id.tvPaymentPrice);
            holder.tvCorpName = (TextView) convertView.findViewById(R.id.tvCorpName);
            holder.tvRoomType = (TextView) convertView.findViewById(R.id.tvRoomType);
//            holder.tvContactPhone = (TextView) convertView.findViewById(R.id.tvContactPhone);

//            holder.btn_receiveOrder = convertView.findViewById(R.id.btn_receive_order);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
//        holder.btn_receiveOrder.setOnClickListener(new android.view.View.OnClickListener() {

//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                onClick.OrderReceive();
//            }
//        });
        holder.tvRoomName.setText(cleanerOrderBeanList.get(position).getCorp_room_name());
        holder.tvTime.setText(cleanerOrderBeanList.get(position).getDoor_time());
        holder.tvAddress.setText(cleanerOrderBeanList.get(position).getCorp_addr());
//        holder.tvPaymentPrice.setText(cleanerOrderBeanList.get(position).getBed_num());
        holder.tvCorpName.setText(cleanerOrderBeanList.get(position).getCorp_name());
        holder.tvRoomType.setText(cleanerOrderBeanList.get(position).getRoom_type_name());
//        holder.tvContactPhone.setText(cleanerOrderBeanList.get(position).getCorp_name());
        return convertView;
    }
    class ViewHolder{
        TextView tvTime,tvAddress,tvPaymentPrice,tvCorpName,tvRoomName,tvRoomType;
//        Button btn_receiveOrder;
    }

    public interface OnListenerClick{
        void OrderReceive();
    }
}

package cn.njthl.cleaner.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import cn.njthl.cleaner.R;
import cn.njthl.cleaner.model.Bean.OrderRoomBean;

import java.util.List;

public class OrderRoomAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private OrderReceiveAdapter.OnListenerClick onClick;
    private List<OrderRoomBean> OrderRoomBeanlist;

    public void setOnClick(OrderReceiveAdapter.OnListenerClick onClick) {
        this.onClick = onClick;
    }

    public OrderRoomAdapter(Context context, List<OrderRoomBean> orderRoomBeanlist) {
        // TODO Auto-generated constructor stub
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.OrderRoomBeanlist = orderRoomBeanlist;
    }
    @Override
    public int getCount() {
        if(OrderRoomBeanlist!=null)
            return OrderRoomBeanlist.size();
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
        OrderRoomAdapter.ViewHolder holder;
        if(convertView == null){
            holder = new OrderRoomAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.item_order_room, null);
            holder.tv_room_name = (TextView) convertView.findViewById(R.id.tvRoomName);
            holder.tv_room_type = (TextView) convertView.findViewById(R.id.tvRoomType);
            holder.tv_bed_num = (TextView) convertView.findViewById(R.id.tv_bed_num);
            holder.tv_room_area = (TextView) convertView.findViewById(R.id.tv_room_area);
//            holder.btn_receiveOrder = convertView.findViewById(R.id.btn_receive_order);
            convertView.setTag(holder);
        }else{
            holder = (OrderRoomAdapter.ViewHolder) convertView.getTag();
        }
//        holder.btn_receiveOrder.setOnClickListener(new android.view.View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                onClick.OrderReceive();
//            }
//        });
        holder.tv_room_name.setText(OrderRoomBeanlist.get(position).getCorp_room_name());
        holder.tv_room_type.setText(OrderRoomBeanlist.get(position).getRoom_type_id());
        holder.tv_bed_num.setText(OrderRoomBeanlist.get(position).getBed_num());
        holder.tv_room_area.setText(OrderRoomBeanlist.get(position).getRoom_area_id());
        return convertView;
    }
    class ViewHolder{
        TextView tv_room_name,tv_room_type,tv_bed_num,tv_room_area;
//        Button btn_receiveOrder;
    }

    public interface OnListenerClick{
        void OrderReceive();
    }
}
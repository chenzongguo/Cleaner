package cn.njthl.cleaner.ui.view;

import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public interface IOrderDetailAtView {
//    ListView getLvRoomInfo();
    TextView getTvAddress();
    TextView getTvCorpName();
    TextView getTvRoomName();
    TextView getTvRoomType();
    TextView getTvBedNum();
    TextView getTvOrderId();
    TextView getTvRemark();
    Button getBtnParnterReceipt();
    RelativeLayout getRlyNoCompelte();
    RelativeLayout getRlyCompelte();
}

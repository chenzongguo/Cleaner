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
    TextView getTvRoomState();
    TextView getTvBedNum();
    TextView getTvOrderId();
    TextView getTvRemark();
    TextView getTvCreateTime();
    TextView getTvTime();
    TextView getTvContacts();
    TextView getTvContactPhone();
    Button getBtnParnterReceipt();
    Button getBtnEvaluation();
    RelativeLayout getRlyNoCompelte();
    RelativeLayout getRlyCompelte();
}

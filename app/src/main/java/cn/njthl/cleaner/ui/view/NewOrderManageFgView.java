package cn.njthl.cleaner.ui.view;

import android.widget.TextView;

import cn.njthl.cleaner.widget.MyListView;

public interface NewOrderManageFgView {
    MyListView getLvOrder();
    TextView getTvNoArriveCorp();
    TextView getTvArriveCorp();
    TextView getTvCleanComplete();
    TextView getTvOrderComplete();
}

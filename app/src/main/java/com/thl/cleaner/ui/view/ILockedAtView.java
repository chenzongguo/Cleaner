package com.thl.cleaner.ui.view;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public interface ILockedAtView {
    List<EditText> GetEtList();
    List<TextView> GetTvList();
    List<ImageView> GetImgList();
}

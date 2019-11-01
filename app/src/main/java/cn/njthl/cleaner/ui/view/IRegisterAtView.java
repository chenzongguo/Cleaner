package cn.njthl.cleaner.ui.view;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public interface IRegisterAtView {
    EditText getEtPhone();

    EditText getEtVerifyCode();

    EditText getEtPwd();

    EditText getEtPwd2();

    LinearLayout getLlyPhone();

    LinearLayout getLlyVerifyCode();

    LinearLayout getLlypwd();

    TextView getTvPhone();

}

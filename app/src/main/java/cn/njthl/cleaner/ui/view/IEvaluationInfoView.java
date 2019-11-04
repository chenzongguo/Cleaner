package cn.njthl.cleaner.ui.view;

import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public interface IEvaluationInfoView {
    RatingBar getcleanliness_star();
    RatingBar getorder_speed_star();
    TextView getTvRatingExplain();
    ImageView getImageView1();
}

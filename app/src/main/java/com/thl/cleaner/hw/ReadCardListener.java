package com.thl.cleaner.hw;

import android.graphics.Bitmap;

public interface ReadCardListener {
	void readInfoSuccess(CardInfo cardInfo);
	void readBmpSuccess(Bitmap bitmap);
	void readError(String error);
	void readStatus(String status);
}

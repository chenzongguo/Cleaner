package cn.njthl.cleaner.app;

import android.app.ActivityManager;
import android.content.Context;
import android.util.DisplayMetrics;

import com.previewlibrary.ZoomMediaLoader;

import cn.njthl.cleaner.app.base.BaseApp;

import org.litepal.LitePal;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 *
 */

public class MyApp extends BaseApp {
    private static MyApp instance;
    private static int mWidth;
    private static int mHeight;
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
        ZoomMediaLoader.getInstance().init(new TestImageLoader());
//        SQLiteDatabase db = Connector.getDatabase();
        instance = this;
        DisplayMetrics mDisplayMetrics = getResources().getDisplayMetrics();
        mHeight = mDisplayMetrics.heightPixels;
        mWidth = mDisplayMetrics.widthPixels;
    }

    public static String getCurProcessName(Context context) {

        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {

            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

//    public static String getReadCardMacAddress() {
//        Log.i("Test", SharedPreferencesHelper.getValueStr(SPConstant.DEVICEINFO, SPConstant.mBtMacAddress));
//        return SharedPreferencesHelper.getValueStr(SPConstant.DEVICEINFO, SPConstant.mBtMacAddress);
//    }

    public static MyApp getInstance() {
        return instance;
    }

    public static int getWidth() {
        return mWidth;
    }

    public static int getHeigth() {
        return mHeight;
    }

}

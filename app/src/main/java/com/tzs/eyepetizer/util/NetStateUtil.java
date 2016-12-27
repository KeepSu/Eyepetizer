package com.tzs.eyepetizer.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.tzs.eyepetizer.constant.NetState;

/**
 * 检测网络状态的工具
 */

public class NetStateUtil {

    /**
     * 获取网络连接类型
     */
    public static int getNetStateState(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetStateInfo = connectivityManager.getActiveNetworkInfo();
        if (mNetStateInfo != null && mNetStateInfo.isConnected()) {
            int type = mNetStateInfo.getType();
            if (type == ConnectivityManager.TYPE_WIFI) {
                return NetState.STATE_WIFI;
            }
            if (type == ConnectivityManager.TYPE_MOBILE) {
                return NetState.STATE_MOBILE;
            }
        }
        return NetState.STATE_NONE;
    }

    /**
     * 判断有无网络
     */
    public static boolean isNetConnect(Context context) {
        switch (getNetStateState(context)) {
            case NetState.STATE_NONE:
                return false;
            default:
                return true;
        }
    }

    /**
     * 展示网络类型
     */
    public static void showNetType(Context context) {
        switch (getNetStateState(context)) {
            case NetState.STATE_NONE:
                ToastUtil.showToast(context, "进入了没有网络的异次元/(ㄒoㄒ)/~~");
                break;
            case NetState.STATE_MOBILE:
                ToastUtil.showToast(context, "正在使用移动网络<(￣ˇ￣)/~~");
                break;
            case NetState.STATE_WIFI:
                ToastUtil.showToast(context, "已连接到WiFi(/≧▽≦)/~~");
                break;
        }
    }
}

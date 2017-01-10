package com.tzs.eyepetizer;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.tzs.eyepetizer.service.NetBroadcastReceiver;
import com.tzs.eyepetizer.service.OnNetChangeListener;
import com.tzs.eyepetizer.util.NetStateUtil;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by h on 2016/12/27.
 */

public class MyApplication extends Application implements OnNetChangeListener {

    public static boolean isNetConn;
    public static boolean isLogin = false;

    @Override
    public void onCreate() {
        super.onCreate();
        NetStateUtil.showNetType(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(new NetBroadcastReceiver(this), filter);
        isNetConn = NetStateUtil.isNetConnect(this);

    }

    @Override
    public void onNetChange() {
        NetStateUtil.showNetType(this);
        isNetConn = NetStateUtil.isNetConnect(this);
        NetStateUtil.showNetType(this);
    }
}

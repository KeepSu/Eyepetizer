package com.tzs.eyepetizer.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;


/**
 * 接收网络状态改变的信息
 */
public class NetBroadcastReceiver extends BroadcastReceiver {

    private OnNetChangeListener listener;

    public NetBroadcastReceiver(OnNetChangeListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            listener.onNetChange();
        }
    }
}

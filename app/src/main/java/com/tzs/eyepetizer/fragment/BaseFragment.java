package com.tzs.eyepetizer.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.google.gson.Gson;
import com.tzs.eyepetizer.util.NetStateUtil;
import com.tzs.eyepetizer.util.ToastUtil;

import java.io.Serializable;

/**
 * 基础Fragment
 */

public class BaseFragment extends Fragment {
    /**
     * 解析Json
     */
    protected Object parseJson(String json, Class obj) {
        Gson gson = new Gson();
        return gson.fromJson(json, obj);
    }

    /**
     * 展示Toast
     */
    protected Toast showToast(String text) {
        return ToastUtil.showToast(getContext(), text);
    }

    /**
     * 跳转到另一个Activity
     */
    protected void goToAnotherActivity(Class<? extends Activity> targetActivity, String... data) {
        Intent intent = new Intent(getContext(), targetActivity);
        for (int i = 0; i < data.length; i++) {
            intent.putExtra("data" + i, data[i]);
        }
        startActivity(intent);
    }

    /**
     * 跳转到另一个Activity
     */
    protected void goToAnotherActivity(Class<? extends Activity> targetActivity, Object obj) {
        Intent intent = new Intent(getContext(), targetActivity);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object", (Serializable) obj);
        intent.putExtra("data", bundle);
        startActivity(intent);
        isNetConn();
    }

    protected boolean isNetConn() {
        if (NetStateUtil.isNetConnect(getContext())) {
            return true;
        }
        showToast("当前无网络连接");
        return false;
    }
}

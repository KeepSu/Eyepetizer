package com.tzs.eyepetizer.fragment;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.tzs.eyepetizer.util.NetStateUtil;
import com.tzs.eyepetizer.util.ToastUtil;

import java.io.Serializable;

/**
 * 基础Fragment
 */

public class BaseFragment extends Fragment {

    public Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

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
        return ToastUtil.showToast(context, text);
    }

    /**
     * 跳转到另一个Activity
     */
    protected void goToAnotherActivity(Class<? extends Activity> targetActivity, String... data) {
        Intent intent = new Intent(context, targetActivity);
        for (int i = 0; i < data.length; i++) {
            intent.putExtra("data" + i, data[i]);
        }
        startActivity(intent);
    }

    /**
     * 跳转到另一个Activity,共享控件
     */
    protected void goToAnotherActivity(Class<? extends Activity> targetActivity, Object obj, View view, String name) {
        Intent intent = new Intent(context, targetActivity);
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation((Activity) context, view, name).toBundle();
        startActivity(intent, bundle);
    }


    /**
     * 跳转到另一个Activity
     */
    protected void goToAnotherActivity(Class<? extends Activity> targetActivity, Object obj) {
        Intent intent = new Intent(context, targetActivity);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object", (Serializable) obj);
        intent.putExtra("data", bundle);
        startActivity(intent);
        isNetConn();
    }

    protected boolean isNetConn() {
        if (NetStateUtil.isNetConnect(context)) {
            return true;
        }
        showToast("当前无网络连接");
        return false;
    }
}

package com.tzs.eyepetizer.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.util.ToastUtil;

import java.io.Serializable;

/**
 * Activity基类，定义一些公用方法
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_base);
    }

    /**
     * 初始化view
     */
    protected void initView() {

    }

    /**
     * 展示数据
     */
    protected void showData() {

    }

    /**
     * 设置事件
     */
    protected void setEvent() {

    }

    /**
     * 初始化数据
     */
    protected void initData() {
    }


    /**
     * 展示Toast
     */
    protected Toast showToast(String text) {
        return ToastUtil.showToast(this, text);
    }

    /**
     * 沉浸式状态栏
     */
    protected void initState() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    /**
     * 跳转到另一个Activity
     */
    public void goToAnotherActivity(Class<? extends Activity> targetActivity, String... data) {
        Intent intent = new Intent(this, targetActivity);
        for (int i = 0; i < data.length; i++) {
            intent.putExtra("data" + i, data[i]);
        }
        startActivity(intent);
    }

    /**
     * 跳转到另一个Activity
     */
    public void goToAnotherActivity(Class<? extends Activity> targetActivity, Object obj) {
        Intent intent = new Intent(this, targetActivity);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object", (Serializable) obj);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    /**
     * 跳转到另一个Activity,共享控件
     */
    public void goToAnotherActivity(Class<? extends Activity> targetActivity, Object obj, View view, String name) {
        Intent intent = new Intent(this, targetActivity);
        intent.putExtra("object", (Serializable) obj);
        Bundle bundle1 = ActivityOptions.makeSceneTransitionAnimation(this, view, name).toBundle();
        startActivity(intent, bundle1);
    }

    /**
     * 解析Json
     */
    protected Object parseJson(String json, Class obj) {
        Gson gson = new Gson();
        return gson.fromJson(json, obj);
    }
}

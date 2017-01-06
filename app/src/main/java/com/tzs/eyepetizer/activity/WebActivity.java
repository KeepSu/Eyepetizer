package com.tzs.eyepetizer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.tzs.eyepetizer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends AppCompatActivity {
    @BindView(R.id.webTitle)
    public TextView webTitle;
    @BindView(R.id.webView)
    public WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        final String title = intent.getStringExtra("webTitle");
        final String url = intent.getStringExtra("webUrl");

        webTitle.setText(title);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }
        });

        //优先使用缓存
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        //不使用缓存：
//        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            if(webView.canGoBack()) {
                webView.goBack();//返回上一页面
                return true;
            } /*else {
                System.exit(0);//退出程序
            }*/
        }
        return super.onKeyDown(keyCode, event);
    }
}

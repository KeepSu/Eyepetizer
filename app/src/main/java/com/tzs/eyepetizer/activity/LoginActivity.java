package com.tzs.eyepetizer.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tzs.eyepetizer.MyApplication;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.util.FileUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.tv_weixin)
    TextView tv_weixin;
    @BindView(R.id.tv_weibo)
    TextView tv_weibo;
    @BindView(R.id.tv_qq)
    TextView tv_qq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    /**
     * 处理点击事件
     */
    @OnClick({R.id.tv_weixin, R.id.tv_weibo, R.id.tv_qq})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_weixin:
                login(Wechat.NAME);
                break;
            case R.id.tv_weibo:
                login(SinaWeibo.NAME);
                break;
            case R.id.tv_qq:
                login(QQ.NAME);
                break;
        }
    }

    private void login(String name) {
        Platform platform = ShareSDK.getPlatform(name);
        platform.showUser(null);
        platform.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

//                Set<Map.Entry<String, Object>> set = hashMap.entrySet();
//                Iterator<Map.Entry<String, Object>> iterator = set.iterator();
//                while (iterator.hasNext()) {
//                    Map.Entry<String, Object> next = iterator.next();
//                    Log.e("==========>" + next.getKey(), "=============>" + next.getValue());
//                }

                String icon = hashMap.get("figureurl_qq_2").toString();
                String userName = platform.getDb().getUserName();
                FileUtils.saveUsername(LoginActivity.this, userName);
                FileUtils.savePortrait(LoginActivity.this, icon);
                ((MyApplication) getApplication()).isLogin = true;
                showToast("登录成功O(∩_∩)O~");
                finish();
//                String token = platform.getDb().getToken();
//                String userId = platform.getDb().getUserId();
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                showToast("登录失败");
                finish();

            }

            @Override
            public void onCancel(Platform platform, int i) {
                finish();
            }
        });
    }
}

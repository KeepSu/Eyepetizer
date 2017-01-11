package com.tzs.eyepetizer.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tzs.eyepetizer.MyApplication;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.util.FileUtils;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

public class SetActivity extends BaseActivity {

    @BindView(R.id.tv_out)
    TextView tv_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        ButterKnife.bind(this);
        if (((MyApplication) getApplication()).isLogin) {
            tv_out.setVisibility(View.VISIBLE);
        } else {
            tv_out.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.tv_out})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_out:
                new AlertDialog.Builder(SetActivity.this)
                        .setTitle("退出登录")
                        .setMessage("是否退出登录")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deauthorize();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                break;
        }
    }
    //返回键
    @OnClick(R.id.iv_back)
    void onClick() {
        finish();
    }

    /**
     * 取消授权
     */
    private void deauthorize() {
        String names[] = {QQ.NAME, Wechat.NAME, SinaWeibo.NAME};
        for (int i = 0; i < names.length; i++) {
            Platform platform = ShareSDK.getPlatform(names[i]);
            if (platform.isAuthValid()) {
                platform.removeAccount(true);
            }
        }
        FileUtils.clearAccount(SetActivity.this);
        ((MyApplication) getApplication()).isLogin = false;
        tv_out.setVisibility(View.GONE);

        showToast("退出成功(*^__^*)");
    }
}

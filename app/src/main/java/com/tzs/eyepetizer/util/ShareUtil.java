package com.tzs.eyepetizer.util;

import android.content.Context;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by h on 2017/1/11.
 */

public class ShareUtil {
    public static void showShare(Context context, String title, String description, String url) {
        ShareSDK.initSDK(context);
        OnekeyShare oks = new OnekeyShare();
        oks.disableSSOWhenAuthorize();
        oks.setTitle(title);
        oks.setTitleUrl(url);
        oks.setText(description);
        oks.setComment("我是测试评论文本");
        oks.show(context);
    }
}

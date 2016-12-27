package com.tzs.eyepetizer.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 显示Toast的工具
 */
public class ToastUtil {
    private static Toast toast;

    public static Toast showToast(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
        return toast;
    }
}

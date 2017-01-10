package com.tzs.eyepetizer.util;

import android.content.Context;
import android.content.SharedPreferences;

public class FileUtils {
    /**
     * 保存密码到本地文件
     *
     * @param context
     * @param portrait
     */
    public static void savePortrait(Context context, String portrait) {
        SharedPreferences preferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("portrait", portrait);
        editor.commit();
    }

    public static void clearAccount(Context context) {
        SharedPreferences info = context.getSharedPreferences("userInfo", context.MODE_PRIVATE);
        info.edit().clear().commit();
    }

    /**
     * 保存用户名到本地文件
     *
     * @param context
     * @param username
     */
    public static void saveUsername(Context context, String username) {
        SharedPreferences preferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.commit();
    }

    /**
     * 从本地文件获取用户名
     *
     * @param context
     * @return
     */
    public static String getUsername(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String username = preferences.getString("username", null);
        return username;
    }

    /**
     * 从本地文件获取登录密码
     *
     * @param context
     * @return
     */
    public static String getportrait(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String portrait = preferences.getString("portrait", null);
        return portrait;
    }
}

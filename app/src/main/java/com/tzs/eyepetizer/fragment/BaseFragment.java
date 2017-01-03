package com.tzs.eyepetizer.fragment;

import android.support.v4.app.Fragment;

import com.google.gson.Gson;

/**
 * Created by h on 2016/12/28.
 */

public class BaseFragment extends Fragment{
    /**
     * 解析Json
     */
    protected Object parseJson(String json, Class obj) {
        Gson gson = new Gson();
        return gson.fromJson(json, obj);
    }
}

package com.tzs.eyepetizer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.DiscoverAdapter;
import com.tzs.eyepetizer.entity.Discover;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 发现页面
 */
public class DiscoverFragment extends Fragment {
    private static String path = "http://baobab.kaiyanapp.com/api/v4/tabs/discovery?";

    @BindView(R.id.recyclerView_Discover)
    RecyclerView recyclerView_Discover;

    private Discover mDiscover;//解析出来的discover对象

    private DiscoverAdapter adapter;

    public DiscoverFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new DiscoverAdapter(getContext());
        recyclerView_Discover.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView_Discover.setAdapter(adapter);
        download();
    }

    private void download() {
        OkHttpUtils.get(path).execute(new StringCallback() {//回调
            @Override
            public void onSuccess(String s, Call call, Response response) {
                mDiscover = new Gson().fromJson(s, Discover.class);//解析出来的discover对象
                adapter.setList(mDiscover.getItemList());
            }
        });
    }
}

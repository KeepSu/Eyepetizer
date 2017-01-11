package com.tzs.eyepetizer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.PanoramicAdapter;
import com.tzs.eyepetizer.entity.Panoramic;
import com.tzs.eyepetizer.view.PullRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 360全景页面
 */
public class PanoramicFragment extends Fragment {
    private String path = null;
    List<Panoramic.ItemListBean> mList = new ArrayList<>();

    @BindView(R.id.rv_Panoramic)
    PullRecyclerView rv_Panoramic;

    private Panoramic panoramic;
    private PanoramicAdapter adapter;

    public PanoramicFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_panoramic, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        path = bundle.getString("path");

        adapter = new PanoramicAdapter(getContext());
        rv_Panoramic.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_Panoramic.setAdapter(adapter);
        download();
        //监听，当滑到底部的时候下载并加载下一页的数据
        rv_Panoramic.setOnScrollToButtomLinstener(new PullRecyclerView.OnScrollToButtomLinstener() {
            @Override
            public void onScrollToButtom() {
                download();
            }
        });
    }

    private void download () {
        if (path != null) {
            OkHttpUtils.get(path).execute(new StringCallback() {
                @Override
                public void onSuccess(String s, Call call, Response response) {
                    panoramic = new Gson().fromJson(s, Panoramic.class);
                    path = panoramic.getNextPageUrl();
                    mList.addAll(panoramic.getItemList());
                    adapter.setList(mList);
                }
            });
        } else {
            adapter.setList(mList);
        }
    }

}

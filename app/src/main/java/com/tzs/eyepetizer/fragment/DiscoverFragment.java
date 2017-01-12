package com.tzs.eyepetizer.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.AllClassifyActivity;
import com.tzs.eyepetizer.activity.SearchActivity;
import com.tzs.eyepetizer.adapter.DiscoverAdapter;
import com.tzs.eyepetizer.entity.Discover;
import com.tzs.eyepetizer.view.PullRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 发现页面
 */
public class DiscoverFragment extends BaseFragment implements View.OnClickListener {
    private static String path = "http://baobab.kaiyanapp.com/api/v4/tabs/discovery";
    List<Discover.ItemListBeanX> mList = new ArrayList<>();

    @BindView(R.id.recyclerView_Discover)
    PullRecyclerView recyclerView_Discover;
    @BindView(R.id.tv_classify)
    TextView tv_classify;
    @BindView(R.id.iv_search)
    ImageView iv_serach;

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
        //监听，当滑到底部的时候下载并加载下一页的数据
        recyclerView_Discover.setOnScrollToButtomLinstener(new PullRecyclerView.OnScrollToButtomLinstener() {
            @Override
            public void onScrollToButtom() {
                download();
            }
        });
    }

    private void download() {
        if (path != null) {
            OkHttpUtils.get(path).execute(new StringCallback() {//回调
                @Override
                public void onSuccess(String s, Call call, Response response) {
                    mDiscover = new Gson().fromJson(s, Discover.class);//解析出来的discover对象
                    path = mDiscover.getNextPageUrl();//每次数据下载完成后，是path得到下一页的数据
                    mList.addAll(mDiscover.getItemList());
                    adapter.setList(mList);
                }
            });
        } else {
            adapter.setList(mList);
        }
    }

    @OnClick({R.id.tv_classify, R.id.iv_search})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_classify://点击跳转进入所有分类
                goToAnotherActivity(AllClassifyActivity.class);
                break;
            case R.id.iv_search://点击跳转进入搜索页
                goToAnotherActivity(SearchActivity.class);
                break;
        }
    }
}

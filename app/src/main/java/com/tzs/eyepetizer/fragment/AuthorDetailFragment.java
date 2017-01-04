package com.tzs.eyepetizer.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.AuthorDatailRVAdapter;
import com.tzs.eyepetizer.entity.Follow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者详情Fragment
 */
public class AuthorDetailFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private Context context;
    //视频Item的RecyclerView适配器
    private AuthorDatailRVAdapter adapter;
    //获取视频详情数据源

    //装数据源的集合
    private List<Follow.ItemListBeanX.DataBeanX.ItemListBean> list=new ArrayList();
    private Follow.ItemListBeanX itemListBeanX;
    private Follow.ItemListBeanX.DataBeanX.ItemListBean itemListBean;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_author_detail, container, false);
        ButterKnife.bind(this,view);
        Bundle bundle = getArguments();
        itemListBeanX = (Follow.ItemListBeanX) bundle.getSerializable("itemListBeanX");
        int position = bundle.getInt("position", 0);
        itemListBean = itemListBeanX.getData().getItemList().get(position);
        list.add(itemListBean);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setEvent();
        initData();
    }

    /**
     * 设置事件
     */
    private void setEvent() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter=new AuthorDatailRVAdapter(context);
        recyclerView.setAdapter(adapter);
    }

    /**
     * 初始数据
     */
    private void initData() {
        adapter.setList(list);
    }
}

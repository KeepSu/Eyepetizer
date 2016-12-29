package com.tzs.eyepetizer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tzs.eyepetizer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 关注页面
 */
public class FollowFragment extends Fragment {
    @BindView(R.id.rv_out)
    RecyclerView rv_out;
    @BindView(R.id.tv_author)
    TextView tv_author;
    @BindView(R.id.iv_search)
    ImageView iv_search;
    public FollowFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow, container, false);
        //解析注解
        ButterKnife.bind(this,view);

        return view;
    }


}

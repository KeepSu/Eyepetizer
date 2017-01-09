package com.tzs.eyepetizer.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.SetActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的页面
 */
public class MineFragment extends BaseFragment implements View.OnClickListener{
    @BindView(R.id.iv_set)
    ImageView iv_set;
    private Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iv_set.setOnClickListener(this);
    }

    //点击到设置页面
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(context, SetActivity.class);
        startActivity(intent);
    }
}

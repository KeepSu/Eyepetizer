package com.tzs.eyepetizer.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.test.mock.MockApplication;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tzs.eyepetizer.MyApplication;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.LoginActivity;
import com.tzs.eyepetizer.activity.SetActivity;
import com.tzs.eyepetizer.util.FileUtils;
import com.tzs.eyepetizer.util.ImageUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的页面
 */
public class MineFragment extends BaseFragment {
    @BindView(R.id.iv_set)
    ImageView iv_set;
    @BindView(R.id.iv_head)
    ImageView iv_head;
    @BindView(R.id.tv_name)
    TextView tv_name;

    private String name;
    private Context context;
    private String portrait;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        name = FileUtils.getUsername(context);
        portrait = FileUtils.getportrait(context);
        if (name != null) {
            tv_name.setText(name);
            ImageUtil.setCircleImage(context, portrait, iv_head);
            iv_head.setEnabled(false);
            ((MyApplication) getActivity().getApplication()).isLogin = true;
            return;
        }
        iv_head.setEnabled(true);
        tv_name.setText("点击登录即可发表评论及同步已收藏视频");
        iv_head.setImageResource(R.drawable.pgc_default_avatar);
    }

    //点击到设置页面
    @OnClick({R.id.iv_set, R.id.iv_head})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_set:
                Intent intent = new Intent(context, SetActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_head:
                goToAnotherActivity(LoginActivity.class);
        }
    }
}

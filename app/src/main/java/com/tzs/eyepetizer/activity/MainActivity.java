package com.tzs.eyepetizer.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.util.FragmentUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements RadioGroup.OnCheckedChangeListener{

    @BindView(R.id.layout)
    FrameLayout layout;
    private RadioGroup rg;
    private int mPrePosition=-1;//起始位置
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        setEvent();

    }

    //初始化view
    protected void initView() {
        rg= (RadioGroup) findViewById(R.id.rg);

    }
    //设置监听事件
    protected void setEvent() {
        showFragment(0);
        Log.e("======","-======");
        rg.setOnCheckedChangeListener(this);
    }

    //RadioGroup的监听事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i <group.getChildCount(); i++) {
            RadioButton button = (RadioButton) group.getChildAt(i);
            if (button.isChecked()){
                showFragment(i);
            }
        }
    }
    //Fragment的添加与隐藏
    private void showFragment(int position) {
        List<Fragment> fragmentList = FragmentUtil.getFragmentList();
        if (mPrePosition != position) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            if (!FragmentUtil.getFragmentList().get(position).isAdded()) {
                if (mPrePosition != -1) {
                    fragmentTransaction.hide(fragmentList.get(mPrePosition));
                }
                fragmentTransaction.add(R.id.layout, fragmentList.get(position));
                fragmentTransaction.show(fragmentList.get(position));
                mPrePosition = position;
            } else {
                fragmentTransaction.hide(fragmentList.get(mPrePosition)).show(fragmentList.get(position));
                mPrePosition = position;
            }
            fragmentTransaction.commit();
        }
    }
}

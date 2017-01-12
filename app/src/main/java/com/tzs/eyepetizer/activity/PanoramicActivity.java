package com.tzs.eyepetizer.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.FindTabAdapter;
import com.tzs.eyepetizer.fragment.PanoramicFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PanoramicActivity extends BaseActivity
        implements ViewPager.OnPageChangeListener,
        View.OnClickListener {
    private String pathDate = "http://baobab.kaiyanapp.com/api/v3/tag/videos?tagId=658&strategy=date";
    private String pathShare = "http://baobab.kaiyanapp.com/api/v3/tag/videos?tagId=658&strategy=shareCount";

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private FindTabAdapter adapter;
    private List<Fragment> listFragment;
    private List<String> listTitle;

    @BindView(R.id.iv_360Back)
    ImageView iv_360Back;
    @BindView(R.id.iv_360Share)
    ImageView iv_360Share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panoramic);
        ButterKnife.bind(this);
        initData();
        adapter = new FindTabAdapter(getSupportFragmentManager(), listFragment, listTitle);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    protected void initData() {
        listTitle = new ArrayList<>();
        listTitle.add("按时间排序");
        listTitle.add("按分享排序");

        listFragment = new ArrayList<>();

        PanoramicFragment pf = new PanoramicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("path", pathDate);
        pf.setArguments(bundle);

        PanoramicFragment pf1 = new PanoramicFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("path", pathShare);
        pf1.setArguments(bundle1);

        listFragment.add(pf);
        listFragment.add(pf1);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }


    @OnClick({R.id.iv_360Back, R.id.iv_360Share})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_360Back:
                finish();
                break;
//            case R.id.iv_360Share:
//
//                break;
        }
    }
}

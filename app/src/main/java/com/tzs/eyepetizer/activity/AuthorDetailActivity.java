package com.tzs.eyepetizer.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.AuthorDetailVPAdapter;
import com.tzs.eyepetizer.entity.Follow;
import com.tzs.eyepetizer.fragment.ADTwoFragment;
import com.tzs.eyepetizer.fragment.AuthorDetailFragment;
import com.tzs.eyepetizer.util.ImageUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AuthorDetailActivity extends BaseActivity {
  /*  @BindView(R.id.iv_share)
    ImageView iv_share;*/
    @BindView(R.id.iv_portrait)
    ImageView iv_portrait;
    @BindView(R.id.tv_author)
    TextView tv_author;
    @BindView(R.id.tv_video)
    TextView tv_video;
    @BindView(R.id.tv_collection)
    TextView tv_collection;
    @BindView(R.id.tv_share)
    TextView tv_share;
    @BindView(R.id.tv_description)
    TextView tv_description;
    @BindView(R.id.btn_attention)
    Button btn_attention;
    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tool_bar)
    Toolbar tool_bar;
    @BindView(R.id.dd)
    CollapsingToolbarLayout collapsingToolbarLayout;
    private String[] titles = {"按时间排序", "按分享排序"};
    private List<Fragment> fragmentList = new ArrayList<>();
    private AuthorDetailVPAdapter adapter;
    //作者详情页面的数据源
    private List<Follow.ItemListBeanX> itemList;
    private int position;
    private List<Follow.ItemListBeanX.DataBeanX.ItemListBean> itemList2;
    private Follow.ItemListBeanX itemListBeanX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_detail);
        ButterKnife.bind(this);
        tool_bar.setNavigationIcon(R.drawable.ic_action_back);
        setSupportActionBar(tool_bar);
        showData();
        initData();
    }

    /**
     * 展示数据
     */
    @Override
    protected void showData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        itemList = (List<Follow.ItemListBeanX>) bundle.getSerializable("itemList");
        position = bundle.getInt("position", 0);
        itemListBeanX = itemList.get(position);
        itemList2 = this.itemList.get(position).getData().getItemList();
        ImageUtil.setCircleImage(this, itemList2.get(position).getData().getAuthor().getIcon(), iv_portrait);
        tv_author.setText(itemList2.get(position).getData().getAuthor().getName());
        tv_video.setText(itemList2.get(position).getData().getAuthor().getVideoNum() + " 个视频");
        tv_collection.setText(itemList2.get(position).getData().getConsumption().getCollectionCount() + " 次收藏");
        tv_share.setText(itemList2.get(position).getData().getConsumption().getShareCount() + " 次分享");
        //点击关注
        boolean followed = itemList2.get(position).getData().getAuthor().getFollow().isFollowed();
        if (followed) {
            btn_attention.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn_attention.setText("已关注");
                }
            });
        }
        tv_description.setText(itemList2.get(position).getData().getAuthor().getDescription());
        collapsingToolbarLayout.setTitle(itemList2.get(position).getData().getAuthor().getName());
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#00000000"));
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLACK);
    }

    /**
     * 初始数据
     */
    @Override
    protected void initData() {
        //activity传值到详情fragment中
        AuthorDetailFragment authorDetailFragment = new AuthorDetailFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("position",position);
        bundle.putSerializable("itemListBeanX", itemListBeanX);
        authorDetailFragment.setArguments(bundle);
        fragmentList.add(authorDetailFragment);
        fragmentList.add(new ADTwoFragment());
        adapter = new AuthorDetailVPAdapter(getSupportFragmentManager(),
                fragmentList,
                titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //返回键
    public void back(View view) {
        finish();
    }
}

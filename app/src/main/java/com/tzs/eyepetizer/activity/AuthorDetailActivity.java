package com.tzs.eyepetizer.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.AuthorDetailVPAdapter;
import com.tzs.eyepetizer.callback.OnCallBack;
import com.tzs.eyepetizer.entity.AuthorDetail;
import com.tzs.eyepetizer.fragment.AuthorDetailFragment;
import com.tzs.eyepetizer.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnPageChange;

public class AuthorDetailActivity extends BaseActivity {
    @BindView(R.id.iv_portrait)
    ImageView iv_portrait;
    @BindView(R.id.tv_author)
    TextView tv_author;
    @BindView(R.id.tv_brief)
    TextView tv_brief;
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
    //作者的id
    private int id;
    private AuthorDetailFragment adFragment1;
    private View view1;
    private View view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_detail);
        ButterKnife.bind(this);
        tool_bar.setNavigationIcon(R.drawable.ic_action_back);
        setSupportActionBar(tool_bar);
        setCustomTabLayout();
        //初始化数据
        initData();
        //传值到AuthorDetailFragment中
        toADFragment();
        //回调回来的数据
        adFragment1.setCallBack(new OnCallBack() {
            @Override
            public void OnCallBackData(AuthorDetail authorDetail) {
                setData(authorDetail);
            }
        });
    }
    //自定义TabLayout
    private void setCustomTabLayout() {
        //设置选中指示器的颜色
        tabLayout.setSelectedTabIndicatorColor(Color.RED);
        //设置为滚动模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < titles.length; i++) {
            //添加默认内容
            tabLayout.addTab(tabLayout.newTab().setCustomView(getTabView(i)));
        }

        //利用ViewTree观察修改tab内容
        tabLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                for (int i = 0; i < titles.length; i++) {
                    //设置真正的内容
                    tabLayout.getTabAt(i).setCustomView(getTabView(i));
                }

                //移除之后自己处理全局布局监听事件
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    tabLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }
    public View getTabView(int position){
        //首先为子tab布置一个布局
        View v = LayoutInflater.from(this).inflate(R.layout.layout_tablayout_item,null);
        TextView tv_type = (TextView) v.findViewById(R.id.tv_type);
        tv_type.setText(titles[position]);
       /* view1 = v.findViewById(R.id.view1);
        view2 = v.findViewById(R.id.view2);*/
        return v;
    }


    //设置数据
    private void setData(AuthorDetail authorDetail) {
        //作者头像
        ImageUtil.setCircleImage(this, authorDetail.getPgcInfo().getIcon(), iv_portrait);
        //收藏，分享，视频个数
        tv_brief.setText(authorDetail.getPgcInfo().getBrief());
        //作者描述
        tv_description.setText(authorDetail.getPgcInfo().getDescription());
        //点击关注
        boolean followed = authorDetail.getPgcInfo().getFollow().isFollowed();
        if (followed) {
            btn_attention.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn_attention.setText("已关注");
                }
            });
        }
        //collapsingToolbarLayout设置相关标题，颜色
        collapsingToolbarLayout.setTitle(authorDetail.getPgcInfo().getName());

/* collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#00000000"));
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLACK);*/
    }

    //本页面传值到AuthorDetailFragment中
    private void toADFragment() {
        adFragment1 = new AuthorDetailFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("id",id);
        bundle.putString("strategy","date");
        bundle.putBoolean("isFirst",true);
        adFragment1.setArguments(bundle);

        AuthorDetailFragment adFragment2=new AuthorDetailFragment();
        Bundle bundle1=new Bundle();
        bundle1.putInt("id",id);
        bundle1.putString("strategy","shareCount");
        adFragment2.setArguments(bundle1);

        fragmentList.add(adFragment1);
        fragmentList.add(adFragment2);
        //给适配器添加数据
        adapter.setFragments(fragmentList);
    }

    /**
     * 初始数据
     */
    @Override
    protected void initData() {
        //从关注页面的RVAdapter传递作者id到本页面
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        id = bundle.getInt("id", 0);
        adapter = new AuthorDetailVPAdapter(getSupportFragmentManager(),fragmentList,
                titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @OnPageChange(R.id.viewpager)
    void onPageSelected(int position) {
        Log.i("info","==position="+position);


    }
}

package com.tzs.eyepetizer.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.AuthorDetailVPAdapter;
import com.tzs.eyepetizer.apiservice.HttpApiService;
import com.tzs.eyepetizer.callback.OnCallBack;
import com.tzs.eyepetizer.entity.AuthorDetail;
import com.tzs.eyepetizer.entity.Follow;
import com.tzs.eyepetizer.fragment.ADTwoFragment;
import com.tzs.eyepetizer.fragment.AuthorDetailFragment;
import com.tzs.eyepetizer.util.ImageUtil;
import com.tzs.eyepetizer.util.PathUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnPageChange;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
    private AuthorDetailFragment authorDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_detail);
        ButterKnife.bind(this);
        tool_bar.setNavigationIcon(R.drawable.ic_action_back);
        setSupportActionBar(tool_bar);
        //初始化数据
        initData();
       /* authorDetailFragment.setCallBack(new OnCallBack() {
            @Override
            public void OnCallBackData(AuthorDetail authorDetail) {
                setData(authorDetail);
            }
        });*/
    }



    //设置数据
    private void setData(AuthorDetail authorDetail) {
        //作者头像
        ImageUtil.setCircleImage(this, authorDetail.getPgcInfo().getIcon(), iv_portrait);
        //作者名字
        tv_author.setText(authorDetail.getPgcInfo().getName());
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
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#00000000"));
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLACK);

        //本页面传值到AuthorDetailFragment中
        toADFragment(authorDetail);
    }

    //本页面传值到AuthorDetailFragment中
    private void toADFragment(AuthorDetail authorDetail) {
       // authorDetailFragment = AuthorDetailFragment.getInstance(id, "date");
        authorDetailFragment = new AuthorDetailFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("id",id);
        bundle.putSerializable("authorDetail",authorDetail);
        authorDetailFragment.setArguments(bundle);
        fragmentList.add(authorDetailFragment);
        fragmentList.add(new ADTwoFragment());
        adapter = new AuthorDetailVPAdapter(getSupportFragmentManager(),
                fragmentList,
                titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
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
        parseAuthorDetailData(id,"date");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //ViewPager的监听事件
    @OnPageChange(R.id.viewpager)
    void onPageSelected(int position) {

    }

    //返回键
    public void back(View view) {
        finish();
    }

    //解析作者详情的数据
    private void parseAuthorDetailData(int id, String strategy) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PathUtil.getFollowPth())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        HttpApiService apiService = retrofit.create(HttpApiService.class);
        Observable<AuthorDetail> observable =
                apiService.getAuthorDetailVideoList(String.valueOf(id), strategy);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AuthorDetail>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(AuthorDetail authorDetail) {
                        Log.i("info","===authorDetail===="+authorDetail);
                        setData(authorDetail);
                    }
                });
    }
}

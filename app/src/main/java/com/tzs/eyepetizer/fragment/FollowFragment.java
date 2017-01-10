package com.tzs.eyepetizer.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.SearchActivity;
import com.tzs.eyepetizer.adapter.FollowRVAdapter;
import com.tzs.eyepetizer.apiservice.HttpApiService;
import com.tzs.eyepetizer.entity.Follow;
import com.tzs.eyepetizer.util.AnimaUtil;
import com.tzs.eyepetizer.util.PathUtil;
import com.tzs.eyepetizer.view.PullRecyclerView;
import com.tzs.eyepetizer.view.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 关注页面
 */
public class FollowFragment extends BaseFragment {
    @BindView(R.id.rr)
    PullToRefreshRecyclerView pullToRefreshRecyclerView;
    @BindView(R.id.tv_author)
    TextView tv_author;
    @BindView(R.id.iv_search)
    ImageView iv_search;
    RecyclerView recyclerView;
    private FollowRVAdapter adapter;
    private int flag=1;
    private int page=0;
    private List<Follow.ItemListBeanX> list=new ArrayList<>();
    private Context context;
    public FollowFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow, container, false);
        //解析注解
        ButterKnife.bind(this,view);
        Log.e("======","======FollowFragment========");
        recyclerView = pullToRefreshRecyclerView.getRefreshableView();
        //设置布局方式
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        //pullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshRecyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() {
            @Override
            public void onRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                list.clear();
                getFollowData(String.valueOf(flag),"1");
            }
        });
        //滑动到底部自动加载
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isSlideToBottom(recyclerView)) {
                    Log.e("=====","===到达底部了===");
                    flag=2;
                    page+=2;
                    getFollowData(String.valueOf(flag),String.valueOf(page));
                }
            }
        });

        //设置适配器
        adapter=new FollowRVAdapter(context);
        recyclerView.setAdapter(adapter);
        //下载数据
        getFollowData(String.valueOf(flag),"1");

        toSearchActivity();
        return view;
    }

    //监听是否到达底部
    public boolean isSlideToBottom(RecyclerView recyclerView) {
        if (recyclerView == null)
            return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }

    //跳转到搜索页面
    private void toSearchActivity() {
        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, SearchActivity.class);
                startActivity(intent);
                View view = LayoutInflater.from(context).inflate(R.layout.activity_search, null);
                AnimaUtil.appear(1000,view);
            }
        });
    }


    private void getFollowData(String flag,String page) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PathUtil.getFollowPth())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        HttpApiService apiService=retrofit.create(HttpApiService.class);
        Observable<Follow> observable = null;
        if (flag.equals("1")){
             observable=apiService.getFollowList();

        }else if(flag.equals("2")){
            observable = apiService.getFollowNextList(page, "2", "false", "0");
        }
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Follow>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Follow follow) {
                        Log.e("===", "==onNext===" + follow.getItemList().size());
                        list.addAll(follow.getItemList());
                        adapter.setList(list);
                        pullToRefreshRecyclerView.onRefreshComplete();
                    }
                });
    }

}

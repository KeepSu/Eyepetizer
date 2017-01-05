package com.tzs.eyepetizer.fragment;


import android.content.Context;
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
import com.tzs.eyepetizer.adapter.FollowRVAdapter;
import com.tzs.eyepetizer.apiservice.HttpApiService;
import com.tzs.eyepetizer.entity.Follow;
import com.tzs.eyepetizer.util.PathUtil;
import com.tzs.eyepetizer.view.PullToRefreshRecyclerView;

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
        pullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshRecyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                Log.e("=====","==下拉 ===");
                getFollowData(String.valueOf(flag),"1");
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                Log.e("=====","===上拉===");
                flag=2;
                page+=2;
                getFollowData(String.valueOf(flag),String.valueOf(page));
            }
        });
        //设置适配器
        adapter=new FollowRVAdapter(context);
        recyclerView.setAdapter(adapter);
        //下载数据
        getFollowData(String.valueOf(flag),"1");
        return view;
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
                        adapter.setList(follow.getItemList());
                        pullToRefreshRecyclerView.onRefreshComplete();
                    }
                });
    }
}

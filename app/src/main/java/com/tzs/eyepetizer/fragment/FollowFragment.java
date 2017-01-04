package com.tzs.eyepetizer.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.AuthorDetailActivity;
import com.tzs.eyepetizer.adapter.FollowRVAdapter;
import com.tzs.eyepetizer.apiservice.HttpApiService;
import com.tzs.eyepetizer.entity.Follow;
import com.tzs.eyepetizer.util.PathUtil;
import com.tzs.eyepetizer.util.ToastUtil;
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
    private List<Follow.ItemListBeanX> list = new ArrayList<>();
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
        pullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshRecyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                Log.e("=====","==下拉 ===");
                flag=1;
                list.clear();
                new MyAsyncTask().execute(flag+"","1");
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                Log.e("=====","===上拉===");
                flag=2;
                page+=2;
                Log.i("===","===page=="+page);
                new MyAsyncTask().execute(flag+"",page+"");
            }
        });
        return view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter=new FollowRVAdapter(context);
        recyclerView = pullToRefreshRecyclerView.getRefreshableView();
        //设置布局方式
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //设置适配器
        recyclerView.setAdapter(adapter);
        getFollowData(flag+"","1");
    }

    private void getFollowData(String flag,String page) {
        if (flag.equals("1")){
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(PathUtil.getFollowPth())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            HttpApiService apiService=retrofit.create(HttpApiService.class);
            Observable<Follow> observable=apiService.getFollowList();
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
                            list.addAll(follow.getItemList());
                            adapter.setList(list);
                        }
                    });
        }else if(flag.equals("2")){
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("http://baobab.kaiyanapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            HttpApiService apiService=retrofit.create(HttpApiService.class);
            Observable<Follow> observable = apiService.getFollowNextList(page, "2", "false", "0");
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
                              list.addAll(follow.getItemList());
                              adapter.setList(list);
                          }
                      });
        }

    }

    class MyAsyncTask extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... params) {
            String flag= params[0];
            return flag;
        }

        @Override
        protected void onPostExecute(String flag) {
            super.onPostExecute(flag);
            pullToRefreshRecyclerView.onRefreshComplete();
            if ("1".equals(flag)){
                getFollowData(flag,page+"");
            }else if ("2".equals(flag)){
                getFollowData(flag,page+"");
            }
            showToast("刷新成功");
        }
    }



}

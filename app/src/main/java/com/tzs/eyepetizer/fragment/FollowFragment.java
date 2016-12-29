package com.tzs.eyepetizer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.FollowRVAdapter;
import com.tzs.eyepetizer.apiservice.HttpApiService;
import com.tzs.eyepetizer.entity.Follow;
import com.tzs.eyepetizer.util.PathUtil;

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
public class FollowFragment extends Fragment {
    @BindView(R.id.rv_out)
    RecyclerView rv_out;
    @BindView(R.id.tv_author)
    TextView tv_author;
    @BindView(R.id.iv_search)
    ImageView iv_search;
    private FollowRVAdapter adapter;
    public FollowFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow, container, false);
        //解析注解
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter=new FollowRVAdapter(getContext());
        //设置布局方式
        rv_out.setLayoutManager(new LinearLayoutManager(getContext()));
        //设置适配器
        rv_out.setAdapter(adapter);

        getFollowData();
    }

    private void getFollowData() {
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
                          adapter.setList(follow.getItemList());
                      }
                  });
    }


}

package com.tzs.eyepetizer.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.AuthorDatailRVAdapter;
import com.tzs.eyepetizer.apiservice.HttpApiService;
import com.tzs.eyepetizer.callback.OnCallBack;
import com.tzs.eyepetizer.entity.AuthorDetail;
import com.tzs.eyepetizer.entity.Follow;
import com.tzs.eyepetizer.util.PathUtil;

import java.io.Serializable;
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
 * 作者详情Fragment
 */
public class AuthorDetailFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private Context context;
    //视频Item的RecyclerView适配器
    private AuthorDatailRVAdapter adapter;

    //装数据源的集合
    private List<AuthorDetail.ItemListBean> list=new ArrayList();

    private OnCallBack callBack;

    private boolean isFirst;
    public void setCallBack(OnCallBack callBack) {
        this.callBack = callBack;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
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
                        if (isFirst){
                            callBack.OnCallBackData(authorDetail);
                            isFirst=false;
                        }
                        //添加数据到集合中
                        list.addAll(authorDetail.getItemList());
                        initData();
                        Log.i("==","==size=="+list.size());
                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_author_detail, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    //获取本类对象
/*    public static AuthorDetailFragment getInstance(int id,String strategy){
        AuthorDetailFragment authorDetailFragment = new AuthorDetailFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("id",id);
        bundle.putString("strategy",strategy);
        authorDetailFragment.setArguments(bundle);
        return authorDetailFragment;
    }*/

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        int id = bundle.getInt("id", 0);
        String strategy = bundle.getString("strategy");
        isFirst = bundle.getBoolean("isFirst");
        parseAuthorDetailData(id,strategy);
        setEvent();
    }

    /**
     * 设置事件
     */
    private void setEvent() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter=new AuthorDatailRVAdapter(context);
        recyclerView.setAdapter(adapter);
    }

    /**
     * 初始数据
     */
    private void initData() {
        adapter.setList(list);
    }
}

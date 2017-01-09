package com.tzs.eyepetizer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.SearchRVAdapter;
import com.tzs.eyepetizer.apiservice.HttpApiService;
import com.tzs.eyepetizer.entity.Search;
import com.tzs.eyepetizer.util.PathUtil;

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
 * 搜索详情Fragment
 */
public class SearchFragment extends Fragment {
    @BindView(R.id.tv_info)
    TextView tv_info;
    @BindView(R.id.search_recyclerView)
    RecyclerView search_recyclerView;
    private Context ctx;
    private List<Search.ItemListBeanX.DataBeanX.ItemListBean> list = new ArrayList<>();
    private SearchRVAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ctx = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        search_recyclerView.setLayoutManager(new LinearLayoutManager(ctx));
        adapter = new SearchRVAdapter(ctx);
        search_recyclerView.setAdapter(adapter);
        Bundle bundle = getArguments();
        String key = bundle.getString("key");
        getResultDatafromSearch(key);
    }

    /**
     * 获取搜索结果数据
     */
    private void getResultDatafromSearch(String key) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PathUtil.getFollowPth())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        HttpApiService apiService = retrofit.create(HttpApiService.class);
        Observable<Search> observable = apiService.getSearchList(key);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Search>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Search search) {
                        Log.i("===", "search==" + search);
                        Log.i("===", "count==" + search.getCount());
                        list.addAll(search.getItemList().get(0).getData().getItemList());
                        adapter.setList(list);
                    }
                });
    }
}

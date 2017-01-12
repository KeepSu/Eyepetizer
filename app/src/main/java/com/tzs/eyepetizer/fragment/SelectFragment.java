package com.tzs.eyepetizer.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.BaseActivity;
import com.tzs.eyepetizer.activity.DailyActivity;
import com.tzs.eyepetizer.activity.SearchActivity;
import com.tzs.eyepetizer.adapter.SelectAdapter;
import com.tzs.eyepetizer.callback.OnPullToRefreshListener;
import com.tzs.eyepetizer.callback.OnScrollToBottomListener;
import com.tzs.eyepetizer.entity.select.Banner;
import com.tzs.eyepetizer.entity.select.ItemCollection;
import com.tzs.eyepetizer.entity.select.SelectItem;
import com.tzs.eyepetizer.entity.select.TextFooter;
import com.tzs.eyepetizer.entity.select.TextHeader;
import com.tzs.eyepetizer.entity.select.VideoBeanForClient;
import com.tzs.eyepetizer.util.TimeUtil;
import com.tzs.eyepetizer.view.PullScrollView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 精选页面
 */
public class SelectFragment extends BaseFragment implements OnScrollToBottomListener, View.OnClickListener, OnPullToRefreshListener {

    @BindView(R.id.rv_select)
    RecyclerView rv_select;
    @BindView(R.id.pullScrollView)
    PullScrollView pullScrollView;
    @BindView(R.id.tv_end)
    TextView tv_end;
    @BindView(R.id.tv_data)
    TextView tv_data;
    @BindView(R.id.iv_search)
    ImageView iv_search;
    @BindView(R.id.iv_head)
    ImageView iv_head;

    private List<SelectItem> selectList = new ArrayList<>();
    private SelectAdapter adapter;
    private boolean isLoading = false;//是否正在加载数据
    private boolean isRefresh = false;//是否是在刷新
    private static final String HOME_PAGE_URL = "http://baobab.kaiyanapp.com/api/v4/tabs/selected";
    private String nextPageUrl = HOME_PAGE_URL;//下一页数据的地址


    public SelectFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select, container, false);
        ButterKnife.bind(this, view);
        tv_end.setVisibility(View.GONE);
        tv_data.setText(TimeUtil.getDateToday());
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new SelectAdapter(selectList, context);
        rv_select.setLayoutManager(new LinearLayoutManager(context));
        pullScrollView.setOnScrollToBottomListener(this);
        pullScrollView.setOnPullToRefreshListener(this);
        rv_select.setAdapter(adapter);
    }

    /**
     * 加载数据
     */
    private void initData() {
        if (nextPageUrl.equals("null")) {
            tv_end.setVisibility(View.VISIBLE);
            return;
        }
        if (!isNetConn() || isLoading) {
            return;
        }
        isLoading = true;
        OkHttpUtils.get(nextPageUrl)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
//                        if (isRefresh) {
//                            selectList.clear();
//                            isRefresh = false;
//                            showToast("刷新完成\\(^o^)/~");
//                        }
                        parseJson(s);
                        isLoading = false;
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        showToast("访问网络失败~");
                        isRefresh = false;
                        isLoading = false;
                    }
                });
    }

    /**
     * 解析json
     */
    private void parseJson(String json) {
        try {
            JSONObject object = new JSONObject(json);
            nextPageUrl = object.getString("nextPageUrl");
            JSONArray array = object.getJSONArray("itemList");
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                if (obj.getString("type").equals("squareCardCollection")) {
                    continue;
                }
                if (obj.getString("type").equals("banner2")) {
                    continue;
                }
                JSONObject data = obj.getJSONObject("data");
                String type = data.getString("dataType");
                String dataJson = obj.toString();
                SelectItem selectItem = new SelectItem();
                switch (type) {
                    case "VideoBeanForClient":
                        selectItem = (VideoBeanForClient) parseJson(dataJson, VideoBeanForClient.class);
                        break;
                    case "TextFooter":
                        selectItem = (TextFooter) parseJson(dataJson, TextFooter.class);
                        break;
                    case "ItemCollection":
                        selectItem = (ItemCollection) parseJson(dataJson, ItemCollection.class);
                        break;
                    case "TextHeader":
                        selectItem = (TextHeader) parseJson(dataJson, TextHeader.class);
                        break;
                    case "Banner":
                        selectItem = (Banner) parseJson(dataJson, Banner.class);
                        break;
                }
                selectList.add(selectItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
    }

    /**
     * ScrollView滑动到底部的监听
     */
    @Override
    public void OnScrollToBottom() {
        initData();
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onPullToRefresh() {
//        isRefresh = true;
//        nextPageUrl = HOME_PAGE_URL;
//        tv_end.setVisibility(View.GONE);
//        isLoading = false;
//        initData();

    }

    /**
     * 点击事件的处理
     */
    @OnClick({R.id.iv_search, R.id.iv_head})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_search:
                goToAnotherActivity(SearchActivity.class);
                break;
            case R.id.iv_head:
                ((BaseActivity) context).transition(DailyActivity.class);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        selectList.clear();
        nextPageUrl = HOME_PAGE_URL;
        tv_end.setVisibility(View.GONE);
        isLoading = false;

    }
}

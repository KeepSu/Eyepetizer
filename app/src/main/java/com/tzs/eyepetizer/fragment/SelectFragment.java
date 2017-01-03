package com.tzs.eyepetizer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.SelectAdapter;
import com.tzs.eyepetizer.entity.select.ItemCollection;
import com.tzs.eyepetizer.entity.select.SelectItem;
import com.tzs.eyepetizer.entity.select.TextFooter;
import com.tzs.eyepetizer.entity.select.TextHeader;
import com.tzs.eyepetizer.entity.select.VideoBeanForClient;
import com.tzs.eyepetizer.util.NetStateUtil;
import com.tzs.eyepetizer.util.ToastUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 精选页面
 */
public class SelectFragment extends BaseFragment {

    @BindView(R.id.rv_select)
    RecyclerView rv_select;

    private List<SelectItem> selectList = new ArrayList<>();
    private SelectAdapter adapter;

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
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rv_select.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new SelectAdapter(selectList, getActivity());
        rv_select.setAdapter(adapter);
    }

    /**
     * 加载数据
     */
    private void initData() {
        if (!isNetConn()) {
            return;
        }
        OkHttpUtils.get("http://baobab.kaiyanapp.com/api/v4/tabs/selected")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        parseJson(s);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtil.showToast(getContext(), "访问网络失败~");
                    }
                });
    }

    /**
     * 解析json
     */
    private void parseJson(String json) {
        try {
            JSONObject object = new JSONObject(json);
            JSONArray array = object.getJSONArray("itemList");
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
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
                }
                selectList.add(selectItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
    }
}

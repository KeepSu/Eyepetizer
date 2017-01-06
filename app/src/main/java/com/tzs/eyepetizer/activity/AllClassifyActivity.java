package com.tzs.eyepetizer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.AllClassifyAdapter;
import com.tzs.eyepetizer.entity.AllClassify;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class AllClassifyActivity extends AppCompatActivity {
    private static String path = "http://baobab.kaiyanapp.com/api/v4/categories/all";

    @BindView(R.id.iv_classifyBack)
    ImageView iv_classifyBack;
    @BindView(R.id.rv_allClassify)
    RecyclerView rv_allClassify;

    private AllClassify mClassify;
    private AllClassifyAdapter acAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_classify);
        ButterKnife.bind(this);
        acAdapter = new AllClassifyAdapter(this);
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 2) {
                    return 2;
                }
                return 1;
            }
        });
        rv_allClassify.setLayoutManager(manager);
        rv_allClassify.setAdapter(acAdapter);
        download();
    }

    private void download () {
        OkHttpUtils.get(path).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                mClassify = new Gson().fromJson(s, AllClassify.class);
                acAdapter.setList(mClassify.getItemList());
            }
        });
    }
}

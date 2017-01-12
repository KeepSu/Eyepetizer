package com.tzs.eyepetizer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.SubjectAdapter;
import com.tzs.eyepetizer.entity.AllClassify;
import com.tzs.eyepetizer.view.PullRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class SubjectActivity extends AppCompatActivity
        implements View.OnClickListener {
    private String path = "http://baobab.kaiyanapp.com/api/v3/specialTopics?";

    @BindView(R.id.rv_Subject)
    PullRecyclerView rv_Subject;
    @BindView(R.id.iv_Back)
    ImageView iv_Back;

    private AllClassify subject;
    private List<AllClassify.ItemListBean> list = new ArrayList<>();
    private SubjectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        ButterKnife.bind(this);
        adapter = new SubjectAdapter(this);
        rv_Subject.setLayoutManager(new LinearLayoutManager(this));
        rv_Subject.setAdapter(adapter);
        download();
        rv_Subject.setOnScrollToButtomLinstener(new PullRecyclerView.OnScrollToButtomLinstener() {
            @Override
            public void onScrollToButtom() {
                download();
            }
        });
    }

    private void download() {
        if (path != null) {
            OkHttpUtils.get(path).execute(new StringCallback() {
                @Override
                public void onSuccess(String s, Call call, Response response) {
                    subject = new Gson().fromJson(s, AllClassify.class);
                    path = subject.getNextPageUrl().toString();
                    list.addAll(subject.getItemList());
                    adapter.setList(list);
                }
            });
        } else {
            adapter.setList(list);
        }
    }

    @OnClick({R.id.iv_Back})
    public void onClick(View v) {
        finish();
    }
}

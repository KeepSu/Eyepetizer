package com.tzs.eyepetizer.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.adapter.RelatedAdapter;
import com.tzs.eyepetizer.entity.select.ItemCollection;

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

import static android.net.Uri.parse;

public class RelatedActivity extends BaseActivity {

    //http://baobab.kaiyanapp.com/api/v3/video/11790/detail/related

    private String id;
    private String title;
    private RelatedAdapter adapter;
    private List<ItemCollection> data = new ArrayList<>();
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.iv_back)
    ImageView iv_back;
    @BindView(R.id.rv_related)
    RecyclerView rv_related;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Slide().setDuration(500));
            getWindow().setExitTransition(new Slide().setDuration(500));
        }
        setContentView(R.layout.activity_related);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("data0");
        title = getIntent().getStringExtra("data1");
        tv_title.setText(title);
        adapter = new RelatedAdapter(data, this);
        rv_related.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_related.setAdapter(adapter);
        intData();
    }

    private void intData() {
        OkHttpUtils.get("http://baobab.kaiyanapp.com/api/v3/video/" + id + "/detail/related")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        parseData(s);
                    }
                });
    }

    private void parseData(String s) {
        try {
            JSONObject object = new JSONObject(s);
            JSONArray array = object.getJSONArray("itemList");
            for (int i = 0; i < array.length(); i++) {
                String json = array.getJSONObject(i).toString();
                ItemCollection item = (ItemCollection) parseJson(json, ItemCollection.class);
                data.add(item);
            }
            adapter.notifyDataSetChanged();
            Log.e("=======>", "========data====>" + data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.iv_back)
    public void onClick(View view) {
        finish();
    }
}

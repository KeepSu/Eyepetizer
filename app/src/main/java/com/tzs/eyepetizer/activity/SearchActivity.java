package com.tzs.eyepetizer.activity;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.fragment.SearchFragment;

import org.json.JSONArray;
import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.et_search)
    EditText et_search;
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.layout1)
    LinearLayout layout1;
    @BindView(R.id.layout2)
    LinearLayout layout2;
    @BindView(R.id.layout3)
    LinearLayout layout3;
    @BindView(R.id.layout4)
    LinearLayout layout4;
    @BindView(R.id.layout5)
    LinearLayout layout5;
    @BindView(R.id.iv_search)
    ImageView iv_search;
    @BindView(R.id.rl)
    RelativeLayout rl;

    @BindView(R.id.textView)
    TextView textView;

    @BindView(R.id.textView2)
    TextView textView2;
    //搜索词
    private String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        getSearchWordData();
        key=et_search.getText().toString();
        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    Log.i("===","111111");
                    textView.setVisibility(View.GONE);
                    textView2.setVisibility(View.GONE);
                    layout.setVisibility(View.GONE);
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    SearchFragment tf=new SearchFragment();
                    Bundle bundle=new Bundle();
                    bundle.putString("key",key);
                    tf.setArguments(bundle);
                    ft.replace(R.id.rl,tf);
                    ft.commit();
                    return true;
                }
                return false;
            }
        });

    }


    //获得热门搜索词数据
    private void getSearchWordData() {
        OkHttpUtils.get("http://baobab.kaiyanapp.com/api/v3/queries/hot?")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.i("info", "==s=" + s);
                        JSONArray array = null;
                        try {
                            array = new JSONArray(s.trim());
                            for (int i = 0; i < array.length(); i++) {
                                String string = array.optString(i);
                                TextView textView = new TextView(SearchActivity.this);
                                textView.setText(string);
                                textView.setTextColor(Color.GRAY);
                                textView.setPadding(10, 0, 10, 0);
                                if (i <= 5) {
                                    layout1.addView(textView);
                                } else if (i > 5 && i <= 10) {
                                    layout2.addView(textView);
                                } else if (i > 10 && i <= 15) {
                                    layout3.addView(textView);
                                } else if (i > 15 && i <= 20) {
                                    layout4.addView(textView);
                                } else if (i > 20 && i < array.length()) {
                                    layout5.addView(textView);
                                }

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    //点击取消，返回关注页面
    public void cancle(View view) {
        finish();
    }
}

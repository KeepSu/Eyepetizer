package com.tzs.eyepetizer.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tzs.eyepetizer.R;

public class VideoInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_info);
        initState();
    }
}

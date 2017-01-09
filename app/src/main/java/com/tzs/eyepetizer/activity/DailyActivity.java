package com.tzs.eyepetizer.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;

import com.tzs.eyepetizer.R;

public class DailyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Slide().setDuration(1000));
            getWindow().setExitTransition(new Slide().setDuration(1000));
        }
        setContentView(R.layout.activity_daily);
    }
}

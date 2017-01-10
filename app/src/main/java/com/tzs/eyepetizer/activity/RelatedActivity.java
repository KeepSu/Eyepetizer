package com.tzs.eyepetizer.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;

import com.tzs.eyepetizer.R;

public class RelatedActivity extends AppCompatActivity {

    //http://baobab.kaiyanapp.com/api/v3/video/11790/detail/related
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Slide().setDuration(500));
            getWindow().setExitTransition(new Slide().setDuration(500));
        }
        setContentView(R.layout.activity_related);
    }
}

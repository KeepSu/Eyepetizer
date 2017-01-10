package com.tzs.eyepetizer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tzs.eyepetizer.R;

public class ClassInfoActivity extends AppCompatActivity {
    private String path = "http://baobab.kaiyanapp.com/api/v4/categories/detail?id=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_info);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        path += id;
    }
}

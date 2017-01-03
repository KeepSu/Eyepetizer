package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.tzs.eyepetizer.entity.select.VideoBeanForClient;

import java.util.List;

/**
 * Created by h on 2016/12/30.
 */

class VideoSetAdapter extends RecyclerView.Adapter {

    private List<VideoBeanForClient> list;
    private Context context;

    public VideoSetAdapter(List<VideoBeanForClient> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}

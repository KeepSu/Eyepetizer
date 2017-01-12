package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.entity.select.ItemCollection;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 相关视频的适配器
 */

public class RelatedAdapter extends RecyclerView.Adapter<RelatedAdapter.MyViewHolder> {

    private List<ItemCollection> list;
    private Context context;
    private LayoutInflater inflater;

    public RelatedAdapter(List<ItemCollection> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        Log.e("===============>", "==========adapter======>");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_related_video, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemCollection.DataBean data = list.get(position).getData();

        holder.tv_subtitle.setText(data.getHeader().getTitle() + " >");
        holder.rv_inner_video.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.rv_inner_video.setAdapter(new VideoSetAdapter(context, data.getItemList()));
    }

    @Override
    public int getItemCount() {
        Log.e("==========>", "=======>" + list.size());
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_subtitle)
        TextView tv_subtitle;
        @BindView(R.id.rv_inner_video)
        RecyclerView rv_inner_video;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

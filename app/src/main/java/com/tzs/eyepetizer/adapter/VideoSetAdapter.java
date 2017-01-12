package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.BaseActivity;
import com.tzs.eyepetizer.activity.VideoInfoActivity;
import com.tzs.eyepetizer.entity.select.TextHeader;
import com.tzs.eyepetizer.entity.select.VideoBeanForClient;
import com.tzs.eyepetizer.util.ImageUtil;
import com.tzs.eyepetizer.util.TimeUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by h on 2016/12/30.
 */

class VideoSetAdapter extends RecyclerView.Adapter {

    private List<VideoBeanForClient> list;
    private Context context;
    private LayoutInflater inflater;
    public int flag = -1;

    public VideoSetAdapter(Context context, List<VideoBeanForClient> list) {
        inflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_select_inner_video, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = ((MyViewHolder) holder);
        final VideoBeanForClient.DataBean data = list.get(position).getData();
        myViewHolder.tv_inner_title.setText(data.getTitle());
        myViewHolder.tv_inner_during.setText("#" + data.getCategory() + " / " + TimeUtil.getDurnig(data.getDuration()));
        ImageUtil.setImage(context, data.getCover().getFeed(), myViewHolder.iv_inner_cover, ImageUtil.SIZE_MIN);
        myViewHolder.iv_inner_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) context).goToAnotherActivity(
                        VideoInfoActivity.class, data, ((MyViewHolder) holder).iv_inner_cover, data.getId() + "");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_inner_cover)
        ImageView iv_inner_cover;
        @BindView(R.id.tv_inner_title)
        TextView tv_inner_title;
        @BindView(R.id.tv_inner_during)
        TextView tv_inner_during;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

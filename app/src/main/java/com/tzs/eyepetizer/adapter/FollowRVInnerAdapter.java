package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.BaseActivity;
import com.tzs.eyepetizer.activity.VideoInfoActivity;
import com.tzs.eyepetizer.entity.Follow;
import com.tzs.eyepetizer.entity.select.VideoBeanForClient;
import com.tzs.eyepetizer.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Item里面的滚动的RecycView适配器
 */
public class FollowRVInnerAdapter extends RecyclerView.Adapter<FollowRVInnerAdapter.MyViewHolder> {
    private static Context context;
    private LayoutInflater inflater;
    private  List<Follow.ItemListBeanX.DataBeanX.ItemListBean> list = new ArrayList<>();
    private View view;
    public void setList(Follow.ItemListBeanX beanX) {
        list= beanX.getData().getItemList();
        notifyDataSetChanged();
    }

    public FollowRVInnerAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.follow_author_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Follow.ItemListBeanX.DataBeanX.ItemListBean.DataBean data = list.get(position).getData();
        holder.tv_content.setText(data.getTitle());
        String category = data.getCategory();
        int duration = data.getDuration();
        String time = TimeUtil.getDurnig(duration);
        holder.tv_category.setText("#" + category + " / " + time);
        Glide.with(context).load(data.getCover().getFeed()).placeholder(R.drawable.pgc_default_avatar).into(holder.iv_image);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoBeanForClient client = (VideoBeanForClient) list.get(holder.getAdapterPosition());
                VideoBeanForClient.DataBean data = client.getData();
                ((BaseActivity) context).goToAnotherActivity(VideoInfoActivity.class, data);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_image)
        ImageView iv_image;
        @BindView(R.id.tv_content)
        TextView tv_content;
        @BindView(R.id.tv_category)
        TextView tv_category;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

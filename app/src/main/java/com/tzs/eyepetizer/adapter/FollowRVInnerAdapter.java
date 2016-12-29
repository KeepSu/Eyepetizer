package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.entity.Follow;

import java.util.ArrayList;
import java.util.List;

/**
 * Item里面的滚动的RecycView适配器
 */
public class FollowRVInnerAdapter extends RecyclerView.Adapter<FollowRVInnerAdapter.MyViewHolder>{
    private Context context;
    private LayoutInflater inflater;
    private List<Follow.ItemListBeanX.DataBeanX.ItemListBean> list=new ArrayList<>();
    public void setList(List<Follow.ItemListBeanX.DataBeanX.ItemListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public FollowRVInnerAdapter(Context context) {
        this.context = context;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.follow_author_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_image;
        private TextView tv_content,tv_playTime;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv_image= (ImageView) itemView.findViewById(R.id.iv_image);
            tv_content= (TextView) itemView.findViewById(R.id.tv_content);
            tv_playTime= (TextView) itemView.findViewById(R.id.tv_playTime);
        }
    }

}

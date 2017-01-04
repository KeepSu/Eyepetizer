package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.entity.Follow;
import com.tzs.eyepetizer.util.ImageUtil;
import com.tzs.eyepetizer.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者详情RecyclerViewAdapter
 */
public class AuthorDatailRVAdapter extends RecyclerView.Adapter<AuthorDatailRVAdapter.MyViewHolder>{
    private List<Follow.ItemListBeanX.DataBeanX.ItemListBean> lists=new ArrayList();
    private Context context;
    public void setList(List<Follow.ItemListBeanX.DataBeanX.ItemListBean> list) {
        this.lists=list;
        notifyDataSetChanged();
    }

    public AuthorDatailRVAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_select_video,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Follow.ItemListBeanX.DataBeanX.ItemListBean.DataBean list = lists.get(position).getData();
        //设置标题
        holder.tv_title.setText(list.getTitle());
        //设置类型
        int duration = list.getDuration();
        holder.tv_category_duration.setText("#"+list.getCategory()+" / "
                                        + TimeUtil.getDurnig(duration));
        //设置作者名字
        holder.tv_author.setText(list.getAuthor().getName());
        //设置背景图片
        ImageUtil.setImage(context,list.getCover().getFeed(),holder.iv_select_cover);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        //item的图片
        @BindView(R.id.iv_select_cover)
        ImageView iv_select_cover;
        //item的标题
        @BindView(R.id.tv_title)
        TextView tv_title;
        //item的类型
        @BindView(R.id.tv_category_duration)
        TextView tv_category_duration;
        //item的作者
        @BindView(R.id.tv_author)
        TextView tv_author;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

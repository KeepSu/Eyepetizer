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
import com.tzs.eyepetizer.activity.BaseActivity;
import com.tzs.eyepetizer.activity.VideoInfoActivity;
import com.tzs.eyepetizer.entity.AuthorDetail;
import com.tzs.eyepetizer.entity.Follow;
import com.tzs.eyepetizer.entity.select.ItemCollection;
import com.tzs.eyepetizer.entity.select.VideoBeanForClient;
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
    private List<AuthorDetail.ItemListBean> lists=new ArrayList();
    private Context context;
    private View view;

    public void setList(List<AuthorDetail.ItemListBean> list) {
        this.lists=list;
        notifyDataSetChanged();
    }

    public AuthorDatailRVAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_select_video,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Log.i("==","===lists.size()==="+lists.size());
        //设置标题
        holder.tv_title.setText(lists.get(position).getData().getTitle());
        Log.i("==","==title=="+lists.get(position).getData().getTitle());
        //设置类型
        int duration = lists.get(position).getData().getDuration();
        holder.tv_category_duration.setText("#"+lists.get(position).getData().getCategory()+" / "
                                        + TimeUtil.getDurnig(duration));
        Log.i("==","==type=="+"#"+lists.get(position).getData().getCategory()+" / "
                + TimeUtil.getDurnig(duration));
        //设置作者名字
        holder.tv_author.setText(lists.get(position).getData().getAuthor().getName());
        Log.i("==","==name=="+lists.get(position).getData().getAuthor().getName());
        ItemCollection.DataBean.HeaderBean.LabelBean label = (ItemCollection.DataBean.HeaderBean.LabelBean) lists.get(position).getData().getLabel();
        if (null!=label){
            holder.tv_promotion.setVisibility(View.VISIBLE);
            String text = (String) label.getText();
            holder.tv_promotion.setText(text);
        }else {
            holder.tv_promotion.setVisibility(View.GONE);
        }
        //设置背景图片
        ImageUtil.setImage(context,lists.get(position).getData().getCover().getFeed(),holder.iv_select_cover);
        //位置监听
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoBeanForClient client = (VideoBeanForClient) lists.get(holder.getAdapterPosition());
                VideoBeanForClient.DataBean data = client.getData();
                ((BaseActivity) context).goToAnotherActivity(VideoInfoActivity.class, data);
            }
        });
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
        //item的是否有全景
        @BindView(R.id.tv_promotion)
        TextView tv_promotion;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

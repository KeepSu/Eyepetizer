package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.BaseActivity;
import com.tzs.eyepetizer.activity.VideoInfoActivity;
import com.tzs.eyepetizer.entity.Search;
import com.tzs.eyepetizer.entity.select.ItemCollection;
import com.tzs.eyepetizer.entity.select.VideoBeanForClient;
import com.tzs.eyepetizer.util.ImageUtil;
import com.tzs.eyepetizer.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索页面的RV适配器
 */
public class SearchRVAdapter extends RecyclerView.Adapter<AuthorDatailRVAdapter.MyViewHolder> {
    private Context context;
    private List<Search.ItemListBean> lists = new ArrayList<>();
    private View itemView;

    public SearchRVAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<Search.ItemListBean> list) {
        this.lists = list;
        notifyDataSetChanged();
    }

    @Override
    public AuthorDatailRVAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(context).inflate(R.layout.item_select_video, parent, false);
        return new AuthorDatailRVAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AuthorDatailRVAdapter.MyViewHolder holder, int position) {
        Search.ItemListBean.DataBean data = lists.get(position).getData();
        //设置标题
        holder.tv_title.setText(data.getTitle());
        //设置类型
        int duration = data.getDuration();
        holder.tv_category_duration.setText("#" + data.getCategory() + " / "
                + TimeUtil.getDurnig(duration));
        //设置作者名字
        Search.ItemListBean.DataBean.AuthorBean author = data.getAuthor();
        if (null != author) {
            holder.tv_author.setVisibility(View.VISIBLE);
            holder.tv_author.setText(author.getName());
        } else {
            holder.tv_author.setVisibility(View.GONE);
        }

        ItemCollection.DataBean.HeaderBean.LabelBean label = (ItemCollection.DataBean.HeaderBean.LabelBean) data.getLabel();
        if (null != label) {
            holder.tv_promotion.setVisibility(View.VISIBLE);
            String text = (String) label.getText();
            holder.tv_promotion.setText(text);
        } else {
            holder.tv_promotion.setVisibility(View.GONE);
        }
        //设置背景图片
        ImageUtil.setImage(context, data.getCover().getFeed(), holder.iv_select_cover);
        //位置监听
        itemView.setOnClickListener(new View.OnClickListener() {
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
}


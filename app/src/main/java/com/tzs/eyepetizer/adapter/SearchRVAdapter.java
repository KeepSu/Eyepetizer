package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.entity.Search;
import com.tzs.eyepetizer.util.ImageUtil;
import com.tzs.eyepetizer.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * 搜索页面的RV适配器
 */
public class SearchRVAdapter extends RecyclerView.Adapter<AuthorDatailRVAdapter.MyViewHolder>{
    private Context context;
    private List<Search.ItemListBeanX.DataBeanX.ItemListBean> lists=new ArrayList<>();
    public SearchRVAdapter(Context context) {
        this.context = context;
    }
    public void setList(List<Search.ItemListBeanX.DataBeanX.ItemListBean> list) {
        this.lists = list;
        notifyDataSetChanged();
    }

    @Override
    public AuthorDatailRVAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_select_video, parent, false);
        return new AuthorDatailRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AuthorDatailRVAdapter.MyViewHolder holder, int position) {

        Search.ItemListBeanX.DataBeanX.ItemListBean.DataBean data = lists.get(position).getData();
        //设置标题
        holder.tv_title.setText(data.getTitle());
        Log.i("==","==title=="+data.getTitle());
        //设置类型
        int duration = data.getDuration();
        holder.tv_category_duration.setText("#"+data.getCategory()+" / "
                + TimeUtil.getDurnig(duration));
        Log.i("==","==type=="+"#"+data.getCategory()+" / "
                + TimeUtil.getDurnig(duration));
        //设置作者名字
        holder.tv_author.setText(data.getAuthor().getName());
        Log.i("==","==name=="+data.getAuthor().getName());
        //设置背景图片
        ImageUtil.setImage(context,data.getCover().getFeed(),holder.iv_select_cover);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}


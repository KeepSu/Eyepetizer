package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.entity.select.ItemCollection;
import com.tzs.eyepetizer.util.ImageUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by h on 2017/1/3.
 */

public class AuthorSetAdapter extends RecyclerView.Adapter {

    private final LayoutInflater inflater;
    private Context context;
    private List<String> iconList;

    public AuthorSetAdapter(Context context, List<String> iconList) {
        this.context = context;
        this.iconList = iconList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_videoset_author, parent, false);
        return new AuthorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AuthorViewHolder viewHolder = ((AuthorViewHolder) holder);
        ImageUtil.setCircleImage(context, iconList.get(position), viewHolder.iv_author);
    }

    @Override
    public int getItemCount() {
        Log.e("=========>", "====iconList===>" + iconList.size());
        return iconList.size();
    }

    /**
     * 模板类
     */
    static class AuthorViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_author)
        ImageView iv_author;

        public AuthorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

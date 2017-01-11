package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.BaseActivity;
import com.tzs.eyepetizer.activity.VideoInfoActivity;
import com.tzs.eyepetizer.entity.Panoramic;
import com.tzs.eyepetizer.util.ImageUtil;
import com.tzs.eyepetizer.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TZS on 2017/1/11.
 */

public class PanoramicAdapter extends RecyclerView.Adapter<SelectAdapter.VideoHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Panoramic.ItemListBean> mData = new ArrayList<>();

    public void setList(List<Panoramic.ItemListBean> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    public PanoramicAdapter(Context context) {
        this.mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public SelectAdapter.VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_select_video, parent, false);
        return new SelectAdapter.VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(final SelectAdapter.VideoHolder holder, int position) {
        final Panoramic.ItemListBean.DataBean data = mData.get(position).getData();
        holder.tv_title.setText(data.getTitle());
        holder.tv_category_duration.setText("#" + data.getCategory() + " / " + TimeUtil.getDurnig(data.getDuration()));
        ImageUtil.setImage(mContext, data.getCover().getFeed(), holder.iv_select_cover, ImageUtil.SIZE_NORMAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.iv_select_cover.setTransitionName(data.getId() + "");
        }
        if (data.getAuthor() != null) {
            holder.tv_author.setVisibility(View.VISIBLE);
            holder.tv_author.setText(data.getAuthor().getName());
        } else {
            holder.tv_author.setVisibility(View.GONE);
        }
        if (data.getLabel() == null) {
            holder.tv_promotion.setVisibility(View.GONE);
        } else {
            holder.tv_promotion.setVisibility(View.VISIBLE);
            holder.tv_promotion.setText(data.getLabel().getText());
        }

        holder.ly_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) mContext).goToAnotherActivity(
                        VideoInfoActivity.class, data, holder.iv_select_cover, data.getId() + "");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}

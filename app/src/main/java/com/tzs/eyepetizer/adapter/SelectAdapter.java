package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.entity.select.SelectItem;
import com.tzs.eyepetizer.entity.select.TextFooter;
import com.tzs.eyepetizer.entity.select.VideoBeanForClient;
import com.tzs.eyepetizer.util.ImageUtil;
import com.tzs.eyepetizer.util.TimeUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 精选页面列表的适配器
 */

public class SelectAdapter extends RecyclerView.Adapter {

    private static final int VIDEO = 1;
    private static final int TEXTFOOTER = 2;
    private static final int TEXTHEADER = 3;
    private static final int VIDEO_COLLECTION_WITH_COVER = 4;
    private static final int VIDEO_COLLECTION_OF_FOLLOW = 5;

    private List<SelectItem> list;
    private Context context;
    private final LayoutInflater inflater;

    public SelectAdapter(List<SelectItem> list, Context context) {
        inflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
    }

    /**
     * 加载布局
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType) {
            case VIDEO:
                itemView = inflater.inflate(R.layout.item_select_video, parent, false);
                return new VideoHolder(itemView);
            case TEXTFOOTER:
                itemView = inflater.inflate(R.layout.item_select_textfooter, parent, false);
                return new VideoHolder(itemView);
            case TEXTHEADER:
                itemView = inflater.inflate(R.layout.item_select_textheader, parent, false);
                return new VideoHolder(itemView);
            case VIDEO_COLLECTION_WITH_COVER:
                itemView = inflater.inflate(R.layout.item_select_viewset_with_cover, parent, false);
                return new VideoHolder(itemView);
            case VIDEO_COLLECTION_OF_FOLLOW:
                itemView = inflater.inflate(R.layout.item_select_videoset_of_follow, parent, false);
                return new VideoHolder(itemView);
        }
        return null;
    }

    /**
     * 设置数据
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SelectItem selectItem = list.get(position);
        String type = selectItem.getType();
        switch (type) {
            case "video":
                final VideoHolder videoHolder = ((VideoHolder) holder);
                VideoBeanForClient.DataBean data = ((VideoBeanForClient) selectItem).getData();
                videoHolder.tv_title.setText(data.getTitle());
                videoHolder.tv_category_duration.setText("#" + data.getCategory() + " / " + TimeUtil.getDurnig(data.getDuration()));
                ImageUtil.setImage(context, data.getCover().getFeed(), videoHolder.iv_select_cover);
                videoHolder.ly_video.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        videoHolder.ly_video.setVisibility(View.GONE);
                        return false;
                    }
                });
                break;
            case "textFooter":
                Log.e("=============>", "============>");
                TextFooterHolder footerHolder = ((TextFooterHolder) holder);
                TextFooter.DataBean mTextFooter = ((TextFooter) selectItem).getData();
                footerHolder.tv_footer.setText(mTextFooter.getText());
                break;
            case "videoCollectionWithCover":
                break;
            case "textHeader":
                break;
            case "videoCollectionOfFollow":
                break;
        }
    }

    /**
     * 获取类型
     */
    @Override
    public int getItemViewType(int position) {
        String type = list.get(position).getType();
        switch (type) {
            case "video":
                return VIDEO;
            case "textFooter":
                return TEXTFOOTER;
            case "textHeader":
                return TEXTHEADER;
            case "videoCollectionWithCover":
                return VIDEO_COLLECTION_WITH_COVER;
            case "videoCollectionOfFollow":
                return VIDEO_COLLECTION_OF_FOLLOW;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * video的模板类
     */
    static class VideoHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_select_cover)
        ImageView iv_select_cover;
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_category_duration)
        TextView tv_category_duration;
        @BindView(R.id.tv_author)
        TextView tv_author;
        @BindView(R.id.tv_promotion)
        TextView tv_promotion;
        @BindView(R.id.ly_video)
        LinearLayout ly_video;

        VideoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * TextFooter的模板类
     */
    static class TextFooterHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_footer)
        TextView tv_footer;
        @BindView(R.id.ly_for_more)
        LinearLayout ly_for_more;

        public TextFooterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * TextHeader的模板类
     */
    static class TextHeadterHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_header)
        TextView tv_footer;

        public TextHeadterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * ViderSetWithCover的模板类
     */
    static class ViderSetWithCoverHolder extends RecyclerView.ViewHolder {

        public ViderSetWithCoverHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * ViderSetOfFollow的模板类
     */
    static class ViderSetOfFollowHolder extends RecyclerView.ViewHolder {

        public ViderSetOfFollowHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

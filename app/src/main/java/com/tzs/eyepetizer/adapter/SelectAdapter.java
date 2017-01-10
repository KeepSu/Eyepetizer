package com.tzs.eyepetizer.adapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.AllAuthorActivity;
import com.tzs.eyepetizer.activity.AllClassifyActivity;
import com.tzs.eyepetizer.activity.AuthorDetailActivity;
import com.tzs.eyepetizer.activity.BaseActivity;
import com.tzs.eyepetizer.activity.DailyActivity;
import com.tzs.eyepetizer.activity.VideoInfoActivity;
import com.tzs.eyepetizer.activity.WebActivity;
import com.tzs.eyepetizer.entity.select.Banner;
import com.tzs.eyepetizer.entity.select.ItemCollection;
import com.tzs.eyepetizer.entity.select.SelectItem;
import com.tzs.eyepetizer.entity.select.TextFooter;
import com.tzs.eyepetizer.entity.select.TextHeader;
import com.tzs.eyepetizer.entity.select.VideoBeanForClient;
import com.tzs.eyepetizer.util.DecodeUtil;
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
    private static final int BANNER = 6;
    private static final int AUTHOR_WITH_COVER = 7;

    private List<SelectItem> list;
    private Context context;
    private final LayoutInflater inflater;

    public SelectAdapter(List<SelectItem> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    /**
     * 加载布局
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        switch (viewType) {
            case VIDEO:
                itemView = inflater.inflate(R.layout.item_select_video, parent, false);
                return new VideoHolder(itemView);
            case TEXTFOOTER:
                itemView = inflater.inflate(R.layout.item_select_textfooter, parent, false);
                return new TextFooterHolder(itemView);
            case TEXTHEADER:
                itemView = inflater.inflate(R.layout.item_select_textheader, parent, false);
                return new TextHeaderHolder(itemView);
            case VIDEO_COLLECTION_WITH_COVER:
                itemView = inflater.inflate(R.layout.item_select_viewset_with_cover, parent, false);
                return new VideoSetWithCoverHolder(itemView);
            case VIDEO_COLLECTION_OF_FOLLOW:
                itemView = inflater.inflate(R.layout.item_select_videoset_of_follow, parent, false);
                return new VideoSetOfFollowHolder(itemView);
            case BANNER:
                itemView = inflater.inflate(R.layout.item_select_banner, parent, false);
                return new BannerHolder(itemView);
            case AUTHOR_WITH_COVER:
                itemView = inflater.inflate(R.layout.item_select_author_with_cover, parent, false);
                return new AuthorWithCoverHolder(itemView);
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
                showDataType1((VideoHolder) holder, ((VideoBeanForClient) selectItem).getData());
                break;
            case "textFooter":
                showDataType2(((TextFooterHolder) holder), ((TextFooter) selectItem).getData());
                break;
            case "videoCollectionWithCover":
                showDataType3(((VideoSetWithCoverHolder) holder), ((ItemCollection) selectItem).getData());
                break;
            case "textHeader":
                showDataType4(((TextHeaderHolder) holder), ((TextHeader) selectItem).getData());
                break;
            case "videoCollectionOfFollow":
                showDataType5(((VideoSetOfFollowHolder) holder), ((ItemCollection) selectItem).getData());
                break;
            case "banner":
                showDataType6(((BannerHolder) holder), ((Banner) selectItem).getData());
                break;
            case "videoCollectionOfAuthorWithCover":
                showDataType7(((AuthorWithCoverHolder) holder), ((ItemCollection) selectItem).getData());
                break;
            default:
                break;
        }
    }

    /**
     * 展示AuthorWithCover布局的数据
     */
    private void showDataType7(AuthorWithCoverHolder holder, final ItemCollection.DataBean data) {
        ImageUtil.setImage(context, data.getHeader().getCover(), holder.iv_author_video_cover);
        ImageUtil.setCircleImage(context, data.getHeader().getIcon(), holder.iv_author_video_head);
        holder.tv_author_name.setText(data.getHeader().getTitle());
        holder.tv_author_description.setText(data.getHeader().getDescription());
        LinearLayoutManager manager4 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        VideoSetAdapter videoSetAdapter3 = new VideoSetAdapter(context, data.getItemList());
        holder.rv_video_set.setLayoutManager(manager4);
        holder.rv_video_set.setAdapter(videoSetAdapter3);
        holder.iv_author_video_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AuthorDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id", data.getHeader().getId());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    /**
     * 展示Banner布局的数据
     */
    private void showDataType6(BannerHolder holder, Banner.DataBean data) {
        ImageUtil.setImage(context, data.getImage(), holder.iv_banner, ImageUtil.SIZE_NORMAL);
        holder.iv_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) context).goToAnotherActivity(AllClassifyActivity.class);
            }
        });
    }

    /**
     * 展示VideoSetOfFollow布局的数据
     */
    private void showDataType5(VideoSetOfFollowHolder holder, ItemCollection.DataBean data) {
        ImageUtil.setImage(context, data.getHeader().getCover(), holder.iv_set_cover, ImageUtil.SIZE_NORMAL);
        holder.tv_title.setText(data.getHeader().getTitle());
        holder.tv_description.setText(data.getHeader().getDescription());

        LinearLayoutManager manager2 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        VideoSetAdapter videoSetAdapter2 = new VideoSetAdapter(context, data.getItemList());
        holder.rv_video_set.setLayoutManager(manager2);
        holder.rv_video_set.setAdapter(videoSetAdapter2);

        LinearLayoutManager manager3 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        AuthorSetAdapter authorSetAdapter = new AuthorSetAdapter(context, data.getHeader().getIconList());
        holder.rv_author.setLayoutManager(manager3);
        holder.rv_author.setAdapter(authorSetAdapter);

        holder.iv_set_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, AllAuthorActivity.class));
            }
        });
    }

    /**
     * 展示TextHeader布局的数据
     */
    private void showDataType4(TextHeaderHolder holder, TextHeader.DataBean data) {
        holder.tv_header.setText(data.getText());
    }

    /**
     * 展示VideoSetWithCover布局的数据
     */
    private void showDataType3(VideoSetWithCoverHolder holder, final ItemCollection.DataBean data) {
        ImageUtil.setImage(context, data.getHeader().getCover(), holder.iv_set_cover, ImageUtil.SIZE_NORMAL);
        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        VideoSetAdapter videoSetAdapter = new VideoSetAdapter(context, data.getItemList());
        holder.rv_video_set.setLayoutManager(manager);
        holder.rv_video_set.setAdapter(videoSetAdapter);
        holder.iv_set_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String actionUrl = DecodeUtil.StringDecode(data.getHeader().getActionUrl());
                String[] a = actionUrl.split("title=")[1].split("&url=");
                String webTitle = a[0];
                String webUrl = a[1];
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("webTitle", webTitle);
                intent.putExtra("webUrl", webUrl);
                context.startActivity(intent);
            }
        });
    }

    /**
     * 展示TextFooter布局的数据
     */
    private void showDataType2(TextFooterHolder holder, TextFooter.DataBean data) {
        holder.tv_footer.setText(data.getText());
        holder.tv_footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    context.startActivity(new Intent(context, DailyActivity.class),
                            ActivityOptions.makeSceneTransitionAnimation((BaseActivity) context).toBundle());
                } else {
                    context.startActivity(new Intent(context, DailyActivity.class));
                }
            }
        });
    }

    /**
     * 展示video布局的数据
     */
    private void showDataType1(final VideoHolder holder, final VideoBeanForClient.DataBean data) {
        holder.tv_title.setText(data.getTitle());
        holder.tv_category_duration.setText("#" + data.getCategory() + " / " + TimeUtil.getDurnig(data.getDuration()));
        ImageUtil.setImage(context, data.getCover().getFeed(), holder.iv_select_cover, ImageUtil.SIZE_NORMAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.iv_select_cover.setTransitionName(data.getId() + "");
        }
        if (data.getAuthor() != null) {
            holder.tv_author.setVisibility(View.VISIBLE);
            holder.tv_author.setText(data.getAuthor().getName());
        } else {
            holder.tv_author.setVisibility(View.GONE);
        }
        //TODO
        if (data.getPromotion() == null) {
            holder.tv_promotion.setVisibility(View.GONE);
        } else if (data.getPromotion().getText().equals("广告")) {
            holder.tv_promotion.setVisibility(View.VISIBLE);
            holder.tv_promotion.setText("广告");
        } else {
            holder.tv_promotion.setVisibility(View.VISIBLE);
            holder.tv_promotion.setText("360°全景");
        }

        holder.ly_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) context).goToAnotherActivity(
                        VideoInfoActivity.class, data, holder.iv_select_cover, data.getId() + "");
            }
        });
//        holder.ly_video.setOnClickListener(this);
//        holder.ly_video.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        AnimaUtil.disappear(1000, holder.ly_video);
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        AnimaUtil.appear(1000, holder.ly_video);
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        AnimaUtil.appear(1000, holder.ly_video);
//                        break;
//                }
//                return false;
//            }
//        });
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
            case "banner":
                return BANNER;
            case "videoCollectionOfAuthorWithCover":
                return AUTHOR_WITH_COVER;
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
        RelativeLayout ly_video;

        VideoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 广告的模板类
     */
    static class BannerHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_banner)
        ImageView iv_banner;

        BannerHolder(View itemView) {
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
    static class TextHeaderHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_header)
        TextView tv_header;

        TextHeaderHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * ViderSetWithCover的模板类
     */
    static class VideoSetWithCoverHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_set_cover)
        ImageView iv_set_cover;
        @BindView(R.id.rv_video_set)
        RecyclerView rv_video_set;

        VideoSetWithCoverHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * ViderSetOfFollow的模板类
     */
    static class VideoSetOfFollowHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_set_cover)
        ImageView iv_set_cover;
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_description)
        TextView tv_description;
        @BindView(R.id.rv_author)
        RecyclerView rv_author;
        @BindView(R.id.rv_video_set)
        RecyclerView rv_video_set;

        public VideoSetOfFollowHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * AuthorWithCoverHolder的模板类
     */
    static class AuthorWithCoverHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_author_video_cover)
        ImageView iv_author_video_cover;
        @BindView(R.id.iv_author_video_head)
        ImageView iv_author_video_head;
        @BindView(R.id.tv_author_name)
        TextView tv_author_name;
        @BindView(R.id.tv_author_description)
        TextView tv_author_description;
        @BindView(R.id.tv_follow_author)
        TextView tv_follow_author;
        @BindView(R.id.rv_video_set)
        RecyclerView rv_video_set;

        public AuthorWithCoverHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

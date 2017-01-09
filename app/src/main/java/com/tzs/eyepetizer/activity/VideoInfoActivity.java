package com.tzs.eyepetizer.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.entity.select.VideoBeanForClient;
import com.tzs.eyepetizer.util.ImageUtil;
import com.tzs.eyepetizer.util.TimeUtil;
import com.tzs.eyepetizer.view.PrinterTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoInfoActivity extends BaseActivity {

    @BindView(R.id.iv_cover)
    ImageView iv_cover;
    @BindView(R.id.iv_back)
    ImageView iv_back;

    @BindView(R.id.tv_title)
    PrinterTextView tv_title;
    @BindView(R.id.tv_during)
    PrinterTextView tv_during;
    @BindView(R.id.tv_description)
    PrinterTextView tv_description;
    @BindView(R.id.iv_find_more)
    ImageView iv_find_more;
    @BindView(R.id.ly_detail)
    LinearLayout ly_detail;
    @BindView(R.id.iv_bg)
    ImageView iv_bg;

    @BindView(R.id.ly_author)
    LinearLayout ly_author;

    @BindView(R.id.iv_author)
    ImageView iv_author;
    @BindView(R.id.tv_author)
    PrinterTextView tv_author;
    @BindView(R.id.tv_author_detail)
    PrinterTextView tv_author_detail;
    @BindView(R.id.tv_follow)
    TextView tv_follow;

    @BindView(R.id.tv_like)
    TextView tv_like;
    @BindView(R.id.tv_share)
    TextView tv_share;
    @BindView(R.id.tv_feed)
    TextView tv_feed;
    @BindView(R.id.tv_cache)
    TextView tv_cache;

    @BindView(R.id.ly_like)
    LinearLayout ly_like;
    @BindView(R.id.ly_share)
    LinearLayout ly_share;
    @BindView(R.id.ly_feed)
    LinearLayout ly_feed;
    @BindView(R.id.ly_cache)
    LinearLayout ly_cache;

    private VideoBeanForClient.DataBean mVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_info);
        initState();
        ButterKnife.bind(this);
        mVideo = (VideoBeanForClient.DataBean) getIntent().getSerializableExtra("object");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            iv_cover.setTransitionName(mVideo.getId() + "");
        }
        showData();
    }

    @Override
    protected void showData() {
        ImageUtil.setImage(this, mVideo.getCover().getFeed(), iv_cover, ImageUtil.SIZE_MAX);
        tv_title.setPrintText(mVideo.getTitle());
        tv_during.setPrintText(mVideo.getCategory() + " / " + TimeUtil.getDurnig(mVideo.getDuration()));
        tv_description.setPrintText(mVideo.getDescription());
        ImageUtil.setImage(this, mVideo.getCover().getBlurred(), iv_bg, ImageUtil.SIZE_NORMAL);
        tv_like.setText(mVideo.getConsumption().getCollectionCount() + "");
        tv_share.setText(mVideo.getConsumption().getShareCount() + "");
        tv_feed.setText(mVideo.getConsumption().getReplyCount() + "");
        if (mVideo.getAuthor() == null) {
            ly_author.setVisibility(View.GONE);
        } else {
            ly_author.setVisibility(View.VISIBLE);
            VideoBeanForClient.DataBean.AuthorBean author = mVideo.getAuthor();
            ImageUtil.setCircleImage(this, mVideo.getAuthor().getIcon(), iv_author);
            tv_author.setPrintText(author.getName());
            tv_author_detail.setPrintText(author.getDescription());
        }
    }
}

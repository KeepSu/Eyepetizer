package com.tzs.eyepetizer.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mob.commons.SHARESDK;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.constant.NetState;
import com.tzs.eyepetizer.entity.select.VideoBeanForClient;
import com.tzs.eyepetizer.util.AnimaUtil;
import com.tzs.eyepetizer.util.ImageUtil;
import com.tzs.eyepetizer.util.NetStateUtil;
import com.tzs.eyepetizer.util.TimeUtil;
import com.tzs.eyepetizer.view.PrinterTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

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
        if (mVideo != null) {
            showData();
        }
//        TimeUtil.getDateToday();
    }

    /**
     * 展示数据
     */
    @Override
    protected void showData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            iv_cover.setTransitionName(mVideo.getId() + "");
        }
        ImageUtil.setImage(this, mVideo.getCover().getFeed(), iv_cover, ImageUtil.SIZE_MAX);
        AnimaUtil.scale(5000, iv_cover);

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

    @OnClick({R.id.iv_cover, R.id.ly_author, R.id.iv_back, R.id.iv_find_more, R.id.ly_share})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_cover:
                playVideo();
                break;
            case R.id.ly_author:
                lookAuthor();
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_find_more:
                transition(RelatedActivity.class, mVideo.getId() + "");
                break;
            case R.id.ly_share:
                shoShare();
                break;
        }
    }

    private void shoShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle(mVideo.getTitle());
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl(mVideo.getWebUrl().getRaw());
// text是分享文本，所有平台都需要这个字段
        oks.setText(mVideo.getDescription());
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(mVideo.getWebUrl().getRaw());
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("开眼");
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(mVideo.getWebUrl().getRaw());

// 启动分享GUI
        oks.show(this);
    }

    /**
     * 查看作者
     */
    private void lookAuthor() {
        Intent intent = new Intent(this, AuthorDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id", mVideo.getAuthor().getId());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 播放视频
     */
    private void playVideo() {
        int netStateState = NetStateUtil.getNetStateState(VideoInfoActivity.this);
        switch (netStateState) {
            case NetState.STATE_NONE:
                showToast("当前未连接到网络 -_-||");
                break;
            case NetState.STATE_WIFI:
                goToAnotherActivity(PlayActivity.class, mVideo.getPlayUrl(), mVideo.getTitle());
                break;
            default:
                new AlertDialog.Builder(VideoInfoActivity.this)
                        .setTitle("是否使用流量播放视屏")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                goToAnotherActivity(PlayActivity.class, mVideo.getPlayUrl(), mVideo.getTitle());
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                break;
        }
    }
}

package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.WebActivity;
import com.tzs.eyepetizer.entity.Discover;
import com.tzs.eyepetizer.util.DecodeUtil;
import com.tzs.eyepetizer.util.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TZS on 2016/12/29.
 */

public class DiscoverAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Discover.ItemListBeanX> mData = new ArrayList<>();

    private static final int HORIZONTALSCROLLCARD = 1;//已经直接写在DiscoverFragment中了
    private static final int SQUARECARDCOLLECTION = 2;
    private static final int BANNERCOLLECTION = 3;
    private static final int VIDEOCOLLECTION = 4;

    private int mCount;//热门专题处的icon要有的个数
    private int mCount1;//后面的分类里的icon要有的个数

    public void setList(List<Discover.ItemListBeanX> data) {
        this.mData.addAll(data);
        notifyDataSetChanged();
    }

    public DiscoverAdapter(Context context) {
        this.mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == HORIZONTALSCROLLCARD) {
            view = mInflater.inflate(R.layout.item_discover_scroll_card, parent, false);
            return new ScrollCardViewHolder(view);
        } else if (viewType == SQUARECARDCOLLECTION) {
            view = mInflater.inflate(R.layout.item_discover_square_card, parent, false);
            return new SquareCardViewHolder(view);
        } else if (viewType == BANNERCOLLECTION){
            view = mInflater.inflate(R.layout.item_discover_banner_collection, parent, false);
            return new BannerCollectionViewHolder(view);
        } else if (viewType == VIDEOCOLLECTION) {
            view = mInflater.inflate(R.layout.item_discover_classify, parent, false);
            return new VideoCollectionViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Discover.ItemListBeanX.DataBeanX data = mData.get(position).getData();
        final List<Discover.ItemListBeanX.DataBeanX.ItemListBean> itemList = data.getItemList();
        switch (getItemViewType(position)) {
            case HORIZONTALSCROLLCARD:
                ScrollCardViewHolder scrollCardViewHolder = (ScrollCardViewHolder) holder;
                List imageUrlList = new ArrayList();
                for (int i = 0; i < data.getCount(); i++) {
                    String imageUrl = data.getItemList().get(i).getData().getImage();
                    imageUrlList.add(imageUrl);
                }
                scrollCardViewHolder.banner
                        .setImageLoader(new GlideImageLoader())//设置图片加载器
                        .setImages(imageUrlList)//添加图片路径的list
                        .setDelayTime(2000)//设置轮播时间
                        .start();//开始自动播放
                scrollCardViewHolder.banner.setOnBannerClickListener(new OnBannerClickListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        String actionUrl = DecodeUtil.StringDecode(itemList.get(position-1).getData().getActionUrl());
                        String[] a = actionUrl.split("title=")[1].split("&url=");
                        String webTitle = a[0];
                        String webUrl = a[1];
                        Intent intent = new Intent(mContext, WebActivity.class);
                        intent.putExtra("webTitle", webTitle);
                        intent.putExtra("webUrl", webUrl);
                        mContext.startActivity(intent);
                    }
                });
                break;
            case SQUARECARDCOLLECTION:
                SquareCardViewHolder squareCardviewHolder = (SquareCardViewHolder) holder;
                squareCardviewHolder.title_Discover.setText(data.getHeader().getTitle());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,
                        LinearLayoutManager.HORIZONTAL, false);
                squareCardviewHolder.recyclerView_inner.setLayoutManager(linearLayoutManager);
                //判断是热门分类id=1、热门排行id=2、还是推荐作者id=3的内容，来设置不同的adapter
                int id = data.getHeader().getId();
                if (id == 1) {
                    DiscoverHotClassifyAdapter dhcAdapter = new DiscoverHotClassifyAdapter(mContext);
                    squareCardviewHolder.recyclerView_inner.setAdapter(dhcAdapter);
                    dhcAdapter.setList(itemList);
                } else if (id == 2) {
                    DiscoverHotRankAdapter dhrAdapter = new DiscoverHotRankAdapter(mContext);
                    squareCardviewHolder.recyclerView_inner.setAdapter(dhrAdapter);
                    dhrAdapter.setList(itemList);
                }else if (id == 3) {
                    DiscoverRecommendAuthorAdapter draAdapter = new DiscoverRecommendAuthorAdapter(mContext);
                    squareCardviewHolder.recyclerView_inner.setAdapter(draAdapter);
                    draAdapter.setList(itemList);
                }
                break;
            case BANNERCOLLECTION:
                BannerCollectionViewHolder bcViewHolder = (BannerCollectionViewHolder) holder;
                bcViewHolder.title_discover.setText(data.getHeader().getTitle());
                List imageUrls = new ArrayList();
                mCount = data.getCount();
                for (int i = 0; i < data.getCount(); i++) {
                    String imageUrl = data.getItemList().get(i).getData().getImage();
                    imageUrls.add(imageUrl);
                }
                imageAdapter imgAdapter = new imageAdapter(imageUrls, mContext);
                bcViewHolder.vp_coll.setOffscreenPageLimit(mCount);
                bcViewHolder.vp_coll.setPageMargin(12);
                bcViewHolder.vp_coll.setAdapter(imgAdapter);
                bcViewHolder.vp_coll.setCurrentItem(Integer.MAX_VALUE/2);//设置viewpager要展示页面的第一个位置
                //热门专题 处的 页面改变监听事件
                bcViewHolder.vp_coll.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        setIcon(position % mCount);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });//热门专题 处的 页面改变监听事件
                setIcon(0);//设置指示器
                break;
            case VIDEOCOLLECTION:
                VideoCollectionViewHolder vcViewHolder = (VideoCollectionViewHolder) holder;
                vcViewHolder.classify_title.setText(data.getHeader().getTitle());
                vcViewHolder.classify_text.setText(data.getHeader().getSubTitle());
                mCount1 = data.getCount();
                DiscoverClassifyAdapter dcAdapter = new DiscoverClassifyAdapter(mContext, itemList);
                vcViewHolder.vp_classify.setOffscreenPageLimit(mCount1);
                vcViewHolder.vp_classify.setPageMargin(12);
                vcViewHolder.vp_classify.setAdapter(dcAdapter);
                vcViewHolder.vp_classify.setCurrentItem(Integer.MAX_VALUE/2);//设置viewpager要展示页面的第一个位置
                vcViewHolder.vp_classify.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        setIcon1(position % mCount1);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
                setIcon1(0);
                break;
            default:
                break;
        }
    }

    //设置热门专题处的viewpagaer下方的指示小点
    private void setIcon(int curPosition){
        ImageView img = null;
        coll_Icons.removeAllViews();
        for (int i = 0; i < mCount; i++) {
            img = new ImageView(mContext);
            img.setLayoutParams(new LinearLayout.LayoutParams(70,70));
            if (i == curPosition){
                img.setImageResource(R.drawable.ic_x_recycler_view_pager_indicator_focus);
            } else {
                img.setImageResource(R.drawable.ic_x_recycler_view_pager_indicator);
            }
            coll_Icons.addView(img);
        }
    }

    //设置 下面的部分分类 处的viewpagaer下方的指示小点
    private void setIcon1(int curPosition){
        ImageView img = null;
        classify_Icons.removeAllViews();
        for (int i = 0; i < mCount1; i++) {
            img = new ImageView(mContext);
            img.setLayoutParams(new LinearLayout.LayoutParams(70,70));
            if (i == curPosition){
                img.setImageResource(R.drawable.ic_x_recycler_view_pager_indicator_focus);
            } else {
                img.setImageResource(R.drawable.ic_x_recycler_view_pager_indicator);
            }
            classify_Icons.addView(img);
        }
    }

    //发现页面的getItemCount
    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * 顶部
     * type：horizontalScrollCard的ViewHolder
     */
    static class ScrollCardViewHolder extends RecyclerView.ViewHolder{
        private Banner banner;
        public ScrollCardViewHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
        }
    }

    /**
     * 中部
     * type：squareCardCollection的ViewHolder
     */
    static class SquareCardViewHolder extends RecyclerView.ViewHolder{
        private TextView title_Discover;
        private RecyclerView recyclerView_inner;
        public SquareCardViewHolder(View itemView) {
            super(itemView);
            title_Discover = (TextView) itemView.findViewById(R.id.title_Discover);
            recyclerView_inner = (RecyclerView) itemView.findViewById(R.id.recyclerView_inner);
        }
    }

    /**
     * 下部
     * type：bannerCollection的ViewHolder
     */
    private LinearLayout coll_Icons;
    class BannerCollectionViewHolder extends RecyclerView.ViewHolder{
        private TextView title_discover;
        private ViewPager vp_coll;
        public BannerCollectionViewHolder(View itemView) {
            super(itemView);
            title_discover = (TextView) itemView.findViewById(R.id.title_Discover);
            vp_coll = (ViewPager) itemView.findViewById(R.id.vp_coll);
            coll_Icons = (LinearLayout) itemView.findViewById(R.id.coll_Icons);
        }
    }

    private LinearLayout classify_Icons;
    class VideoCollectionViewHolder extends RecyclerView.ViewHolder {
        private ViewPager vp_classify;
        private TextView classify_title;
        private TextView classify_text;
        public VideoCollectionViewHolder(View itemView) {
            super(itemView);
            classify_Icons = (LinearLayout) itemView.findViewById(R.id.classify_Icons);
            classify_title = (TextView) itemView.findViewById(R.id.classify_title);
            classify_text = (TextView) itemView.findViewById(R.id.classify_text);
            vp_classify = (ViewPager) itemView.findViewById(R.id.vp_classify);
        }
    }

    @Override
    public int getItemViewType(int position) {
        String type = mData.get(position).getType();
        if (type.equals("horizontalScrollCard")) {
            return HORIZONTALSCROLLCARD;
        } else if (type.equals("squareCardCollection")) {
            return SQUARECARDCOLLECTION;
        } else if (type.equals("bannerCollection")) {
            return BANNERCOLLECTION;
        } else if (type.equals("videoCollectionOfHorizontalScrollCard")) {
            return VIDEOCOLLECTION;
        }
        return 0;
    }
}

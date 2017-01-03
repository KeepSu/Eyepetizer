package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.entity.Discover;
import com.tzs.eyepetizer.util.GlideImageLoader;
import com.youth.banner.Banner;

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

    public void setList(List<Discover.ItemListBeanX> data) {
        this.mData = data;
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
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Discover.ItemListBeanX.DataBeanX data = mData.get(position).getData();
        List<Discover.ItemListBeanX.DataBeanX.ItemListBean> itemList = mData.get(position).getData().getItemList();
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
                        .setImages(imageUrlList)//设置图片list集合
                        .start();//banner设置方法全部调用完毕时最后调用
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
//            case BANNERCOLLECTION:
//                BannerCollectionViewHolder bcviewHolder = (BannerCollectionViewHolder) holder;
//                break;
            default:
                break;
        }
    }

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
    static class BannerCollectionViewHolder extends RecyclerView.ViewHolder{

        public BannerCollectionViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Discover.ItemListBeanX item = mData.get(position);
        String type = item.getType();
        if (type.equals("horizontalScrollCard")) {
            return HORIZONTALSCROLLCARD;
        } else if (type.equals("squareCardCollection")) {
            return SQUARECARDCOLLECTION;
        } else if (type.equals("bannerCollection")) {
            return BANNERCOLLECTION;
        }
        return 0;
    }
}

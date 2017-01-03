package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.entity.Follow;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.view.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2016/12/29.
 */
public class FollowRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int FOLLOW_AUTHOR=1;
    private static final int FOLLOW_TYPE=2;
    private static final int FOLLOW_ATTENTION=3;
    private Context context;
    private LayoutInflater inflater;
    private List<Follow.ItemListBeanX> list=new ArrayList<>();
    public void setList(List<Follow.ItemListBeanX> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public FollowRVAdapter(Context context) {
        this.context = context;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=null;
        switch (viewType){
            case FOLLOW_AUTHOR:
                itemView=inflater.inflate(R.layout.follow_author,parent,false);
                return new AuthorViewHolder(itemView);
            case FOLLOW_TYPE:
                itemView=inflater.inflate(R.layout.follow_type,parent,false);
                return new TypeViewHolder(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //获取头部信息
        Follow.ItemListBeanX.DataBeanX.HeaderBean header = list.get(position).getData().getHeader();
        //获取Item里面子Itemde数据
        List<Follow.ItemListBeanX.DataBeanX.ItemListBean> itemList = list.get(position).getData().getItemList();
        switch (getItemViewType(position)){
            case FOLLOW_AUTHOR:
                final AuthorViewHolder avh= (AuthorViewHolder) holder;
                avh.tv_nickName.setText(header.getTitle());
                avh.tv_description.setText(header.getDescription());
                Glide.with(context).load(header.getIcon()).asBitmap().centerCrop().
                                into(new BitmapImageViewTarget(avh.iv_portrait){
                                    @Override
                                    protected void setResource(Bitmap resource) {
                                        RoundedBitmapDrawable circularBitmapDrawable =
                                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                                        circularBitmapDrawable.setCircular(true);
                                        avh.iv_portrait.setImageDrawable(circularBitmapDrawable);
                                    }
                                });
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,
                        LinearLayoutManager.HORIZONTAL, false);
                avh.rv_inner.setLayoutManager(linearLayoutManager);
                FollowRVInnerAdapter adapter=new FollowRVInnerAdapter(context);
                avh.rv_inner.setAdapter(adapter);
                adapter.setList(itemList);
                break;
            case FOLLOW_TYPE:
                TypeViewHolder tvh= (TypeViewHolder) holder;
                tvh.tv_type.setText(header.getTitle());
                tvh.tv_description.setText((String)header.getSubTitle());
                GlideImageLoader loader=new GlideImageLoader();
                Follow.ItemListBeanX.DataBeanX data = list.get(position).getData();
                List<String> imgePath=new ArrayList<>();
                List<String> titles=new ArrayList<>();
                for (int i = 0; i <data.getCount(); i++) {
                    imgePath.add(data.getItemList().get(i).getData().getCover().getFeed());
                    titles.add(data.getItemList().get(i).getData().getTitle());
                    Log.i("info","title"+data.getItemList().get(i).getData().getTitle());
                    //tvh.tv_content.setText(data.getItemList().get(i).getData().getTitle());
                }

                tvh.banner.setImageLoader(loader);
                tvh.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                tvh.banner.setImages(imgePath);
                tvh.banner.setBannerTitles(titles);
                tvh.banner.isAutoPlay(false);
                tvh.banner.start();
                break;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * 作者布局ViewHolder
     */
    static class AuthorViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_portrait)
        ImageView iv_portrait;
        @BindView(R.id.tv_nickName)
        TextView tv_nickName;
        @BindView(R.id.tv_description)
        TextView tv_description;
        @BindView(R.id.rv_inner)
        RecyclerView rv_inner;
        public AuthorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    /**
     * 类型布局ViewHolder
     */
    static class TypeViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_type)
        TextView tv_type;
        @BindView(R.id.tv_description)
        TextView tv_description;
        @BindView(R.id.banner)
        Banner banner;
        @BindView(R.id.iv_image)
        ImageView iv_image;
        @BindView(R.id.tv_content)
        TextView tv_content;
        @BindView(R.id.tv_playTime)
        TextView tv_playTime;
        public TypeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    /**
     * 自己关注布局ViewHolder
     */
    static class AttentionViewHolder extends RecyclerView.ViewHolder{

        public AttentionViewHolder(View itemView) {
            super(itemView);

        }
    }
    @Override
    public int getItemViewType(int position) {
        Follow.ItemListBeanX itemListBeanX = list.get(position);
        String type = itemListBeanX.getType();
        switch (type){
            case "videoCollectionWithBrief":
                return FOLLOW_AUTHOR;
            case "videoCollectionOfHorizontalScrollCard":
                return FOLLOW_TYPE;
        }
        return 0;
    }
    /**
     * 用于加载banner图片的类
     * 是由第三方中提供的
     */
    class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide 加载图片简单用法
            Glide.with(context).load(path).into(imageView);
        }
    }
}

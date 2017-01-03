package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.entity.Follow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */
public class FollowVPAdapter extends PagerAdapter{
    private List<Follow.ItemListBeanX> list=new ArrayList<>();
    private Context context;

    public FollowVPAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<Follow.ItemListBeanX> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Follow.ItemListBeanX.DataBeanX.ItemListBean.DataBean data = list.get(position).getData().getItemList().get(position).getData();
        ImageView imageView=new ImageView(context);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(200,150);
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.mipmap.ic_launcher);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }
}

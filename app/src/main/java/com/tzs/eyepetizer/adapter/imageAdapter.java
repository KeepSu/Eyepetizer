package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tzs.eyepetizer.activity.WebActivity;
import com.tzs.eyepetizer.entity.Discover;
import com.tzs.eyepetizer.util.DecodeUtil;
import com.tzs.eyepetizer.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TZS on 2017/1/3.
 */

public class imageAdapter extends PagerAdapter {
    private List<Discover.ItemListBeanX.DataBeanX.ItemListBean> data = new ArrayList();
    private Context mContext;

    public imageAdapter(List<Discover.ItemListBeanX.DataBeanX.ItemListBean> data, Context context) {
        this.data = data;
        mContext = context;
    }

    @Override
    public int getCount() {
//        return data.size();
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView img = new ImageView(mContext);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageUtil.setImage(mContext, data.get(position % data.size()).getData().getImage(), img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String actionUrl = DecodeUtil.StringDecode(data.get(position % data.size()).getData().getActionUrl());
                String[] a = actionUrl.split("title=")[1].split("&url=");
                String webTitle = a[0];
                String webUrl = a[1];
                Intent intent = new Intent(mContext, WebActivity.class);
                intent.putExtra("webTitle", webTitle);
                intent.putExtra("webUrl", webUrl);
                mContext.startActivity(intent);
            }
        });
        container.addView(img);
        return img;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}

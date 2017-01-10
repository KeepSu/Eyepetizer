package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.VideoInfoActivity;
import com.tzs.eyepetizer.entity.Discover;
import com.tzs.eyepetizer.util.ImageUtil;
import com.tzs.eyepetizer.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TZS on 2017/1/4.
 */

public class DiscoverClassifyAdapter extends PagerAdapter {
    private Context mContext;
    private List<Discover.ItemListBeanX.DataBeanX.ItemListBean> data = new ArrayList<>();

    public DiscoverClassifyAdapter(Context context, List<Discover.ItemListBeanX.DataBeanX.ItemListBean> data) {
        mContext = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_discover_classify_inner, null);
        ImageView img_classify = (ImageView) view.findViewById(R.id.img_classify);
        TextView tv_inner_title = (TextView) view.findViewById(R.id.tv_inner_title);
        TextView tv_inner_during = (TextView) view.findViewById(R.id.tv_inner_during);
        final LinearLayout intoVideoInfo = (LinearLayout) view.findViewById(R.id.intoVideoInfo);
        final int index = position % data.size();
        ImageUtil.setImage(mContext, data.get(index).getData().getCover().getFeed(), img_classify);
        tv_inner_title.setText(data.get(index).getData().getTitle());
        String str = "#"+data.get(index).getData().getCategory()
                +TimeUtil.getDurnig(data.get(index).getData().getDuration());
        tv_inner_during.setText(str);
        container.addView(view);

        intoVideoInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, VideoInfoActivity.class));
//                ((BaseActivity) mContext).goToAnotherActivity(
//                        VideoInfoActivity.class, data.get(index).getData(), intoVideoInfo, data.get(index).getData().getId()+"");
            }
        });

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}

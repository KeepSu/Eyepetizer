package com.tzs.eyepetizer.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.entity.Discover;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 发现页面
 */
public class DiscoverFragment extends Fragment {
    private static String path = "http://baobab.kaiyanapp.com/api/v4/tabs/discovery?";

    @BindView(R.id.banner)
    Banner banner;

    private List imageUrls = new ArrayList();//取出的banner图片地址的列表
    private Discover mDiscover;//解析出来的discover对象
    private List<Discover.ItemListBeanX> mItemList;//整体的list集合
    private List<Discover.ItemListBeanX.DataBeanX.ItemListBean> mItemListBeen;//每一条里面的list集合

    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        ButterKnife.bind(this, view);
        download();

        return view;
    }

    private void download() {
        OkHttpUtils.get(path).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                mDiscover = new Gson().fromJson(s, Discover.class);//解析出来的discover对象

                String nextPageUrl = mDiscover.getNextPageUrl();//下一页的地址
                mItemList = mDiscover.getItemList();//整体的list
                int count = mDiscover.getCount();
                imageUrls.clear();//确保每一次下载数据后，imageUrls集合首先是空的，再填充数据
                for (int i = 0; i < count; i++) {
                    mItemListBeen = mItemList.get(i).getData().getItemList();//每一条里面的list
                    for (int j = 0; j < mItemListBeen.size(); j++) {
                        String imageUrl = mItemListBeen.get(j).getData().getImage();
                        if (i == 0) {
                            imageUrls.add(imageUrl);
                            Log.e("===1111===", "===="+imageUrls.size()+"===="+imageUrl);
                        }
                    }
                }
                setBanner();
            }
        });
    }

    private void setBanner() {
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片list集合
        banner.setImages(imageUrls);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        //点击事件，该第三方banner点击事件的下标是从1开始的
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getActivity(), "点击了第"+position+"条banner", Toast.LENGTH_SHORT).show();
            }
        });
    }

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

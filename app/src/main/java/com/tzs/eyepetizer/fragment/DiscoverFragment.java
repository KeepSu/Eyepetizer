package com.tzs.eyepetizer.fragment;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.entity.Discover;
import com.youth.banner.Banner;
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

    private List imageUrls = new ArrayList();

    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        ButterKnife.bind(this, view);

        download();

        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(imageUrls);//添加图片地址的集合
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        return view;
    }
    private void download() {
        OkHttpUtils.get(path).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {

                Discover discover = new Gson().fromJson(s, Discover.class);
                String nextPageUrl = discover.getNextPageUrl();//下一页的地址
                List<Discover.ItemListBeanX> itemList = discover.getItemList();//discover整体的list
                int count = discover.getCount();
                for (int i = 0; i < count; i++) {
                    List<Discover.ItemListBeanX.DataBeanX.ItemListBean> itemList1
                            = itemList.get(i).getData().getItemList();//每一条里面的list
                    for (int j = 0; j < itemList1.size(); j++) {
                        String imageUrl = itemList1.get(j).getData().getImage();
                        if (i == 0) {
                            imageUrls.add(imageUrl);
                            Log.e("===1111===", "=========="+imageUrl);
                        }
                    }
                }
            }
        });
    }
}

class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        /**
         注意：
         1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
         2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
         传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
         切记不要胡乱强转！
         */
        //Glide 加载图片简单用法
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context).load(path).into(imageView);

        //Picasso 加载图片简单用法
        //Picasso.with(context).load(path).into(imageView);

        //用fresco加载图片简单用法，记得要写下面的createImageView方法
        Uri uri = Uri.parse((String) path);
        imageView.setImageURI(uri);
    }
}

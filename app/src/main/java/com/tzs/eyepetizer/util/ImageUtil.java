package com.tzs.eyepetizer.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.tzs.eyepetizer.R;

/**
 * 加载图片的工具类
 */

public class ImageUtil {

    /**
     * 下载显示圆形图片
     */
    public static void setCircleImage(final Context context, String url, final ImageView iv) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .placeholder(R.drawable.account_default_avatar)
                .centerCrop()
                .into(new BitmapImageViewTarget(iv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        iv.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    /**
     * 下载显示图片,自定义默认图片
     */
    public static void setImage(Context context, String url, ImageView iv, int defaultImage) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .centerCrop()
                .placeholder(defaultImage)
                .into(iv);

    }

    /**
     * 下载显示图片
     */
    public static void setImage(Context context, String url, ImageView iv) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .placeholder(R.drawable.pgc_default_avatar)
                .centerCrop()
                .into(iv);
    }

    /**
     * 给图片覆盖阴影
     */
    public static Bitmap getBlackImage(Bitmap bm) {
        Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.RGB_565);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Canvas canvas = new Canvas(bmp);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bm, 0, 0, paint);
        canvas.drawColor(Color.parseColor("#90000000"));
        return bmp;
    }
}

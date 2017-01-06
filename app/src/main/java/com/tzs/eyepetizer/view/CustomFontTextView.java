package com.tzs.eyepetizer.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import com.tzs.eyepetizer.R;

/**
 * Created by h on 2017/1/6.
 */

public class CustomFontTextView extends AppCompatTextView {
    public CustomFontTextView(Context context) {
        super(context);
    }

    public CustomFontTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 自定义属性
        TypedArray mArray = context.obtainStyledAttributes(attrs, R.styleable.TextFont);
        String mTypefacePath = mArray.getString(R.styleable.TextFont_typefacePath);
        mArray.recycle();
        if (!TextUtils.isEmpty(mTypefacePath)) {
            setTypeface(Typeface.createFromAsset(context.getAssets(), mTypefacePath));
        } else {
            setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/FZLanTingHeiS-L-GB-Regular.TTF"));
        }
    }

    public CustomFontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}

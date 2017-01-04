package com.tzs.eyepetizer.view;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.AttributeSet;

/**
 * Created by h on 2016/12/29.
 */

public class MyCollapsingToolbarLayout extends CollapsingToolbarLayout {
    public MyCollapsingToolbarLayout(Context context) {
        super(context);
    }

    public MyCollapsingToolbarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCollapsingToolbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightSpec);
    }
}

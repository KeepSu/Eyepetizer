package com.tzs.eyepetizer.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by h on 2017/1/9.
 */

public class MyRelativiLayout extends RelativeLayout {
    public MyRelativiLayout(Context context) {
        super(context);
    }

    public MyRelativiLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativiLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, expandSpec);
    }
}

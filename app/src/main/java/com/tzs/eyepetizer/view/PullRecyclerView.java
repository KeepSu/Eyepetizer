package com.tzs.eyepetizer.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by TZS on 2017/1/4.
 */

public class PullRecyclerView extends RecyclerView {
    public OnScrollToButtomLinstener linstener;

    public PullRecyclerView(Context context) {
        super(context);
    }

    public PullRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PullRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (this.computeVerticalScrollExtent() + this.computeVerticalScrollOffset()
                >= this.computeVerticalScrollRange()) {
            linstener.onScrollToButtom();
        }
    }

    public interface OnScrollToButtomLinstener {
        void onScrollToButtom();
    }

    public void setOnScrollToButtomLinstener(OnScrollToButtomLinstener linstener) {
        this.linstener = linstener;
    }
}

package com.tzs.eyepetizer.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.tzs.eyepetizer.callback.OnPullToRefreshListener;
import com.tzs.eyepetizer.callback.OnScrollToBottomListener;


/**
 * 自定义ScrollView
 */
public class PullScrollView extends ScrollView implements View.OnTouchListener {

    private float mFirstPosition = 0;// 记录首次按下位置
    private Boolean mScaling = false;// 是否正在放大

    private View dropZoomView;
    private int dropZoomViewWidth;
    private int dropZoomViewHeight;

    private OnScrollToBottomListener mOnScrollToBottomListener;
    private OnPullToRefreshListener mOnPullToRefreshListener;

    public PullScrollView(Context context) {
        super(context);
    }

    public PullScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        setOverScrollMode(OVER_SCROLL_NEVER);
        if (getChildAt(0) != null) {
            ViewGroup vg = (ViewGroup) getChildAt(0);
            if (vg.getChildAt(0) != null) {
                ViewGroup vg2 = (ViewGroup) vg.getChildAt(0);
                if (vg2.getChildAt(0) != null) {
                    dropZoomView = vg2.getChildAt(0);
                    setOnTouchListener(this);
                }
//                dropZoomView = vg.getChildAt(0);
//                setOnTouchListener(this);

            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (dropZoomViewWidth <= 0 || dropZoomViewHeight <= 0) {
            dropZoomViewWidth = dropZoomView.getMeasuredWidth();
            dropZoomViewHeight = dropZoomView.getMeasuredHeight();
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                mOnPullToRefreshListener.onPullToRefresh();
                mScaling = false;
                replyImage();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mScaling) {
                    if (getScrollY() == 0) {
                        mFirstPosition = event.getY();
                    } else {
                        break;
                    }
                }
                int distance = (int) ((event.getY() - mFirstPosition) * 0.5);
                if (distance < 0) {
                    break;
                }
                mScaling = true;
                setZoom(1 + distance);
                return true;
        }
        return false;
    }

    public void replyImage() {
        final float distance = dropZoomView.getMeasuredHeight() - dropZoomViewHeight;
        ValueAnimator anim = ObjectAnimator.ofFloat(0.0F, 1.0F).setDuration((long) (distance * 1.2));
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                setZoom(distance - ((distance) * cVal));
                setZoom(distance - (distance * cVal));
            }
        });
        anim.start();

    }

    //缩放
    public void setZoom(float s) {
        if (dropZoomViewHeight <= 0 || dropZoomViewWidth <= 0) {
            return;
        }
        ViewGroup.LayoutParams lp = dropZoomView.getLayoutParams();
//        lp.width = (int) (dropZoomViewWidth + s);
//        lp.height = (int) (dropZoomViewHeight * ((dropZoomViewWidth + s) / dropZoomViewWidth));
//        lp.width = (int) (dropZoomViewHeight * ((dropZoomViewHeight + s) / dropZoomViewHeight));
        lp.height = (int) (dropZoomViewHeight + s);
        dropZoomView.setLayoutParams(lp);
    }

    public void setOnScrollToBottomListener(OnScrollToBottomListener listener) {
        mOnScrollToBottomListener = listener;
    }

    public void setOnPullToRefreshListener(OnPullToRefreshListener listener) {
        mOnPullToRefreshListener = listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        ViewGroup vg = (ViewGroup) getChildAt(0);
        View view = vg.getChildAt(0);
        view.scrollTo(0, -getScrollY());

        if (getScrollY() + getHeight() == getChildAt(0).getHeight()) {
            mOnScrollToBottomListener.OnScrollToBottom();
        }

        super.onScrollChanged(l, t, oldl, oldt);
    }
}

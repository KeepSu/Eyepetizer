package com.tzs.eyepetizer.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.tzs.eyepetizer.R;

/**
 * Created by BlueSky on 16/12/29.
 */

public class PullToRefreshRecyclerView extends PullToRefreshBase<RecyclerView> {
    public PullToRefreshRecyclerView(Context context) {
        super(context);
    }

    public PullToRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRefreshRecyclerView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshRecyclerView(Context context, Mode mode, AnimationStyle style) {
        super(context, mode, style);
    }

/*//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
//        super.onMeasure(widthMeasureSpec, expandSpec);
//    }*/

    @Override
    public Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    @Override
    protected RecyclerView createRefreshableView(Context context, AttributeSet attrs) {
        RecyclerView recyclerView = new RecyclerView(context, attrs);
        recyclerView.setId(R.id.recyclerview);
        return recyclerView;
    }

    @Override
    protected boolean isReadyForPullEnd() {
        View view = getRefreshableView().getChildAt(getRefreshableView().getChildCount() - 1);
        if (null != view) {
            return getRefreshableView().getBottom() >= view.getBottom();
        }
        return false;
    }

    @Override
    protected boolean isReadyForPullStart() {
        View view=getRefreshableView().getChildAt(0);
        if (view!=null){
            return view.getTop()>=getRefreshableView().getTop();
        }
        return false;
    }

}

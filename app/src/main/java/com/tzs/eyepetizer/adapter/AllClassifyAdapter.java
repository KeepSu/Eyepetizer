package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.PanoramicActivity;
import com.tzs.eyepetizer.activity.SubjectActivity;
import com.tzs.eyepetizer.entity.AllClassify;
import com.tzs.eyepetizer.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TZS on 2017/1/6.
 */

public class AllClassifyAdapter extends RecyclerView.Adapter<AllClassifyAdapter.AllClassifyViewHolder> {
    private List<AllClassify.ItemListBean> mList = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;

    public void setList (List<AllClassify.ItemListBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    public AllClassifyAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public AllClassifyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_all_classify, parent, false);
        return new AllClassifyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AllClassifyViewHolder holder, int position) {
        final AllClassify.ItemListBean.DataBean data = mList.get(position).getData();
        AllClassifyViewHolder acViewHolder = holder;
        boolean isShade = mList.get(position).getData().isShade();
        if (isShade) {
            acViewHolder.tv_allClassify.setVisibility(View.VISIBLE);
        } else {
            acViewHolder.tv_allClassify.setVisibility(View.INVISIBLE);
        }
        acViewHolder.tv_allClassify.setText(data.getTitle());
        ImageUtil.setImage(mContext, data.getImage(), acViewHolder.iv_allClassify);

        //全部分类里面的点击事件
        acViewHolder.iv_allClassify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.getId() == 0) {           //点击进入专题列表
                    mContext.startActivity(new Intent(mContext, SubjectActivity.class));
                } else if (data.getId() == 1) {         //点击360全景，进入全景列表页面
                    mContext.startActivity(new Intent(mContext, PanoramicActivity.class));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class AllClassifyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_allClassify;
        private TextView tv_allClassify;
        public AllClassifyViewHolder(View itemView) {
            super(itemView);
            iv_allClassify = (ImageView) itemView.findViewById(R.id.iv_allClassify);
            tv_allClassify = (TextView) itemView.findViewById(R.id.tv_allClassify);
        }
    }
}

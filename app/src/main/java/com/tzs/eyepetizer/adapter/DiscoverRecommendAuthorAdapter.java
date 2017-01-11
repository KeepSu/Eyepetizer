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
import com.tzs.eyepetizer.activity.AuthorDetailActivity;
import com.tzs.eyepetizer.entity.Discover;
import com.tzs.eyepetizer.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TZS on 2017/1/3.
 */

public class DiscoverRecommendAuthorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int SQUARECARD = 1;
    private static final int ACTIONCARD = 2;

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Discover.ItemListBeanX.DataBeanX.ItemListBean> mList = new ArrayList<>();

    public void setList(List<Discover.ItemListBeanX.DataBeanX.ItemListBean> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public DiscoverRecommendAuthorAdapter(Context context) {
        this.mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == SQUARECARD) {
            view = mInflater.inflate(R.layout.item_discover_square_recommend_author, parent, false);
            return new RecommendAuthorViewHolder(view);
        } else if (viewType == ACTIONCARD) {
            view = mInflater.inflate(R.layout.item_discover_square_all, parent, false);
            return new AllViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Discover.ItemListBeanX.DataBeanX.ItemListBean.DataBean data = mList.get(position).getData();
        switch (getItemViewType(position)) {
            case SQUARECARD:
                RecommendAuthorViewHolder ravh = (RecommendAuthorViewHolder) holder;
                String imageUrl = data.getImage();
                ImageUtil.setImage(mContext, imageUrl, ravh.iv_below);
                ImageUtil.setCircleImage(mContext, imageUrl, ravh.iv_above);
                ravh.text_author.setText(data.getTitle());
                //点击跳转到作者详情页面
                ravh.iv_below.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, AuthorDetailActivity.class);
                        intent.putExtra("id", data.getId());
                        mContext.startActivity(intent);
                    }
                });

                break;
            case ACTIONCARD:
                AllViewHolder avh = (AllViewHolder) holder;
                avh.tv_all.setText(data.getText());
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 推荐么作者里各个item(除了all)
     */
    static class RecommendAuthorViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_below;
        private ImageView iv_above;
        private TextView text_author;
        public RecommendAuthorViewHolder(View itemView) {
            super(itemView);
            iv_below = (ImageView) itemView.findViewById(R.id.iv_below);
            iv_above = (ImageView) itemView.findViewById(R.id.iv_above);
            text_author = (TextView) itemView.findViewById(R.id.text_author);
        }
    }

    /**
     * 查看全部
     */
    static class AllViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_all;
        public AllViewHolder(View itemView) {
            super(itemView);
            tv_all = (TextView) itemView.findViewById(R.id.tv_all_discover);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Discover.ItemListBeanX.DataBeanX.ItemListBean listBean = mList.get(position);
        String type = listBean.getType();
        if (type.equals("squareCardOfAuthor")) {
            return SQUARECARD;
        } else if (type.equals("actionCard")) {
            return ACTIONCARD;
        }
        return 0;
    }
}

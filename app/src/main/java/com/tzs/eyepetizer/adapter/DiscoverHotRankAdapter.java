package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.entity.Discover;
import com.tzs.eyepetizer.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TZS on 2016/12/30.
 */

public class DiscoverHotRankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int SQUARECARD = 1;
    private static final int ACTIONCARD = 2;
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Discover.ItemListBeanX.DataBeanX.ItemListBean> mList = new ArrayList<>();

    public void setList(List<Discover.ItemListBeanX.DataBeanX.ItemListBean> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public DiscoverHotRankAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == SQUARECARD) {
            view = mInflater.inflate(R.layout.item_discover_square_hot_rank, parent, false);
            return new HotRankViewHolder(view);
        } else if (viewType == ACTIONCARD) {
            view = mInflater.inflate(R.layout.item_discover_square_all, parent, false);
            return new AllViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Discover.ItemListBeanX.DataBeanX.ItemListBean.DataBean data = mList.get(position).getData();
        switch (getItemViewType(position)) {
            case SQUARECARD:
                HotRankViewHolder hrvh = (HotRankViewHolder) holder;
                ImageUtil.setImage(mContext, data.getImage(), hrvh.iv_hotRank);
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
     * 热门分类里各个item(除了all)
     */
    static class HotRankViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_hotRank;
        public HotRankViewHolder(View itemView) {
            super(itemView);
            iv_hotRank = (ImageView) itemView.findViewById(R.id.iv_hotRank);
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
        if (listBean.getType().equals("squareCard")) {
            return SQUARECARD;
        } else if (listBean.getType().equals("actionCard")) {
            return ACTIONCARD;
        }
        return 0;
    }
}

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
import com.tzs.eyepetizer.activity.AllClassifyActivity;
import com.tzs.eyepetizer.activity.ClassInfoActivity;
import com.tzs.eyepetizer.entity.Discover;
import com.tzs.eyepetizer.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TZS on 2016/12/30.
 * 热门分类里面item的适配器
 */

public class DiscoverHotClassifyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int SQUARECARD = 1;
    private static final int ACTIONCARD = 2;

    private Context context;
    private LayoutInflater inflater;
    private List<Discover.ItemListBeanX.DataBeanX.ItemListBean> mList = new ArrayList<>();

    public void setList(List<Discover.ItemListBeanX.DataBeanX.ItemListBean> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public DiscoverHotClassifyAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == SQUARECARD) {
            view = inflater.inflate(R.layout.item_discover_square_hot_classify, parent, false);
            return new HotClassifyViewHolder(view);
        } else if (viewType == ACTIONCARD) {
            view = inflater.inflate(R.layout.item_discover_square_all, parent, false);
            return new AllViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Discover.ItemListBeanX.DataBeanX.ItemListBean.DataBean data = mList.get(position).getData();
        switch (getItemViewType(position)) {
            case SQUARECARD:
                HotClassifyViewHolder hcvh = (HotClassifyViewHolder) holder;
                String imageUrl = data.getImage();
                ImageUtil.setImage(context, imageUrl, hcvh.iv_hotClassify);
                hcvh.tv_hotClassify.setText(data.getTitle());
                hcvh.iv_hotClassify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ClassInfoActivity.class);
                        intent.putExtra("id", data.getId());
                        context.startActivity(intent);
                    }
                });
                break;
            case ACTIONCARD:
                AllViewHolder avh = (AllViewHolder) holder;
                avh.tv_all.setText(data.getText());
                avh.tv_all.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context, AllClassifyActivity.class));
                    }
                });
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
    static class HotClassifyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_hotClassify;
        private TextView tv_hotClassify;
        public HotClassifyViewHolder(View itemView) {
            super(itemView);
            iv_hotClassify = (ImageView) itemView.findViewById(R.id.iv_hotClassify);
            tv_hotClassify = (TextView) itemView.findViewById(R.id.tv_hotClassify);
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
        if (type.equals("squareCard")) {
            return SQUARECARD;
        } else if (type.equals("actionCard")) {
            return ACTIONCARD;
        }
        return 0;
    }
}

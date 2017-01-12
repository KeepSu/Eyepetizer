package com.tzs.eyepetizer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tzs.eyepetizer.R;
import com.tzs.eyepetizer.activity.WebActivity;
import com.tzs.eyepetizer.entity.AllClassify;
import com.tzs.eyepetizer.util.DecodeUtil;
import com.tzs.eyepetizer.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TZS on 2017/1/11.
 */

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<AllClassify.ItemListBean> mList = new ArrayList<>();

    public void setList (List<AllClassify.ItemListBean> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public SubjectAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public SubjectAdapter.SubjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_subject, parent, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SubjectAdapter.SubjectViewHolder holder, int position) {
        final AllClassify.ItemListBean.DataBean data = mList.get(position).getData();
        ImageUtil.setImage(mContext, data.getImage(), holder.iv_subject);
        holder.iv_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = DecodeUtil.StringDecode(data.getActionUrl());
                String[] split = s.split("title=");
                String[] split1 = split[1].split("&url=");
                String title = split1[0];
                String url = split1[1];
                Intent intent = new Intent(mContext, WebActivity.class);
//                Intent intent1 = new Intent(mContext, );
                if (s.contains("webview")) {
                    intent.putExtra("webTitle", title);
                    intent.putExtra("webUrl", url);
                    mContext.startActivity(intent);
                } else if (s.contains("common")) {
//                    intent1.putExtra("title", title);
//                    intent1.putExtra("url", url);
//                    mContext.startActivity(intent1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class SubjectViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_subject;
        public SubjectViewHolder(View itemView) {
            super(itemView);
            iv_subject = (ImageView) itemView.findViewById(R.id.iv_subject);
        }
    }
}

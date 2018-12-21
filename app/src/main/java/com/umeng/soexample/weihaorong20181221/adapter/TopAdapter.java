package com.umeng.soexample.weihaorong20181221.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.umeng.soexample.weihaorong20181221.R;
import com.umeng.soexample.weihaorong20181221.bean.TopBean;

import java.util.List;

/**
 * Created by W on 2018/12/21.
 */

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.ViewHolder> {
    private List<TopBean.DataBean> list;
    private Context context;

    public TopAdapter(List<TopBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_top,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TopBean.DataBean dataBean = list.get(position);
        Glide.with(context).load(dataBean.getIcon()).into(holder.topimg);
        holder.toptv.setText(dataBean.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView topimg;
        private TextView toptv;
        public ViewHolder(View itemView) {
            super(itemView);
            topimg = itemView.findViewById(R.id.top_img);
            toptv = itemView.findViewById(R.id.top_tv);
        }
    }
}

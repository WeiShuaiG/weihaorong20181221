package com.umeng.soexample.weihaorong20181221.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.umeng.soexample.weihaorong20181221.R;
import com.umeng.soexample.weihaorong20181221.bean.ButtomBean;

import java.util.List;

/**
 * Created by W on 2018/12/21.
 */

public class ButtomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ButtomBean.DataBean> list;
    private Context context;
    private final int Grid = 2;
    private final int line = 1;
    private int type;


    public ButtomAdapter(List<ButtomBean.DataBean> list, Context context, int type) {
        this.list = list;
        this.context = context;
        this.type = type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;

        switch (viewType){
            case line:
                view = LayoutInflater.from(context).inflate(R.layout.btm_line,parent,false);
                holder = new ViewHolder(view);
                break;
            case Grid:
                view = LayoutInflater.from(context).inflate(R.layout.btm_wang,parent,false);
                holder = new ViewHolder2(view);
                break;

        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ButtomBean.DataBean dataBean = list.get(position);
        if (holder instanceof ViewHolder){
            ((ViewHolder) holder).btmname.setText(dataBean.getNews_title());
            ((ViewHolder) holder).btmprice.setText(dataBean.getNews_summary());
            Glide.with(context).load(dataBean.getPic_url()).into(((ViewHolder) holder).btmimg);

        }else{
            ((ViewHolder2) holder).btmwangname.setText(dataBean.getNews_title());
            ((ViewHolder2) holder).btmwangprice.setText(dataBean.getNews_summary());
            Glide.with(context).load(dataBean.getPic_url()).into(((ViewHolder2) holder).btmwangimg);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public int getItemViewType(int position) {
        return type;
    }
    public void setType(int type){
        this.type = type;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView btmimg;
        private TextView btmname;
        private TextView btmprice;
        public ViewHolder(View itemView) {
            super(itemView);
            btmimg = itemView.findViewById(R.id.btm_img);
            btmname = itemView.findViewById(R.id.btm_name);
            btmprice = itemView.findViewById(R.id.btm_price);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder {
        private ImageView btmwangimg;
        private TextView btmwangname;
        private TextView btmwangprice;
        public ViewHolder2(View itemView) {
            super(itemView);
            btmwangimg = itemView.findViewById(R.id.btm_wang_img);
            btmwangname = itemView.findViewById(R.id.btm_wang_name);
            btmwangprice = itemView.findViewById(R.id.btm_wang_price);
        }
    }
}

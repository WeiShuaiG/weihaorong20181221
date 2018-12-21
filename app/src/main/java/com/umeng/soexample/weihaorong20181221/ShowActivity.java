package com.umeng.soexample.weihaorong20181221;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.load.engine.Initializable;
import com.umeng.soexample.weihaorong20181221.adapter.ButtomAdapter;
import com.umeng.soexample.weihaorong20181221.adapter.TopAdapter;
import com.umeng.soexample.weihaorong20181221.bean.ButtomBean;
import com.umeng.soexample.weihaorong20181221.bean.TopBean;
import com.umeng.soexample.weihaorong20181221.presenter.PresenterImpl;
import com.umeng.soexample.weihaorong20181221.presenter.Presenterimpl2;
import com.umeng.soexample.weihaorong20181221.view.IView;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity<T> extends AppCompatActivity implements IView<T>, View.OnClickListener {

    private Button btn_sao;
    private boolean c = true;
    private ArrayList<TopBean.DataBean> topList = new ArrayList<>();
    private ArrayList<ButtomBean.DataBean> btnList = new ArrayList<>();
    private String url1 = "http://www.zhaoapi.cn/product/getCatagory";
    private String url2 = "http://api.expoon.com/AppNews/getNewsList/type/1/p/1";
    private TopAdapter topAdapter;
    private ButtomAdapter buttomAdapter;
    private PresenterImpl presenter1;
    private Presenterimpl2 presenterimpl2;
    private RecyclerView recyTop;
    private RecyclerView recyBtm;
    private Button btn_qie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        presenter1 = new PresenterImpl(this);
        presenter1.start(url1,1);
        presenterimpl2 = new Presenterimpl2(this);
        presenterimpl2.start(url2,2);
        btn_qie.setOnClickListener(this);
        btn_sao.setOnClickListener(this);

    }

    private void initView() {
        btn_sao = findViewById(R.id.btn_sao);
        btn_qie = findViewById(R.id.btn_qie);
        recyTop = findViewById(R.id.recy_top);
        GridLayoutManager manager1 = new GridLayoutManager(this,4);
        recyTop.setLayoutManager(manager1);
        recyBtm = findViewById(R.id.recy_btm);
        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        recyBtm.setLayoutManager(manager2);
    }

    @Override
    public void success(T success) {

        if (success instanceof TopBean){
            TopBean topBean = (TopBean) success;
            topList.addAll(topBean.getData());
            topAdapter = new TopAdapter(topList,this);
            recyTop.setAdapter(topAdapter);
            topAdapter.notifyDataSetChanged();
        }
        if (success instanceof ButtomBean){
            ButtomBean buttomBean = (ButtomBean) success;
            btnList.addAll(buttomBean.getData());
            buttomAdapter = new ButtomAdapter(btnList,this,1);
            recyBtm.setAdapter(buttomAdapter);
            buttomAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void error(T error) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //点击切换布局
            case R.id.btn_qie:
                if (c){
                    //网格布局
                    c =false;
                    buttomAdapter.setType(2);
                    RecyclerView.LayoutManager manager = new GridLayoutManager(this,2);
                    recyBtm.setLayoutManager(manager);
                    buttomAdapter.notifyDataSetChanged();
                }else{
                    //线性布局
                    c = true;
                    buttomAdapter.setType(1);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
                    recyBtm.setLayoutManager(manager);
                    buttomAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.btn_sao:

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}

package com.umeng.soexample.weihaorong20181221.model;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.umeng.soexample.weihaorong20181221.OKHttputils;
import com.umeng.soexample.weihaorong20181221.bean.ButtomBean;
import com.umeng.soexample.weihaorong20181221.bean.TopBean;
import com.umeng.soexample.weihaorong20181221.callBack.MyCallBack;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by W on 2018/12/21.
 */

public class ModelImpl implements Model {
    private MyCallBack callBack;
    private int type;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String s = (String) msg.obj;
            Gson gson = new Gson();
            switch (type){
                case 1:
                    TopBean topBean = gson.fromJson(s,TopBean.class);
                    callBack.setSuccess(topBean);
                    break;
                case 2:
                    ButtomBean buttomBean = gson.fromJson(s,ButtomBean.class);
                    callBack.setSuccess(buttomBean);
            }
        }
    };
    @Override
    public void getData(String url, int type, MyCallBack callBack) {
        this.type = type;
        this.callBack = callBack;
        OKHttputils.geInstance().Ascy(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                handler.sendMessage(handler.obtainMessage(0,string));
            }
        });

    }
}

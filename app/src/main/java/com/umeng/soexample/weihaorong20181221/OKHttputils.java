package com.umeng.soexample.weihaorong20181221;

import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by W on 2018/12/21.
 */

public class OKHttputils {
    private OkHttpClient okHttpClient;
    //拦截器
    public OKHttputils(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(20,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

    }
    public static OKHttputils geInstance(){
        return OKHolder.okhttputils;
    }
    static class OKHolder{
        private static final OKHttputils okhttputils = new OKHttputils();
    }
    //异步
    public void Ascy(String url, Callback callback){
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);

    }


}

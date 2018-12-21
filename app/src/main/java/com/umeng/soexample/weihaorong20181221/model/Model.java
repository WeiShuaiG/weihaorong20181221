package com.umeng.soexample.weihaorong20181221.model;

import com.umeng.soexample.weihaorong20181221.callBack.MyCallBack;

/**
 * Created by W on 2018/12/21.
 */

public interface Model {
    void getData(String url, int type, MyCallBack callBack);

}

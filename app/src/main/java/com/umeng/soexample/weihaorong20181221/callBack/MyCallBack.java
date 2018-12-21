package com.umeng.soexample.weihaorong20181221.callBack;

/**
 * Created by W on 2018/12/21.
 */

public interface MyCallBack<T> {
    void setSuccess(T success);

    void setError(T error);
}

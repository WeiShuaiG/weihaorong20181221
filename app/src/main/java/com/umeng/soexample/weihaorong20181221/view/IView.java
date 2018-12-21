package com.umeng.soexample.weihaorong20181221.view;

/**
 * Created by W on 2018/12/21.
 */

public interface IView<T> {
    void success(T success);
    void error(T error);
}

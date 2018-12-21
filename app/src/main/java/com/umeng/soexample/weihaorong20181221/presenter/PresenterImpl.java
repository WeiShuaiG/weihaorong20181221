package com.umeng.soexample.weihaorong20181221.presenter;

import com.umeng.soexample.weihaorong20181221.callBack.MyCallBack;
import com.umeng.soexample.weihaorong20181221.model.ModelImpl;
import com.umeng.soexample.weihaorong20181221.view.IView;

/**
 * Created by W on 2018/12/21.
 */

public class PresenterImpl implements Presenter {
    private ModelImpl model;
    private IView iView;
    public PresenterImpl(IView iView){
        this.iView = iView;
        model = new ModelImpl();
    }
    @Override
    public void start(String url, final int type) {
        model.getData(url, type, new MyCallBack() {
            @Override
            public void setSuccess(Object success) {
                switch (type){
                    case 1:
                        iView.success(success);
                        break;
                }
            }

            @Override
            public void setError(Object error) {
                switch (type){
                    case 1:
                        iView.error(error);
                        break;
                }
            }
        });
    }
}

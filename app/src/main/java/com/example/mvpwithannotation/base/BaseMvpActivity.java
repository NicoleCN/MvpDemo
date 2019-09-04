package com.example.mvpwithannotation.base;

import android.os.Bundle;

import com.example.mvpwithannotation.proxy.IPresentProxy;
import com.example.mvpwithannotation.proxy.PresentProxyImp;

/***
 * @date 2019/9/4 9:58
 * @author BoXun.Zhao
 * @description
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements BaseView {
    //默认持有一个presenter
    //如果有多个presenter 下面用注解
    protected P mPresenter;
    private IPresentProxy mPresentProxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        initProxy();
    }

    private void initProxy() {
        mPresentProxy = new PresentProxyImp(this);
        mPresentProxy.bindPresenter();
    }

    protected P createPresenter() {
        return null;
    }

    public P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detach();
        }
        mPresentProxy.unBindPresenter();
    }
}

package com.example.mvpwithannotation.base;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;


/***
 *@date 创建时间 2019/9/4 9:59
 *@author 作者: BoXun.Zhao
 *@description
 */
public class BasePresenter<V extends BaseView,M extends BaseModel> {
    private V mProxyView;
    private V mView;
    private M mModel;

    /**
     * view是传进来的泛型V的实例化对象
     * 这个对象需要被代理  mProxyView
     */
    public void attach(V view) {
        mView = view;
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (mView == null) {
                    return null;
                }
                // TODO: 2019/9/4 判断网络情况
                Log.e("zbx", "先判断网络情况");
                return method.invoke(mView, args);
            }
        });

        Type genType = this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) genType).getActualTypeArguments();
        try {
            /**
             * 最好判断一下类型
             * actualTypeArguments[1]是 V extends BaseView
             * actualTypeArguments[1]是 M extends BaseModel
             */
            mModel = (M) ((Class) actualTypeArguments[1]).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public void detach() {
        mView = null;
    // mProxyView = null; 不需要
    }


    public V getProxyView() {
        return mProxyView;
    }

    public M getModel() {
        return mModel;
    }
}

package com.example.mvpwithannotation.proxy;

import com.example.mvpwithannotation.base.BasePresenter;
import com.example.mvpwithannotation.base.BaseView;
import com.example.mvpwithannotation.inject.InjectPresenter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/***
 * @date 2019/9/4 10:15
 * @author BoXun.Zhao
 * @description
 */
public class PresentProxyImp<V extends BaseView> implements IPresentProxy {
    private V mView;
    private List<BasePresenter> mBasePresenterList;

    public PresentProxyImp(V mView) {
        this.mView = mView;
        mBasePresenterList = new ArrayList<>();
    }

    @Override
    public void bindPresenter() {
        Field[] declaredFields = mView.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            InjectPresenter injectPresenter = declaredField.getAnnotation(InjectPresenter.class);
            if (injectPresenter != null) {
                Class<? extends BasePresenter> presentClazz = null;
                try {
                    String simpleName = declaredField.getType().getSuperclass().getSimpleName();
                    //如果继承的是BasePresenter
                    if (simpleName.equals(BasePresenter.class.getSimpleName())) {
                        presentClazz = (Class<? extends BasePresenter>) declaredField.getType();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (presentClazz == null) {
                    throw new RuntimeException("cant not auto create presenter!");
                }
                try {
                    BasePresenter basePresenter = presentClazz.newInstance();
                    basePresenter.attach(mView);
                    declaredField.setAccessible(true);
                    declaredField.set(mView, basePresenter);
                    mBasePresenterList.add(basePresenter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void unBindPresenter() {
        for (BasePresenter basePresenter : mBasePresenterList) {
            basePresenter.detach();
        }
        mView = null;
    }
}

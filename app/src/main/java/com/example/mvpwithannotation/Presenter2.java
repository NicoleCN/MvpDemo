package com.example.mvpwithannotation;

import android.util.Log;

import com.example.mvpwithannotation.base.BaseModel;
import com.example.mvpwithannotation.base.BasePresenter;

/***
 * @date 2019/9/4 10:26
 * @author BoXun.Zhao
 * @description
 */
public class Presenter2 extends BasePresenter<LocationView, BaseModel> {

    void getLocationInfo2() {
        Log.e("zbx","请求地址2");
        getProxyView().fail("我故意失败的2");
    }
}

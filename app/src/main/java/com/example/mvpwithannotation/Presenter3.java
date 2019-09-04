package com.example.mvpwithannotation;

import android.util.Log;

import com.example.mvpwithannotation.base.BaseModel;
import com.example.mvpwithannotation.base.BasePresenter;

/***
 * @date 2019/9/4 10:26
 * @author BoXun.Zhao
 * @description
 */
public class Presenter3 extends BasePresenter<LocationView, BaseModel> {

    void getLocationInfo3() {
        Log.e("zbx", "请求地址3");
        getProxyView().onSuccess("地址3是北京");
    }
}

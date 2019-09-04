package com.example.mvpwithannotation;

import android.util.Log;

import com.example.mvpwithannotation.base.BaseModel;
import com.example.mvpwithannotation.base.BasePresenter;

/***
 * @date 2019/9/4 10:26
 * @author BoXun.Zhao
 * @description
 */
public class Presenter1 extends BasePresenter<LocationView, BaseModel> {

    void getLocationInfo1() {
        // TODO: 2019/9/4 真正的请求放model
        //model的操作就不写了
        Log.e("zbx", "请求地址1");
        getProxyView().onSuccess("地址1是上海");
    }
}

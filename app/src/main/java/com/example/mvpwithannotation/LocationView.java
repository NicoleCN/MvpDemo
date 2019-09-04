package com.example.mvpwithannotation;

import com.example.mvpwithannotation.base.BaseView;

/***
 * @date 2019/9/4 10:31
 * @author BoXun.Zhao
 * @description
 */
public interface LocationView extends BaseView {

    void fail(String msg);

    void onSuccess(String msg);
}

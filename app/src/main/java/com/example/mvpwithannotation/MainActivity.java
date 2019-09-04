package com.example.mvpwithannotation;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mvpwithannotation.base.BaseMvpActivity;
import com.example.mvpwithannotation.inject.InjectPresenter;

public class MainActivity extends BaseMvpActivity<Presenter1> implements LocationView {
    @InjectPresenter
    private Presenter2 presenter2;
    @InjectPresenter
    private Presenter3 presenter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void fail(String msg) {
        showToast(msg);
    }

    @Override
    public void onSuccess(String msg) {
        showToast(msg);
    }

    private void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    protected Presenter1 createPresenter() {
        return new Presenter1();
    }

    public void test1(View view) {
        mPresenter.getLocationInfo1();
    }

    public void test2(View view) {
        presenter2.getLocationInfo2();
    }

    public void test3(View view) {
        presenter3.getLocationInfo3();
    }
}

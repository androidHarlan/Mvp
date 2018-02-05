package com.lhc.harlan.mvp.activitys.fragments.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lhc.harlan.mvp.R;
import com.lhc.harlan.mvp.base.BaseActivity;
import com.lhc.harlan.mvp.databinding.TesthttpBinding;

/**
 * Created by 23 on 2018/2/5.
 */

public class TestHttp extends BaseActivity<TestPresenterImpl> implements TestView.View{
    TesthttpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void toastMsg(String msg) {

    }

    @Override
    public void getDate(String data) {
        Log.e("backinfo","跑到这里了哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        binding.result.setText(data.toString());
    }

    @Override
    protected void getLayoutId() {


    }

    @Override
    protected void initEventAndData() {
       binding= DataBindingUtil.setContentView(this, R.layout.testhttp);
        binding.testhttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.httpDate();
            }
        });

    }

    @Override
    protected void initInjectAndLayoutId() {

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);

    }


}

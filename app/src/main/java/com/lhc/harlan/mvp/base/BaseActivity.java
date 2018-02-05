package com.lhc.harlan.mvp.base;

import android.app.Activity;
import android.os.Bundle;

import com.lhc.harlan.mvp.BaseApplication;
import com.lhc.harlan.mvp.dagger.component.ActivityComponent;

import com.lhc.harlan.mvp.dagger.component.AppComponent;
import com.lhc.harlan.mvp.dagger.component.DaggerActivityComponent;
import com.lhc.harlan.mvp.dagger.module.ActivityModule;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


import javax.inject.Inject;



public abstract class BaseActivity<T extends BasePresenter> extends RxAppCompatActivity implements BaseView {

    private Bundle state;
    AppComponent appComponent;
    @Inject
    protected T mPresenter;
    protected Activity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        state = savedInstanceState;
        initInject();
        initInjectAndLayoutId();
        getLayoutId();
        if (mPresenter != null)
            mPresenter.attachView(this);
        BaseApplication.getInstance().addActivity(this);
        initEventAndData();



    }

    /**
     * @return 填写布局
     */
    protected abstract void getLayoutId();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
        BaseApplication.getInstance().removeActivity(this);
    }

    protected abstract void initEventAndData();
    /**
     * @return 填写布局和使用dagger绑定例如  mBinding = DataBindingUtil.setContentView(this,R.layout.activity_pay_result);
     */
    protected abstract void initInjectAndLayoutId();

    protected abstract void initInject();

    protected Bundle getSavedInstanceState() {
        return state;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appComponent(BaseApplication.getComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

}

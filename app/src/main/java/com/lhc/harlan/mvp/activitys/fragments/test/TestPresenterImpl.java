package com.lhc.harlan.mvp.activitys.fragments.test;

import android.content.Context;
import android.util.Log;

import com.lhc.harlan.mvp.NetworkApi;
import com.lhc.harlan.mvp.base.BaseRxPresenter;
import com.lhc.harlan.mvp.bean.Test1;

import com.lhc.harlan.mvp.http.ProgressSubscriber;
import com.lhc.harlan.mvp.http.RetrofitManager;
import com.lhc.harlan.mvp.http.SubscriberOnNextListenter;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;

/**
 * Created by 23 on 2018/2/5.
 */

public class TestPresenterImpl extends BaseRxPresenter<TestView.View> implements TestView.Presenter{
    private Context context;
    @Inject
    public TestPresenterImpl(Context context) {
        this.context = context;
    }


    /**
     *
     */
    @Override
    public void httpDate() {
        Observable observable = RetrofitManager.getInstace()
                .create(NetworkApi.class).getCode()
                .map(new HttpResultFunc1<String>());
        Subscription rxSubscription = new ProgressSubscriber<>(new SubscriberOnNextListenter<String>() {

            public void next(String o) {
                Log.e("backinfo","返回数据："+o);
                mView.getDate(o);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("backinfo","出错出错出错出错出错出错出错出错出错出错出错");
            }
        },context,true);
        RetrofitManager.getInstace().toSubscribe(observable, (Subscriber) rxSubscription);
        addSubscrebe(rxSubscription);
    }
    class HttpResultFunc1<String> implements Func1<java.lang.String, java.lang.String>{


        @Override
        public java.lang.String call(java.lang.String httpResult) {

            return httpResult;
        }
    }
}

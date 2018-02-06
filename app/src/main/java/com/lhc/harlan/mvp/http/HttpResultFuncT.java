package com.lhc.harlan.mvp.http;

import com.lhc.harlan.mvp.HttpConstants;
import com.lhc.harlan.mvp.base.BaseEntity;

import rx.functions.Func1;

/**
 * Created by Dell on 2017/7/26.
 * Created time:2017/7/26 15:20
 */

public class HttpResultFuncT<T> implements Func1<T, T>{


    @Override
    public T call(T httpResult) {

        return httpResult;
    }

}

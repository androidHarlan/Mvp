package com.lhc.harlan.mvp.http;

import com.lhc.harlan.mvp.HttpConstants;
import com.lhc.harlan.mvp.base.BaseEntity;

import rx.functions.Func1;

/**
 * Created by Dell on 2017/7/26.
 * Created time:2017/7/26 15:20
 */

public class HttpResultFunc<T> implements Func1<BaseEntity<T>, BaseEntity<T>> {

    @Override
    public BaseEntity<T> call(BaseEntity<T> httpResult) {
        if (!httpResult.isSuccess()) {
            if (httpResult.getResultCode() != HttpConstants.OPERAT_OK){  // 操作成功
                throw ExceptionHandle.handleHttpException(httpResult);
            }
        }
        return httpResult;
    }
}

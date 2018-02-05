package com.lhc.harlan.mvp.http;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * Created by Dell on 2017/7/26.
 * Created time:2017/7/26 15:12
 */

public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {

    private SubscriberOnNextListenter mSubscriberOnNextListenter;
    private ProgressDialogHandler mProgressDialogHandler;
    private Context context;

    public ProgressSubscriber(SubscriberOnNextListenter mSubscriberOnNextListenter, Context context,boolean show) {
        this.mSubscriberOnNextListenter = mSubscriberOnNextListenter;
        this.context = context;
        mProgressDialogHandler = new ProgressDialogHandler(context, this, true,show);
    }

    @Override
    public void onStart() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }

    @Override
    public void onCompleted() {
//        Toast.makeText(context, "Complete", Toast.LENGTH_SHORT).show();
        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            Toast.makeText(context, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(context, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        Log.e("backinfo","错误信息："+e.getMessage());
        dismissProgressDialog();
        mSubscriberOnNextListenter.onError(e);
    }

    @Override
    public void onNext(T t) {
        mSubscriberOnNextListenter.next(t);
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }
}


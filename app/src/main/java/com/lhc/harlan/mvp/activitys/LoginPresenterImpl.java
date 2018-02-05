package com.lhc.harlan.mvp.activitys;

import android.content.Context;
import android.util.Log;


import com.lhc.harlan.mvp.base.BaseRxPresenter;
import com.lhc.harlan.mvp.http.RetrofitManager;

import javax.inject.Inject;



/**
 * Created by Dell on 2017/7/3.
 */

public class LoginPresenterImpl extends BaseRxPresenter<LoginContract.View> implements LoginContract.Presenter{

    private Context context;

    @Inject
    public LoginPresenterImpl(Context context) {
        this.context = context;
    }




    @Override
    public void downLoad(final Context ctx, String url) {

    }

    @Override
    public void gotoRegister() {
        mView.gotoRegister();
    }

    @Override
    public void gotoReset() {
        mView.gotoReset();
    }


}

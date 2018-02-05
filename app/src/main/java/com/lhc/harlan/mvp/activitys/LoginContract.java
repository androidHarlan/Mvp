package com.lhc.harlan.mvp.activitys;


import android.content.Context;

import com.lhc.harlan.mvp.base.BasePresenter;
import com.lhc.harlan.mvp.base.BaseView;


/**
 * Created by Dell on 2017/7/3.
 */

public class LoginContract {

    public interface View extends BaseView {

        void gotoRegister();
        void gotoReset();

    }
    public interface Presenter extends BasePresenter<View> {

        void downLoad(Context ctx, String url);
        void gotoRegister();
        void gotoReset();

    }
}

package com.lhc.harlan.mvp.activitys.fragments.test;

import com.lhc.harlan.mvp.base.BasePresenter;
import com.lhc.harlan.mvp.base.BaseView;

/**
 * Created by 23 on 2018/2/5.
 */

public class TestView {
    public interface View extends BaseView {
        void getDate(String  data);
    }
    public interface Presenter extends BasePresenter<TestView.View> {
        void httpDate();
    }
}

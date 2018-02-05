package com.lhc.harlan.mvp.activitys.fragments;


import com.lhc.harlan.mvp.base.BasePresenter;
import com.lhc.harlan.mvp.base.BaseView;

/**
 * Created by Dell on 2017/9/1.
 * Created time:2017/9/1 10:54
 */

public class FEContract {

    public interface View extends BaseView {
        void showElevator(String elevatorBean);
    }

    public interface Presenter extends BasePresenter<View> {
        void getElevator(String commonBean);
    }
}

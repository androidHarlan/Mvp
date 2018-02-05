package com.lhc.harlan.mvp.activitys.fragments;



import com.lhc.harlan.mvp.base.BaseRxPresenter;

import javax.inject.Inject;

/**
 * Created by Dell on 2017/9/1.
 * Created time:2017/9/1 10:55
 */

public class FEPresenter extends BaseRxPresenter<FEContract.View> implements FEContract.Presenter {

    private BlankFragment elevatorFragment;

    @Inject
    public FEPresenter(BlankFragment elevatorFragment) {
        this.elevatorFragment = elevatorFragment;
    }

    @Override
    public void getElevator(String commonBean) {

    }
}

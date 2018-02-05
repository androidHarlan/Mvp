package com.lhc.harlan.mvp.activitys.fragments;


import com.lhc.harlan.mvp.R;
import com.lhc.harlan.mvp.base.BaseFragment;

import java.util.List;


public class BlankFragment extends BaseFragment<FEPresenter> implements FEContract.View{

    @Override
    public void toastMsg(String msg) {

    }


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showElevator(String elevatorBean) {

    }
}

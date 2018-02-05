package com.lhc.harlan.mvp.dagger.component;


import com.lhc.harlan.mvp.BaseApplication;
import com.lhc.harlan.mvp.activitys.fragments.BlankFragment;
import com.lhc.harlan.mvp.dagger.ContextLife;
import com.lhc.harlan.mvp.dagger.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * SmartCommunity-com.BIT.fuxingwuye.dagger.component
 * 作者： YanwuTang
 * 时间： 2017/7/4.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ContextLife("Application")
    BaseApplication getContext();
   /* BlankFragment GetBlankFragment()*/;
    BlankFragment blankfragment();


}

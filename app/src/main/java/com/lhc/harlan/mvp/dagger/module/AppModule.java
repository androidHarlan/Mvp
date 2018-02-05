package com.lhc.harlan.mvp.dagger.module;



import com.lhc.harlan.mvp.BaseApplication;
import com.lhc.harlan.mvp.activitys.fragments.BlankFragment;
import com.lhc.harlan.mvp.dagger.ContextLife;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * SmartCommunity-com.BIT.fuxingwuye.dagger.module
 * 作者： YanwuTang
 * 时间： 2017/7/4.
 * app 全局变量
 */
@Module
public class AppModule {
    private final BaseApplication application;

    public AppModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    BaseApplication provideApplicationContext(){
        return application;
    }

    @Provides
    @Singleton
    BlankFragment providerblankFragment(){
        return new BlankFragment();
    }



}

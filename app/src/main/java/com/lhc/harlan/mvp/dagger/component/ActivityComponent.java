package com.lhc.harlan.mvp.dagger.component;

import android.app.Activity;

import com.lhc.harlan.mvp.activitys.MainActivity;
import com.lhc.harlan.mvp.activitys.fragments.test.TestHttp;
import com.lhc.harlan.mvp.activitys.fragments.test.TestView;
import com.lhc.harlan.mvp.dagger.ActivityScope;
import com.lhc.harlan.mvp.dagger.module.ActivityModule;

import dagger.Component;

/**
 * Created by Dell on 2017/8/1.
 * Created time:2017/8/1 10:14
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
    void inject(TestHttp testHttp);


}

package com.lhc.harlan.mvp.dagger.component;

import android.app.Activity;


import com.lhc.harlan.mvp.activitys.fragments.BlankFragment;
import com.lhc.harlan.mvp.dagger.FragmentScope;
import com.lhc.harlan.mvp.dagger.module.FragmentModule;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(BlankFragment fragmentMain);
}

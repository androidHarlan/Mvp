package com.lhc.harlan.mvp.activitys;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;


import com.lhc.harlan.mvp.R;
import com.lhc.harlan.mvp.activitys.fragments.test.TestHttp;
import com.lhc.harlan.mvp.base.BaseActivity;
import com.lhc.harlan.mvp.bean.User;
import com.lhc.harlan.mvp.databinding.ActivityMainBinding;


public class MainActivity extends BaseActivity<LoginPresenterImpl> implements LoginContract.View {
     ActivityMainBinding binding;


    @Override
    protected void getLayoutId() {

    }

    @Override
    protected void initEventAndData() {
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("loonggg");
        binding.setUser(user);
        binding.gotest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, TestHttp.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void initInjectAndLayoutId() {

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void toastMsg(String msg) {

    }

    @Override
    public void gotoRegister() {

    }

    @Override
    public void gotoReset() {

    }
}

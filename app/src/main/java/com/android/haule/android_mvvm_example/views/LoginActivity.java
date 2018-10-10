package com.android.haule.android_mvvm_example.views;

import android.os.Bundle;
import com.android.haule.android_mvvm_example.R;
import com.android.haule.android_mvvm_example.views.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_login;
    }
}

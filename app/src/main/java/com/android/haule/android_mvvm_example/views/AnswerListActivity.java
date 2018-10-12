package com.android.haule.android_mvvm_example.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.android.haule.android_mvvm_example.R;
import com.android.haule.android_mvvm_example.databinding.ActivityAnswerListBinding;
import com.android.haule.android_mvvm_example.viewmodels.AnswerListViewModel;
import com.android.haule.android_mvvm_example.views.base.BaseActivity;

public class AnswerListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void bindingView() {
        ActivityAnswerListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_answer_list);
        binding.setViewModel(new AnswerListViewModel(this, binding));
        binding.executePendingBindings();
    }
}

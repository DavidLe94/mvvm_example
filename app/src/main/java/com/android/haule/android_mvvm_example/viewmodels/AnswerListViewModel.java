package com.android.haule.android_mvvm_example.viewmodels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.util.Log;
import com.android.haule.android_mvvm_example.adapter.AnswerAdapter;
import com.android.haule.android_mvvm_example.api.ApiServices;
import com.android.haule.android_mvvm_example.api.ApiUtils;
import com.android.haule.android_mvvm_example.databinding.ActivityAnswerListBinding;
import com.android.haule.android_mvvm_example.models.Item;
import com.android.haule.android_mvvm_example.models.ResAnswer;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hau Le on 2018-10-12.
 */
public class AnswerListViewModel extends BaseObservable{
    private ApiServices apiServices;
    private AnswerAdapter adapter;
    private ArrayList<Item> list;

    public AnswerListViewModel(Context context, ActivityAnswerListBinding binding) {
        apiServices = ApiUtils.getApiService();
        list = new ArrayList<>();
        adapter = new AnswerAdapter(context, list);
        binding.listAnswer.setAdapter(adapter);
        apiServices.getListAnswer().enqueue(new Callback<ResAnswer>() {
            @Override
            public void onResponse(Call<ResAnswer> call, Response<ResAnswer> response) {
                list = (ArrayList<Item>) response.body().getItems();
                adapter.notifyAdapter(list);
            }

            @Override
            public void onFailure(Call<ResAnswer> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
    }
}

package com.android.haule.android_mvvm_example.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.android.haule.android_mvvm_example.R;
import com.android.haule.android_mvvm_example.databinding.ItemAnswerBinding;
import com.android.haule.android_mvvm_example.models.Item;
import java.util.ArrayList;

/**
 * Created by Hau Le on 2018-10-12.
 */
public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Item> list;

    public AnswerAdapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemAnswerBinding view = DataBindingUtil
                .inflate(LayoutInflater.from(context),
                        R.layout.item_answer, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.viewDataBinding.setItem(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemAnswerBinding viewDataBinding;

        ViewHolder(@NonNull ItemAnswerBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
        }
    }

    public void notifyAdapter(ArrayList<Item> list){
        this.list = list;
        notifyDataSetChanged();
    }
}

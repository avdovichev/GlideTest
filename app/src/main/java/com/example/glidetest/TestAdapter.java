package com.example.glidetest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class TestAdapter extends RecyclerView.Adapter {

    interface PositionListener {
        void onPositionChange(int position);
    }

    private final Context context;
    private final PositionListener positionListener;

    TestAdapter(@NonNull final Context context, @NonNull final PositionListener positionListener) {
        this.context = context;
        this.positionListener = positionListener;
    }

    @Override public long getItemId(final int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                      final int viewType) {
        final View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_cell, parent, false);
        return new TestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder,
                                 final int position) {

        final ImageView v = (ImageView) holder.itemView;

        Glide.with(context)
                .load("http://45.55.6.132/cards/" + String.valueOf(position + 1) + "/sample.png")
                .apply(new RequestOptions().placeholder(R.drawable.placeholder))
                .into(v)
                ;

        positionListener.onPositionChange(position);
    }

    @Override
    public int getItemCount() {
        return 4000;
    }
}

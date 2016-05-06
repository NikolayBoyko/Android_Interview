package com.example.smy.androidinterview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyfirstFragmentAdapter extends RecyclerView.Adapter<MyfirstFragmentAdapter.ViewHolder> {

    private Activity context;
    private int[] mImage;
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.image_item);
        }
    }

    public MyfirstFragmentAdapter(int[] myImage) {
        mImage = myImage;
    }

    @Override
    public MyfirstFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_fragment_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.imageView.setImageResource(mImage[position]);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case R.drawable.java_logo:
               /*         JavaMainListQuestionFragment javaMainListQuestionFragment = new JavaMainListQuestionFragment();
                        context.getFragmentManager().beginTransaction().add(R.id.main_content,javaMainListQuestionFragment).commit();*/
                        return;
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mImage.length;
    }
}
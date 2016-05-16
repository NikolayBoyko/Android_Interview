package com.example.smy.androidinterview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyfirstFragmentAdapter extends RecyclerView.Adapter<MyfirstFragmentAdapter.ViewHolder> {

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
    }


    @Override
    public int getItemCount() {
        return mImage.length;
    }
}
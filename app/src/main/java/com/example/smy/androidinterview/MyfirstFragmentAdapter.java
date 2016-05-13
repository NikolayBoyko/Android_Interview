package com.example.smy.androidinterview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class MyfirstFragmentAdapter extends RecyclerView.Adapter<MyfirstFragmentAdapter.ViewHolder> {

    private FragmentActivity activity;
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
       /* holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Log.d("log", "cllick on java");//лог выводится
                    addFragment(new JavaMainListQuestionFragment());
                }
            }
        });*/
    }

    public void addFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_content, fragment).commit();
    }



    @Override
    public int getItemCount() {
        return mImage.length;
    }
}
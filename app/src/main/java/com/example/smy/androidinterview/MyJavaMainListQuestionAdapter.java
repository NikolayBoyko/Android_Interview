package com.example.smy.androidinterview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyJavaMainListQuestionAdapter extends RecyclerView.Adapter<MyJavaMainListQuestionAdapter.ViewHolder> {

    private String[] mQuestionList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView myQuestion;

        public ViewHolder(View v) {
            super(v);
            myQuestion = (TextView) v.findViewById(R.id.java_question_item);
        }
    }

    public MyJavaMainListQuestionAdapter(String[] mQuestionList) {
        this.mQuestionList = mQuestionList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.java_question_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.myQuestion.setText(mQuestionList[position]);
        holder.myQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("log", "click on: " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mQuestionList.length;
    }

}

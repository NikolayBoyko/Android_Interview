package com.example.smy.androidinterview;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JavaTypeOfDataAdapter extends RecyclerView.Adapter<JavaTypeOfDataAdapter.ViewHolder> {

    private String[] mQuestionList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView myQuestion;

        public ViewHolder(View v) {
            super(v);
            myQuestion = (TextView) v.findViewById(R.id.java_question_item);
        }
    }

    public JavaTypeOfDataAdapter(String[] mQuestionList) {
        this.mQuestionList = mQuestionList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.java_type_of_data_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.myQuestion.setText(mQuestionList[position]);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

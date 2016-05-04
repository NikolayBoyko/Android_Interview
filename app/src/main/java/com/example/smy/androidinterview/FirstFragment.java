package com.example.smy.androidinterview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

public class FirstFragment extends Fragment{

    private static final String LIST = "list";

    private static final String[] data = {"Java", "Android"};

    ArrayAdapter<String> adapter;
    RecyclerView.Recycler recycler;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.javaListQuestion,
                android.R.layout.simple_list_item_1);

    }
}

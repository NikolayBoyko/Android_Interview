package com.example.smy.androidinterview;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainFragment extends ListFragment {

    private static final String LIST = "Java вопросы";
    //private static final ArrayList<String> myList = new ArrayList<>(R.array.javaListQuestion);


    ArrayAdapter<String> myadapter;

   /* public static MainFragment newInstance() {
        MainFragment javaListQuestionFragment = new MainFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(LIST, myList);
        javaListQuestionFragment.setArguments(args);
        return javaListQuestionFragment;
    }*/

   /* @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myadapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, R.array.javaListQuestion);
        setListAdapter(myadapter);
    }*/

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, R.string.javaListQuestionName);
        setListAdapter(adapter);
    }

}

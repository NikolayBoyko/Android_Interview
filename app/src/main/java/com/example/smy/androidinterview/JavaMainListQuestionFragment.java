package com.example.smy.androidinterview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class JavaMainListQuestionFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private final int TYPE_OF_DATA = 0;
    private final int OOP = 1;
    private final int EXCEPTIONS = 2;
    private final int COLLECTIONS = 3;
    private final int STRINGS = 4;
    private final int THREADS_INPUT_OUTPUT = 5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case TYPE_OF_DATA:
                        //open fragment type of data
                        break;
                    case OOP:
                        //open fragment OOP
                        break;
                    case EXCEPTIONS:
                        //open fragment EXCEPTION
                        break;
                    case COLLECTIONS:
                        break;
                    case STRINGS:
                        //open fragment STRINGS
                        break;
                    case THREADS_INPUT_OUTPUT:
                        //open awesome
                        break;
                    default:
                        break;
                }
            }
        }));
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyJavaMainListQuestionAdapter(getResources().getStringArray(R.array.javaQuestionList));
        mRecyclerView.setAdapter(mAdapter);
    }
}

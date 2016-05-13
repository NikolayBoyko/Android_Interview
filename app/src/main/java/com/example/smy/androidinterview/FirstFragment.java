package com.example.smy.androidinterview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends Fragment {

    private int[] photo = {R.drawable.java_logo, R.drawable.android_logo, R.drawable.sql_logo, R.drawable.network_logo};
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private GridLayoutManager lLayout;
    FragmentTransaction fragmentTransaction;

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
                    case 0:
                        replaceFragment(new JavaMainListQuestionFragment());
                        break;
                }
            }
        }));

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        lLayout = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(lLayout);

        mAdapter = new MyfirstFragmentAdapter(photo);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void addFragment(Fragment fragment) {
        fragmentTransaction = getActivity()
                .getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.main_content, fragment).commit();
    }

    public void replaceFragment(Fragment fragment) {
        fragmentTransaction = getActivity()
                .getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.main_content, fragment).commit();
    }
}

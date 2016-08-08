package com.example.smy.androidinterview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseListFragment extends Fragment {

    private int[] photo = {R.drawable.java_logo, R.drawable.android_logo, R.drawable.sql_logo, R.drawable.network_logo};

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private GridLayoutManager lLayout;
    private FragmentTransaction fragmentTransaction;


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
                        replaceFragment(MainListQuestionFragment.newInstance(1, getResources().getStringArray(R.array.JavaMainQuestion)));
                        break;
                    case 1:
                        replaceFragment(MainListQuestionFragment.newInstance(2, getResources().getStringArray(R.array.AndroidMainList)));
                        break;
                    case 2:
                        replaceFragment(MainListQuestionFragment.newInstance(3, getResources().getStringArray(R.array.SQLMainList)));
                        break;
                    case 3:
                        replaceFragment(MainListQuestionFragment.newInstance(4, getResources().getStringArray(R.array.NetworkMainList)));
                        break;
                }
            }
        }));
        lLayout = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(lLayout);

        mAdapter = new MyfirstFragmentAdapter(photo);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void replaceFragment(Fragment fragment) {
        fragmentTransaction = getActivity()
                .getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.main_content, fragment).commit();
    }
}

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
import android.view.animation.AnimationUtils;


public class FirstFragment extends Fragment {

    private int[] photo = {R.drawable.java_logo, R.drawable.android_logo, R.drawable.sql_logo, R.drawable.network_logo};

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private GridLayoutManager lLayout;
    private FragmentTransaction fragmentTransaction;

    private final int IMAGE_JAVA = 0;
    private final int IMAGE_ANDROID = 1;
    private final int IMAGE_SQL = 2;
    private final int IMAGE_NETWORKS = 3;

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
                view.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.animation_on_click));
                switch (position) {
                    case IMAGE_JAVA:
                        replaceFragment(MainListQuestionFragment.newInstance(IMAGE_JAVA));
                        MainActivity.mToolbar.setTitle(R.string.JavaInterview);
                        break;
                    case IMAGE_ANDROID:
                        replaceFragment(MainListQuestionFragment.newInstance(IMAGE_ANDROID));
                        MainActivity.mToolbar.setTitle(R.string.app_name);
                        break;
                    case IMAGE_SQL:
                        replaceFragment(MainListQuestionFragment.newInstance(IMAGE_SQL));
                        MainActivity.mToolbar.setTitle(R.string.SQLInterview);
                        break;
                    case IMAGE_NETWORKS:
                        replaceFragment(MainListQuestionFragment.newInstance(IMAGE_NETWORKS));
                        MainActivity.mToolbar.setTitle(R.string.NetworksInterview);
                        break;
                    default:
                        break;
                }
            }
        }));

        //int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
       // mRecyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        lLayout = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(lLayout);

        mAdapter = new MyfirstFragmentAdapter(photo);
        mRecyclerView.setAdapter(mAdapter);
    }

   /* public int[] getImageArray(int[] array) {
        int[] mArray = array;
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = array[i];
        }
        return mArray;
    }*/

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

    public void onResume() {
        super.onResume();
        MainActivity.mToolbar.setTitle(R.string.app_name);
    }

}

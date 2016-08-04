package com.example.smy.androidinterview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainListQuestionFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FragmentTransaction fragmentTransaction;

    private final int TYPE_OF_DATA = 0;
    private final int OOP = 1;
    private final int EXCEPTIONS = 2;
    private final int COLLECTIONS = 3;
    private final int STRINGS = 4;
    private final int THREADS_INPUT_OUTPUT = 5;

    public static MainListQuestionFragment newInstance(Integer integer) {
        MainListQuestionFragment mainListQuestionFragment = new MainListQuestionFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", integer);
        mainListQuestionFragment.setArguments(args);
        return mainListQuestionFragment;
    }

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
                        replaceFragment(JavaExpandableFragment.newInstance(TYPE_OF_DATA, getResources().getStringArray(R.array.javaTypeOfDataList), getResources().getStringArray(R.array.javaChildList)));
                        break;
                    case OOP:
                        replaceFragment(JavaExpandableFragment.newInstance(OOP, getResources().getStringArray(R.array.javaTypeOfDataList), getResources().getStringArray(R.array.javaChildList)));
                        break;
                    case EXCEPTIONS:
                        replaceFragment(JavaExpandableFragment.newInstance(EXCEPTIONS, getResources().getStringArray(R.array.javaTypeOfDataList), getResources().getStringArray(R.array.javaChildList)));
                        break;
                    case COLLECTIONS:
                        break;
                    case STRINGS:
                        break;
                    case THREADS_INPUT_OUTPUT:
                        break;
                    default:
                        break;
                }
            }
        }));
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyJavaMainListQuestionAdapter(getResources().getStringArray(R.array.JavaMainQuestion));
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

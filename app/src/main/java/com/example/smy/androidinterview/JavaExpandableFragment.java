package com.example.smy.androidinterview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.List;

public class JavaExpandableFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private static String[] setParentList;
    private static String[] setChildList;

    public static JavaExpandableFragment newInstance(Integer integer, String[] parentList, String[] childList) {
        JavaExpandableFragment javaExpandableFragment = new JavaExpandableFragment();
        setParentList = parentList;
        setChildList = childList;
        Bundle args = new Bundle();
        args.putInt("someInt", integer);
        javaExpandableFragment.setArguments(args);
        return javaExpandableFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        MyExpandableRecyclerAdapter myExpandableRecyclerAdapter = new MyExpandableRecyclerAdapter(getActivity(), generateListItems());
        myExpandableRecyclerAdapter.onRestoreInstanceState(savedInstanceState);
        mRecyclerView.setAdapter(myExpandableRecyclerAdapter);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyExpandableRecyclerAdapter) mRecyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    public List<ParentListItem> generateListItems() {

        List<MyParentListItem> myParentListItems = new ArrayList<>();

        List<ParentListItem> parentListItems = new ArrayList<>();

        for (int i = 0; i < setParentList.length; i++) {
            MyParentListItem eachItem = new MyParentListItem(setParentList[i]);
            myParentListItems.add(eachItem);
        }
        for (MyParentListItem myParentListItem :myParentListItems ) {
            List<MyChildListItem> childItemList = new ArrayList<>();
            childItemList.add(new MyChildListItem(setChildList[myParentListItems.lastIndexOf(myParentListItem)]));
            myParentListItem.setChildItem(childItemList);
            parentListItems.add(myParentListItem);
        }

        return parentListItems;
    }
}

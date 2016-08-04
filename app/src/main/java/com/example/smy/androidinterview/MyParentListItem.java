package com.example.smy.androidinterview;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

public class MyParentListItem implements ParentListItem {

    public String mTitle;
    private List mChildItemList;

    public MyParentListItem(String title) {
        mTitle = title;
    }

       public void setChildItem(List list) {
        mChildItemList = list;
    }

    @Override
    public List<?> getChildItemList() {
        return mChildItemList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}

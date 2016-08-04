package com.example.smy.androidinterview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import java.util.List;

public class MyExpandableRecyclerAdapter extends ExpandableRecyclerAdapter<MyExpandableRecyclerAdapter.MyParentViewHolder, MyExpandableRecyclerAdapter.MyChildViewHolder> {

    private LayoutInflater mInflater;

    public MyExpandableRecyclerAdapter(Context context, List<ParentListItem> itemList) {
        super(itemList);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyParentViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View view = mInflater.inflate(R.layout.parent_item, parentViewGroup, false);
        return new MyParentViewHolder(view);
    }

    @Override
    public MyChildViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View view = mInflater.inflate(R.layout.child_item, childViewGroup, false);
        return new MyChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(MyParentViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        MyParentListItem myParentListItem = (MyParentListItem) parentListItem;
        parentViewHolder.listHeader.setText(myParentListItem.mTitle);
    }

    @Override
    public void onBindChildViewHolder(MyChildViewHolder childViewHolder, int position, Object childListItem) {
        MyChildListItem myChildListItem = (MyChildListItem) childListItem;
        childViewHolder.listChild.setText(myChildListItem.mTitle);
    }

    public class MyParentViewHolder extends ParentViewHolder {

        private static final float INITIAL_POSITION = 0.0f;
        private static final float ROTATED_POSITION = 180f;
        private final boolean HONEYCOMB_AND_ABOVE = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;

        public ImageButton mParentDropDownArrow;
        public TextView listHeader;

        public MyParentViewHolder(View itemView) {
            super(itemView);

            listHeader = (TextView) itemView.findViewById(R.id.parent_list_item);
            mParentDropDownArrow = (ImageButton) itemView.findViewById(R.id.parent_list_item_expand_arrow);
        }

        @SuppressLint("NewApi")
        @Override
        public void setExpanded(boolean expanded) {
            super.setExpanded(expanded);
            if (!HONEYCOMB_AND_ABOVE) {
                return;
            }
            if (expanded) {
                mParentDropDownArrow.setRotation(ROTATED_POSITION);
            } else {
                mParentDropDownArrow.setRotation(INITIAL_POSITION);
            }
        }
    }

    public class MyChildViewHolder extends ChildViewHolder {

        public TextView listChild;

        public MyChildViewHolder(View itemView) {
            super(itemView);

            listChild = (TextView) itemView.findViewById(R.id.child_list_item);
        }
    }

}

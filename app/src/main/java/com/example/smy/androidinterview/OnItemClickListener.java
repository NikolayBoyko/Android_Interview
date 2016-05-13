package com.example.smy.androidinterview;

import android.view.View;

public interface OnItemClickListener {

    void onRowClicked(int position);
    void onViewClicked(View v, int position);
}

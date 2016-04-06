package com.example.smy.androidinterview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    int TOOLBAR_TEXT_COLOR = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Android Interview");
        toolbar.setTitleTextColor(TOOLBAR_TEXT_COLOR);
        setSupportActionBar(toolbar);
    }
}

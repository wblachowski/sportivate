package com.wblachowski.sportivate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}

package com.wblachowski.sportivate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        TextView title = (TextView) findViewById(R.id.eventTitle);
        title.setText(getIntent().getStringExtra("TITLE"));
        TextView snippet = (TextView) findViewById(R.id.eventSnippet);
        snippet.setText(getIntent().getStringExtra("SNIPPET"));
    }
}

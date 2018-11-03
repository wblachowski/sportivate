package com.wblachowski.sportivate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle(getIntent().getStringExtra("TITLE"));
        TextView snippet = (TextView) findViewById(R.id.eventSnippet);
        snippet.setText(getIntent().getStringExtra("SNIPPET"));

        LinearLayout layout = (LinearLayout) findViewById(R.id.eventLayout);
        String[] participants = {"Jan Kowalski","Adam Bednarek","Zdzisław Zamojcin"};
        for(String participant : participants){
            TextView textView = new TextView(this);
            textView.setText(participant);
            layout.addView(textView);
        }
    }
}

package com.wblachowski.sportivate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle(getIntent().getStringExtra("TITLE"));
        TextView snippet = (TextView) findViewById(R.id.eventSnippet);
        snippet.setText(getIntent().getStringExtra("SNIPPET"));
        boolean isYours = getIntent().getBooleanExtra("YOUR",false);


        LinearLayout layout = (LinearLayout) findViewById(R.id.eventLayout);
        String[] participants = {"Jan Kowalski", "Adam Bednarek", "Zdzisław Zamojcin"};
        for (String participant : participants) {
            TextView textView = new TextView(this);
            textView.setText(participant);
            layout.addView(textView);
        }

        Button button = (Button) findViewById(R.id.button);

        if (isYours) {
            button.setText("Odwołaj");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Event event = new Event(getIntent().getStringExtra("TITLE"), getIntent().getStringExtra("SNIPPET"));
                    YourEvents.events.remove(event);
                    Toast.makeText(getApplicationContext(), "Odwołałeś wydarzenie", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        } else {
            if (JoinedEvents.events.contains(new Event(getIntent().getStringExtra("TITLE"), getIntent().getStringExtra("SNIPPET")))) {
                button.setText("Zrezygnuj");
            }
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Event event = new Event(getIntent().getStringExtra("TITLE"), getIntent().getStringExtra("SNIPPET"));

                    if (JoinedEvents.events.contains(event)) {
                        JoinedEvents.events.remove(event);
                        Toast.makeText(getApplicationContext(), "Zrezygnowałeś z wydarzenia", Toast.LENGTH_SHORT).show();
                    } else {
                        JoinedEvents.events.add(event);
                        Toast.makeText(getApplicationContext(), "Dołączyłeś do wydarzenia", Toast.LENGTH_SHORT).show();
                    }
                    finish();
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

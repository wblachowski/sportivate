package com.wblachowski.sportivate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wblachowski on 11/3/2018.
 */

public class EventsAdapter extends ArrayAdapter<Event> {
    public EventsAdapter(Context context, ArrayList<Event> events){
        super(context,0,events);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Event event = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_item, parent, false);
        }
        // Lookup view for data population
        TextView eiTitle = convertView.findViewById(R.id.eiTitle);
        TextView eiWhen = convertView.findViewById(R.id.eiWhen);
        // Populate the data into the template view using the data object
        eiTitle.setText(event.getTitle());
        String when = event.getSnippet().split("\\n")[0];
        eiWhen.setText(when);
        // Return the completed view to render on screen
        return convertView;
    }

}

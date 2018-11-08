package com.wblachowski.sportivate;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by wblachowski on 11/4/2018.
 */

public class YourEventsFragment extends Fragment {

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_your_events, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = getActivity().findViewById(R.id.listviewYour);
        EventsAdapter adapter = new EventsAdapter(getActivity(), YourEvents.events);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Event event = YourEvents.events.get(i);
                Intent intent = new Intent(getActivity(), EventDetailsActivity.class);
                intent.putExtra("TITLE", event.getTitle());
                intent.putExtra("SNIPPET", event.getSnippet());
                intent.putExtra("YOUR", true);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        listView.invalidateViews();
    }
}

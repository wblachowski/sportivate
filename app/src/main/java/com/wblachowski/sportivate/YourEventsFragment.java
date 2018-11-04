package com.wblachowski.sportivate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        listView =  getActivity().findViewById(R.id.listview);
        EventsAdapter adapter = new EventsAdapter(getActivity(), YourEvents.events);
        listView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        listView.invalidateViews();
    }
}

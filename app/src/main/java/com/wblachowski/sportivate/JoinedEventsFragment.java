package com.wblachowski.sportivate;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by wblachowski on 11/3/2018.
 */

public class JoinedEventsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_joined_events, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView =  getActivity().findViewById(R.id.listview);
        EventsAdapter adapter = new EventsAdapter(getActivity(), JoinedEvents.events);
        listView.setAdapter(adapter);
    }
}

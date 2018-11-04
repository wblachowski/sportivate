package com.wblachowski.sportivate;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by wblachowski on 11/3/2018.
 */

public class EventsMapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private ArrayList<Marker> markers = new ArrayList<>();
    private ArrayList<Marker> yourMarkers = new ArrayList<>();
    GoogleMap googleMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MapFragment fragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);

        FloatingActionButton newActivityButton = view.findViewById(R.id.fab);
        newActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NewEventActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getActivity(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }
        });
        googleMap.setOnInfoWindowClickListener(this);

        LatLng putLocation = new LatLng(52.4041498, 16.9503366);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(putLocation, 16.5f));
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        markers.add(googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4024143, 16.949)).title("Mecz piłki nożnej").snippet("Dziś: 18:00-19:30\nWolnych miejsc: 4")));
        markers.add(googleMap.addMarker(new MarkerOptions().position(new LatLng(52.3963452, 16.937572)).title("Debel w tenisa").snippet("Jutro: 11:00-12:00\nWolnych miejsc: 1")));
        markers.add(googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4057828, 16.9278278)).title("Mecz piłki nożnej halowej").snippet("Dziś: 15:30-16:30\nWolnych miejsc: 2")));
        markers.add(googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4128263, 16.9508353)).title("Mecz piłki nożnej").snippet("Dziś: 11:00-12:30\nWolnych miejsc: 4")));
        markers.add(googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4191863, 16.9303593)).title("Bieganie - 10km").snippet("Dziś: 18:00-19:00")));
        markers.add(googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4180383, 16.9208803)).title("Mecz piłki nożnej").snippet("Dziś: 12:00-13:30\nWolnych miejsc: 1")));
        markers.add(googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4061093, 16.9548363)).title("Bieganie - 10km").snippet("Dziś: 18:00-19:30")));
        markers.add(googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4107993, 16.9743443)).title("Mecz koszykówki").snippet("Dziś: 20:00-21:30\nWolnych miejsc: 6")));
        markers.add(googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4099693, 16.9387593)).title("Mecz siatkówki").snippet("Dziś: 15:00-16:00\nWolnych miejsc: 1")));
        for (Event event : YourEvents.events) {
            yourMarkers.add(googleMap.addMarker(new MarkerOptions().position(event.getLatlng()).title(event.getTitle()).snippet(event.getSnippet())));
        }
        for (Marker marker : markers) {
            if (JoinedEvents.events.contains(new Event(marker.getTitle(), marker.getSnippet()))) {
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            } else {
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            }
        }
        for (Marker marker : yourMarkers) {
            marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent(getActivity(), EventDetailsActivity.class);
        intent.putExtra("TITLE", marker.getTitle());
        intent.putExtra("SNIPPET", marker.getSnippet());
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        for (Marker marker : markers) {
            if (JoinedEvents.events.contains(new Event(marker.getTitle(), marker.getSnippet()))) {
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            } else {
                marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            }
        }
        yourMarkers.clear();
        if (googleMap != null) {
            for (Event event : YourEvents.events) {
                yourMarkers.add(googleMap.addMarker(new MarkerOptions().position(event.getLatlng()).title(event.getTitle()).snippet(event.getSnippet())));
            }
        }
        for (Marker marker : yourMarkers) {
            marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        }
    }
}

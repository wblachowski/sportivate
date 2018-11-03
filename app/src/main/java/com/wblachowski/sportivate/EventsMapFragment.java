package com.wblachowski.sportivate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by wblachowski on 11/3/2018.
 */

public class EventsMapFragment extends Fragment implements OnMapReadyCallback {

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
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng putLocation = new LatLng(52.4041498,16.9503366);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(putLocation,16.5f));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4024143,16.949)).title("Mecz piłki nożnej"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(52.3963452,16.937572)).title("Debel w tenisa"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4057828,16.9278278)).title("Mecz piłki nożnej halowej"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4128263,16.9508353)).title("Mecz piłki nożnej"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4191863,16.9303593)).title("Bieganie - 10km"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4180383,16.9208803)).title("Mecz piłki nożnej"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4061093,16.9548363)).title("Bieganie - 10km"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4107993,16.9743443)).title("Mecz koszykówki"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(52.4099693,16.9387593)).title("Mecz siatkówki"));
    }
}

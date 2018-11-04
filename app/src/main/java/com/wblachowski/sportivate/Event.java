package com.wblachowski.sportivate;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by wblachowski on 11/3/2018.
 */

public class Event {

    private String title;
    private String snippet;
    private LatLng latlng;

    public Event(String title, String snippet){
        this.title=title;
        this.snippet=snippet;
    }


    public void setLatlng(LatLng latlng) {
        this.latlng = latlng;
    }

    public String getTitle() {
        return title;
    }

    public String getSnippet() {
        return snippet;
    }

    public LatLng getLatlng() {
        return latlng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (title != null ? !title.equals(event.title) : event.title != null) return false;
        return snippet != null ? snippet.equals(event.snippet) : event.snippet == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (snippet != null ? snippet.hashCode() : 0);
        return result;
    }
}

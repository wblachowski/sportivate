package com.wblachowski.sportivate;

/**
 * Created by wblachowski on 11/3/2018.
 */

public class Event {

    private String title;
    private String snippet;

    public Event(String title, String snippet){
        this.title=title;
        this.snippet=snippet;
    }

    public String getTitle() {
        return title;
    }

    public String getSnippet() {
        return snippet;
    }
}

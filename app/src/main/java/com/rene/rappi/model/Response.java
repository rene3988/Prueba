package com.rene.rappi.model;

import org.json.JSONObject;

/**
 * Created by Rene on 03/11/2015.
 */
public class Response {

    public static final String KEY_FEED      = "feed";


    private Feed feed;


    public Response(JSONObject object) {
        if(object!=null){
            this.setFeed(object.optJSONObject(KEY_FEED));
        }
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(JSONObject object) {
        this.feed = new Feed(object);
    }
}

package com.rene.rappi.model;

import org.json.JSONObject;

/**
 * Created by Rene on 03/11/2015.
 */
public class Author {

    public static final String KEY_NAME  = "name";
    public static final String KEY_URI   = "uri";



    private Name name;
    private URI uri;

    public Author(JSONObject object) {
        if(object!=null){
            this.setName(object.optJSONObject(KEY_NAME));
            this.setUri(object.optJSONObject(KEY_URI));
        }
    }

    public Name getName() {
        return name;
    }

    public void setName(JSONObject object) {
        this.name = new Name(object);
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(JSONObject object) {
        this.uri = new URI(object);
    }
}

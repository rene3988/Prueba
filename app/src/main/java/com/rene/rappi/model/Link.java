package com.rene.rappi.model;

import org.json.JSONObject;

/**
 * Created by Rene on 03/11/2015.
 */
public class Link {

    public static final String KEY_ATTRIBUTES  = "attributes";


    private Attributes attributes;


    public Link(JSONObject object) {
        if(object!=null){
            this.setAttributes(object.optJSONObject(KEY_ATTRIBUTES));
        }
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(JSONObject object) {
        this.attributes = new Attributes(object);
    }
}

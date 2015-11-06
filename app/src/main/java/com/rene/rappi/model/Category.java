package com.rene.rappi.model;

import org.json.JSONObject;

/**
 * Created by Rene on 04/11/2015.
 */
public class Category {

    public static final String KEY_ATTRIBUTES   = "attributes";

    private Attributes attributes;


    public Category(JSONObject object) {
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

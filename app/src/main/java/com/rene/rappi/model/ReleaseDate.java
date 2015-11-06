package com.rene.rappi.model;

import org.json.JSONObject;

/**
 * Created by Rene on 04/11/2015.
 */
public class ReleaseDate {

    public static final String KEY_LABEL        = "label";
    public static final String KEY_ATTRIBUTES   = "attributes";

    private String label;
    private Attributes attributes;


    public ReleaseDate(JSONObject object) {
        if(object!=null){
            this.setLabel(object.optString(KEY_LABEL));
            this.setAttributes(object.optJSONObject(KEY_ATTRIBUTES));
        }
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(JSONObject object) {
        this.attributes = new Attributes(object);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

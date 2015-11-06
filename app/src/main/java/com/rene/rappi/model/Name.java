package com.rene.rappi.model;

import org.json.JSONObject;

/**
 * Created by Rene on 03/11/2015.
 */
public class Name {

    public static final String KEY_LABEL  = "label";


    private String label;


    public Name(JSONObject object) {
        if(object!=null){
            this.setLabel(object.optString(KEY_LABEL));
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

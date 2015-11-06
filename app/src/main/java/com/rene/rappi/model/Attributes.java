package com.rene.rappi.model;

import org.json.JSONObject;

/**
 * Created by Rene on 03/11/2015.
 */
public class Attributes {


    public static final String KEY_HREF      = "href";
    public static final String KEY_REL       = "rel";
    public static final String KEY_TYPE      = "type";
    public static final String KEY_LABEL     = "label";
    public static final String KEY_ID        = "im:id";
    public static final String KEY_TERM      = "term";
    public static final String KEY_SCHEME    = "scheme";
    public static final String KEY_BUNDLEDID = "im:bundleId";
    public static final String KEY_AMOUNT    = "amount";
    public static final String KEY_CURRENCY  = "currency";
    public static final String KEY_HEIGHT    =  "height";


    private String label;
    private String href;
    private String rel;
    private String type;
    private String id;
    private String term;
    private String scheme;
    private String bundleId;
    private String amount;
    private String currency;
    private String height;


    public Attributes(JSONObject object) {
        if(object!=null){
            this.setHref(object.optString(KEY_HREF));
            this.setRel(object.optString(KEY_REL));
            this.setType(object.optString(KEY_TYPE));
            this.setLabel(object.optString(KEY_LABEL));
            this.setId(object.optString(KEY_ID));
            this.setTerm(object.optString(KEY_TERM));
            this.setScheme(object.optString(KEY_SCHEME));
            this.setBundleId(object.optString(KEY_BUNDLEDID));
            this.setAmount(object.optString(KEY_AMOUNT));
            this.setCurrency(object.optString(KEY_CURRENCY));
            this.setHeight(object.optString(KEY_HEIGHT));
        }
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

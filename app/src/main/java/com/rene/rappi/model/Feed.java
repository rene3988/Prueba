package com.rene.rappi.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rene on 03/11/2015.
 */
public class Feed {

    public static final String KEY_AUTHOR  = "author";
    public static final String KEY_ENTRY   = "entry";
    public static final String KEY_ICON    = "icon";
    public static final String KEY_ID      = "id";
    public static final String KEY_LINK    = "link";
    public static final String KEY_RIGHTS  = "rights";
    public static final String KEY_TITLE   = "title";
    public static final String KEY_UPDATE  = "update";

    private Author author;
    private List<Entry> entryList;
    private Icon icon;
    private Id id;
    private List<Link> linkList;
    private Rights rights;
    private Title title;
    private Update update;


    public Feed(JSONObject object) {
        if(object!=null){
            this.setAuthor(object.optJSONObject(KEY_AUTHOR));
            this.setEntryList(object.optJSONArray(KEY_ENTRY));
            this.setIcon(object.optJSONObject(KEY_ICON));
            this.setId(object.optJSONObject(KEY_ID));
            this.setLinkList(object.optJSONArray(KEY_LINK));
            this.setRights(object.optJSONObject(KEY_RIGHTS));
            this.setTitle(object.optJSONObject(KEY_TITLE));
            this.setUpdate(object.optJSONObject(KEY_UPDATE));
        }

    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(JSONObject object) {
        this.author = new Author(object);
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(JSONArray array) {
        if(array != null){
            entryList = new ArrayList<Entry>();
            int size = array.length();
            if(size>0){
                for (int i=0 ; i < size ; i++){
                    Entry c = new Entry(array.optJSONObject(i));
                    entryList.add(c);
                }
            }
        }
    }

    public List<Link> getLinkList() {
        return linkList;
    }

    public void setLinkList(JSONArray array) {
        if(array != null){
            linkList = new ArrayList<Link>();
            int size = array.length();
            if(size>0){
                for (int i=0 ; i < size ; i++){
                    Link c = new Link(array.optJSONObject(i));
                    linkList.add(c);
                }
            }
        }
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(JSONObject object) {
        this.icon = new Icon(object);
    }

    public Id getId() {
        return id;
    }

    public void setId(JSONObject object) {
        this.id = new Id(object);
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(JSONObject object) {
        this.rights = new Rights(object);
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(JSONObject object) {
        this.title = new Title(object);
    }

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(JSONObject object) {
        this.update = new Update(object);
    }
}

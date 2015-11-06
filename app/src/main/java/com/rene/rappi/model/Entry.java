package com.rene.rappi.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rene on 03/11/2015.
 */
public class Entry {

    public static final String KEY_NAME         = "im:name";
    public static final String KEY_IMAGE        = "im:image";
    public static final String KEY_SUMMARY      = "summary";
    public static final String KEY_PRICE        = "im:price";
    public static final String KEY_CONTENTTYPE  = "im:contentType";
    public static final String KEY_RIGHTS       = "rights";
    public static final String KEY_TITLE        = "title";
    public static final String KEY_LINK         = "link";
    public static final String KEY_ID           = "id";
    public static final String KEY_ARTIST       = "im:artist";
    public static final String KEY_CATEGORY     = "category";
    public static final String KEY_RELEASEDATE  = "im:releaseDate";

    private List<Image> imageList;
    private Name name;
    private Summary summary;
    private Price price;
    private ContentType contentType;
    private Rights rights;
    private Title title;
    private Link link;
    private Id id;
    private Artist artist;
    private Category category;
    private ReleaseDate releaseDate;


    public Entry(JSONObject object) {
        if(object!=null){
            this.setName(object.optJSONObject(KEY_NAME));
            this.setImageList(object.optJSONArray(KEY_IMAGE));
            this.setSummary(object.optJSONObject(KEY_SUMMARY));
            this.setPrice(object.optJSONObject(KEY_PRICE));
            this.setContentType(object.optJSONObject(KEY_CONTENTTYPE));
            this.setRights(object.optJSONObject(KEY_RIGHTS));
            this.setTitle(object.optJSONObject(KEY_TITLE));
            this.setLink(object.optJSONObject(KEY_LINK));
            this.setId(object.optJSONObject(KEY_ID));
            this.setArtist(object.optJSONObject(KEY_ARTIST));
            this.setCategory(object.optJSONObject(KEY_CATEGORY));
            this.setReleaseDate(object.optJSONObject(KEY_RELEASEDATE));
        }
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(JSONArray array) {
        if(array != null){
            imageList = new ArrayList<Image>();
            int size = array.length();
            if(size>0){
                for (int i=0 ; i < size ; i++){
                    Image c = new Image(array.optJSONObject(i));
                    imageList.add(c);
                }
            }
        }
    }

    public Name getName() {
        return name;
    }

    public void setName(JSONObject object) {
        this.name = new Name(object);
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(JSONObject object) {
        this.summary = new Summary(object);
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(JSONObject object) {
        this.price = new Price(object);
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(JSONObject object) {
        this.contentType = new ContentType(object);
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

    public Link getLink() {
        return link;
    }

    public void setLink(JSONObject object) {
        this.link = new Link(object);
    }

    public Id getId() {
        return id;
    }

    public void setId(JSONObject object) {
        this.id = new Id(object);
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(JSONObject object) {
        this.artist = new Artist(object);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(JSONObject object) {
        this.category = new Category(object);
    }

    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(JSONObject object) {
        this.releaseDate = new ReleaseDate(object);
    }
}

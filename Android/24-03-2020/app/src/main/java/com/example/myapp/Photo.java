package com.example.myapp;

import org.json.JSONObject;

public class Photo {
    private Integer id;
    private Integer albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

    public static Photo createFromJSONObject(JSONObject object) {
        try {
            Photo photo = new Photo();
            photo.id = object.getInt("id");
            photo.albumId = object.getInt("albumId");
            photo.title = object.getString("title");
            photo.url = object.getString("url");
            photo.thumbnailUrl = object.getString("thumbnailUrl");
            return photo;
        } catch (Exception e) {
            return null;
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}

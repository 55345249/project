package com.primeton.domain;

public class Img {

    private String id;
    private String picture;
    private String describe;


    public Img() {
    }

    public Img(String id, String picture, String describe) {
        this.id = id;
        this.picture = picture;
        this.describe = describe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}

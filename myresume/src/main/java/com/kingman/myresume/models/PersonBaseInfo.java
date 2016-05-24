package com.kingman.myresume.models;

/**
 * Created by wb-lijinwei.a on 2016/5/24.
 */
public class PersonBaseInfo {
    private int imgID;
    private String title;
    private String value;

    public PersonBaseInfo(int imgID, String title, String value) {
        this.imgID = imgID;
        this.title = title;
        this.value = value;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

package com.example.retrofit_sample.DataModel;

import com.google.gson.annotations.SerializedName;

public class PostDataModel {

    private int userId;

    private int id;

    private String title;

    @SerializedName("body")
    private String text;

    //Generate gets
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}

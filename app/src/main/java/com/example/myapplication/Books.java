package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

import java.util.List;

public class Books {
    @SerializedName("Author")
    @Expose
    public String Author = null;
    @SerializedName("Genre")
    @Expose
    public String Genre = null;
    @SerializedName("Name")
    @Expose
    public String Name = null;
    @SerializedName("rating")
    @Expose
    public Integer rating = null;

    public String getName() {
        return Name;
    }
}

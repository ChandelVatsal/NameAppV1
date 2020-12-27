package com.example.namesproject;

import com.google.gson.annotations.SerializedName;

public class Human {
    @SerializedName("name")
    private String name;
    @SerializedName("gender")
    private String gender;
    @SerializedName("meaning")
    private String meaning;
    @SerializedName("origin")
    private String origin;
    @SerializedName("comments")
    private String comments;


    public Human(String name, String gender, String meaning, String origin, String comments){
        this.name = name;
        this.gender = gender;
        this.meaning = meaning;
        this.origin = origin;
        this.comments = comments;
    }

    public String getName(){
        return name;
    }

    public String getGender(){
        return gender;
    }

    public String getMeaning(){
        return meaning;
    }

    public String getOrigin() {
        return origin;
    }

    public String getComments(){
        return comments;
    }
}

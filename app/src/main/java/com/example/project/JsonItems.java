package com.example.project;

import com.google.gson.annotations.SerializedName;

public class JsonItems {
    private String ID;
    private String name;
    @SerializedName("type")
    private String login;

    private String company;
    private String location;
    private String category;
    @SerializedName("size")
    private int area;
    @SerializedName("cost")
    private int volume;

    public JsonItems(String ID, String name, String login, String company, String location, String category, int area, int volume){
        this.ID = ID;
        this.name = name;
        this.login = login;
        this.company = company;
        this.location = location;
        this.category = category;
        this.area = area;
        this.volume = volume;
    }

    public String toStringID(){
        return ID;
    }

    public String toStringName(){
        return name;
    }

    public String toStringLogin(){
        return login;
    }

    public String toStringLocation(){
        return location;
    }

    public int toStringSize(){
        return area;
    }

    public int toStringCost(){
        return volume;
    }
}

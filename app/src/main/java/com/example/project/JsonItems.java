package com.example.project;

import com.google.gson.annotations.SerializedName;

public class JsonItems {
    @SerializedName("ID")
    private String time;
    private String name;
    private String login;
    @SerializedName("company")
    private String players;
    private String location;
    private String category;
    @SerializedName("size")
    private int area;
    @SerializedName("cost")
    private int volume;

    public JsonItems(String time, String name, String login, String players, String location, String category, int area, int volume){
        this.time = time;
        this.name = name;
        this.login = login;
        this.players = players;
        this.location = location;
        this.category = category;
        this.area = area;
        this.volume = volume;
    }

    public String toStringTime(){
        return time;
    }

    public String toStringName(){
        return name;
    }

    public String toStringPlayers(){
        return players;
    }

    public String toStringLocation(){
        return location;
    }
}


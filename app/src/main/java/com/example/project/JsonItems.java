package com.example.project;

public class JsonItems {
    private String ID;
    private String name;
    private String type;
    private String location;

    public JsonItems(String ID, String name, String type, String location){
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.location = location;
    }

    @Override
    public String toString(){

        return ID + ", " + name + ", " + type + ", " + location;
    }
}

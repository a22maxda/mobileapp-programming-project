package com.example.project;

public class JsonItems {
    private String ID;
    private String name;
    private String type;
    private String company;
    private String location;
    private String category;
    private int size;
    private int cost;

    public JsonItems(String ID, String name, String type, String company, String location, String category, int size, int cost){
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.company = company;
        this.location = location;
        this.category = category;
        this.size = size;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return ID + ", " + name + ", " + type + ", " + company + ", " + location + ", " + category + ", " + size + ", " + cost + ", " + "\n";
    }
}
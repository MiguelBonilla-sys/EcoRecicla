package com.example.ecorecicla.Models;

public class dataRecycling {
    private String type;
    private String date;
    private String weight;

    public dataRecycling(String type, String date, String weight) {
        this.type = type;
        this.date = date;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }



}

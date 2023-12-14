package com.example.ecorecicla.Models;

public class dataRecycling {
    public String type;
    public String date;
    public String weight;
    public String precio;
    public dataRecycling(String type, String date, String weight, String precio) {
        this.type = type;
        this.date = date;
        this.weight = weight;
        this.precio = precio;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
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

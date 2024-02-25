package com.example.travelapp;

import java.util.ArrayList;

public class destinationModel {

    public String id, name, capital, about, climate, history, time, food;
   public ArrayList<String> img = new ArrayList<>();
 public   ArrayList<String>  tourist = new ArrayList<>();
   public ArrayList<productsModel> products = new ArrayList<>();



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public ArrayList<String> getImg() {
        return img;
    }

    public void setImg(ArrayList<String> img) {
        this.img = img;
    }

    public ArrayList<productsModel> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<productsModel> products) {
        this.products = products;
    }

    public ArrayList<String> getTourist() {
        return tourist;
    }

    public void setTourist(ArrayList<String> tourist) {
        this.tourist = tourist;
    }
}

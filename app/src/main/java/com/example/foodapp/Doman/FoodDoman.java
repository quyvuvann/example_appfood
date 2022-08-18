package com.example.foodapp.Doman;

import java.io.Serializable;

public class FoodDoman implements Serializable {
    public String tiltle;
    public String imgage;
    public String description;
    Double fee;
    public int start;
    public int time;
    public int calories;
    public int numberIntCart;

    public FoodDoman(String tiltle, String imgage, String description, Double fee, int start, int time, int calories) {
        this.tiltle = tiltle;
        this.imgage = imgage;
        this.description = description;
        this.fee = fee;
        this.start = start;
        this.time = time;
        this.calories = calories;
    }

    public int getNumberIntCart() {
        return numberIntCart;
    }

    public void setNumberIntCart(int numberIntCart) {
        this.numberIntCart = numberIntCart;
    }

    public String getTiltle() {
        return tiltle;
    }

    public void setTiltle(String tiltle) {
        this.tiltle = tiltle;
    }

    public String getImgage() {
        return imgage;
    }

    public void setImgage(String imgage) {
        this.imgage = imgage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}

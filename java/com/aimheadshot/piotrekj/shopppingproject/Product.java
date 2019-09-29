package com.aimheadshot.piotrekj.shopppingproject;

import java.io.Serializable;


public class Product implements Serializable {
    private String name;
    private double shopsPrice;
    private int counter;
    private int id;


    public Product(){

    }

    public Product(String name, double shopsPrice, int id) {
        this.name = name;
        this.shopsPrice = shopsPrice;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getShopsPrice() {
        return shopsPrice;
    }

    public void setShopsPrice(int shopsPrice) {
        this.shopsPrice = shopsPrice;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "name: " + name + ", shopsPrice: " + shopsPrice;
    }
}

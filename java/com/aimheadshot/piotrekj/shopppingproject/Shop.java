package com.aimheadshot.piotrekj.shopppingproject;


public class Shop {
    private String title;
    private String description;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shop(String title, String description, int id)
    {
        this.title = title;
        this.description = description;
        this.id=id;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "title: " + title + ", description: " + description;
    }


}

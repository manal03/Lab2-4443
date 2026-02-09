package com.example.lab2_4443;
//Model class, initializing data objects
public class ItemModel {
    String title;
    int imageResId;
    String description;

    String detailedDescription;
    String fullTitle;

    public ItemModel(String title, String description, int imageResId, String detailedDescription, String fullTitle) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
        this.detailedDescription = detailedDescription;
        this.fullTitle = fullTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDetailedDescription(){ return detailedDescription;}
    public int getImageResId() {
        return imageResId;
    }
    public String getFullTitle(){ return fullTitle; }
}

package com.example.mealsapp.domain.entity;

public class Meal {
    public String id, category, mealImage, description;

    public Meal(String id, String category, String mealImage, String description) {
        this.id = id;
        this.category = category;
        this.mealImage = mealImage;
        this.description = description;
    }
}

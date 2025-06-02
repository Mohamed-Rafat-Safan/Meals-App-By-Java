package com.example.mealsapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {
    @SerializedName("categories")
    public List<MealDto> categories;
}

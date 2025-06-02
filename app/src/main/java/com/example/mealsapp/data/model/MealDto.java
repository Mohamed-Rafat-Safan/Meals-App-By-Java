package com.example.mealsapp.data.model;

import com.google.gson.annotations.SerializedName;

public class MealDto {
    @SerializedName("idCategory")
    public String id;
    @SerializedName("strCategory")
    public String category;
    @SerializedName("strCategoryThumb")
    public String mealImage;
    @SerializedName("strCategoryDescription")
    public String description;
}

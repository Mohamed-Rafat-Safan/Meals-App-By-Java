package com.example.mealsapp.data.remote;

import com.example.mealsapp.data.model.CategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MealApiService {
    @GET("categories.php")
    Call<CategoryResponse> getCategories();
}

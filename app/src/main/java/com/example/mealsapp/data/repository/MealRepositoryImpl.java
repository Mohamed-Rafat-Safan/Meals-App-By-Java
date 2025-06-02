package com.example.mealsapp.data.repository;

import com.example.mealsapp.data.model.CategoryResponse;
import com.example.mealsapp.data.model.MealDto;
import com.example.mealsapp.data.remote.MealApiService;
import com.example.mealsapp.domain.entity.Meal;
import com.example.mealsapp.domain.repository.MealCallback;
import com.example.mealsapp.domain.repository.MealRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealRepositoryImpl implements MealRepository {
    private final MealApiService api;

    public MealRepositoryImpl(MealApiService api) {
        this.api = api;
    }

    @Override
    public void getMeals(MealCallback mealCallback) {
        api.getCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Meal> meals = new ArrayList<>();
                    for (MealDto mealDto : response.body().categories) {
                        meals.add(new Meal(mealDto.id, mealDto.category, mealDto.mealImage, mealDto.description));
                    }
                    mealCallback.onSuccess(meals);

                } else {
                    mealCallback.onError("Empty or Error response");
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                mealCallback.onError(t.getMessage());
            }
        });
    }
}

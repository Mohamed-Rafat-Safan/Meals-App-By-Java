package com.example.mealsapp.domain.repository;

import com.example.mealsapp.domain.entity.Meal;

import java.util.List;

public interface MealCallback {
    void onSuccess(List<Meal> meals);
    void onError(String errorMessage);
}

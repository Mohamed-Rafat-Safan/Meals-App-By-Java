package com.example.mealsapp.domain.use_case;

import com.example.mealsapp.domain.repository.MealCallback;
import com.example.mealsapp.domain.repository.MealRepository;

public class GetMealsUseCase {
    private final MealRepository mealRepository;

    public GetMealsUseCase(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void execute(MealCallback mealCallback) {
        mealRepository.getMeals(mealCallback);
    }
}

package com.example.mealsapp.presentation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mealsapp.domain.entity.Meal;
import com.example.mealsapp.domain.repository.MealCallback;
import com.example.mealsapp.domain.use_case.GetMealsUseCase;
import com.example.mealsapp.utils.Resource;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MealViewModel extends ViewModel {
    private final MutableLiveData<Resource<List<Meal>>> mealsLiveData = new MutableLiveData<>();
    private final GetMealsUseCase getMealsUseCase;

    @Inject
    public MealViewModel(GetMealsUseCase getMealsUseCase) {
        this.getMealsUseCase = getMealsUseCase;
    }

    public MutableLiveData<Resource<List<Meal>>> getMealsLiveData() {
        return mealsLiveData;
    }

    public void fetchMeals() {
        mealsLiveData.setValue(Resource.loading());
        getMealsUseCase.execute(new MealCallback() {
            @Override
            public void onSuccess(List<Meal> meals) {
                mealsLiveData.setValue(Resource.success(meals));
            }

            @Override
            public void onError(String errorMessage) {
                mealsLiveData.setValue(Resource.error(errorMessage));
            }
        });
    }

}

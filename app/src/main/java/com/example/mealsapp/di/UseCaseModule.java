package com.example.mealsapp.di;

import com.example.mealsapp.domain.repository.MealRepository;
import com.example.mealsapp.domain.use_case.GetMealsUseCase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class UseCaseModule {

    @Provides
    public GetMealsUseCase provideGetMealsUseCase(MealRepository repository) {
        return new GetMealsUseCase(repository);
    }
}

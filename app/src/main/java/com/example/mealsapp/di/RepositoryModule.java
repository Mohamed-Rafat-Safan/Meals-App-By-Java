package com.example.mealsapp.di;

import com.example.mealsapp.data.remote.MealApiService;
import com.example.mealsapp.data.repository.MealRepositoryImpl;
import com.example.mealsapp.domain.repository.MealRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {
    @Provides
    public MealRepository provideMealRepository(MealApiService apiService) {
        return new MealRepositoryImpl(apiService);
    }
}

package com.example.mealsapp.presentation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.mealsapp.R;
import com.example.mealsapp.data.remote.MealApiService;
import com.example.mealsapp.data.repository.MealRepositoryImpl;
import com.example.mealsapp.databinding.ActivityMainBinding;
import com.example.mealsapp.domain.repository.MealRepository;
import com.example.mealsapp.domain.use_case.GetMealsUseCase;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private MealViewModel mealViewModel;
    private MealAdapter mealAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));

        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);
        mealAdapter = new MealAdapter();
        binding.rvMeals.setAdapter(mealAdapter);


        mealViewModel.fetchMeals();
        mealViewModel.getMealsLiveData().observe(this, resource -> {
            switch (resource.status) {
                case LOADING:
                    binding.progressBar.setVisibility(View.VISIBLE);
                    break;

                case SUCCESS:
                    binding.progressBar.setVisibility(View.GONE);
                    mealAdapter.setMeals(resource.data);
                    break;

                case ERROR:
                    binding.progressBar.setVisibility(View.GONE);
                    Log.e("MainActivity", "Error: " + resource.message);
                    Toast.makeText(this, resource.message, Toast.LENGTH_SHORT).show();
                    break;
            }
        });

    }
}

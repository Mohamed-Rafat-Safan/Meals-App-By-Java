package com.example.mealsapp.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mealsapp.R;
import com.example.mealsapp.domain.entity.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealsViewHolder> {
    private List<Meal> meals = new ArrayList<>();

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MealsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MealsViewHolder holder, int position) {
        Meal meal = meals.get(position);

        holder.bind(meal);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class MealsViewHolder extends RecyclerView.ViewHolder {
        public MealsViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(Meal meal) {
            ImageView iv_meal_image = itemView.findViewById(R.id.meal_image);
            TextView tv_meal_name = itemView.findViewById(R.id.meal_name);
            TextView tv_meal_des = itemView.findViewById(R.id.meal_des);

            Glide.with(itemView.getContext())
                    .load(meal.mealImage)
                    .into(iv_meal_image);

            tv_meal_name.setText(meal.category);
            tv_meal_des.setText(meal.description);
        }
    }

}

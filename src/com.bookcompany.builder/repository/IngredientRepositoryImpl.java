package com.bookcompany.builder.repository;

import com.bookcompany.builder.Entities.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientRepositoryImpl implements IngredientRepository{

    private final List<Ingredient> ingredients = new ArrayList<>();

    @Override
    public boolean createIngredient(Ingredient ingredient) {
        if(ingredient == null){
            return false;
        }
        try {
            ingredients.add(ingredient);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public Ingredient readIngredient(String name) {
        for(Ingredient ingredient: ingredients){
            if(ingredient.getName().equals(name)){
                return ingredient;
            }
        }
        return null;
    }

    @Override
    public List<Ingredient> readIngredients() {
        return ingredients;
    }

    @Override
    public boolean deleteIngredient(String name) {
        for(Ingredient ingredient: ingredients){
            if(ingredient.getName().equals(name)){
                ingredients.remove(ingredient);
                return true;
            }
        }
        return false;
    }
}

package com.bookcompany.builder.repository;

import com.bookcompany.builder.Entities.Ingredient;

import java.util.List;

public interface IngredientRepository {
    boolean createIngredient(Ingredient ingredient);

    Ingredient readIngredient(String name);

    List<Ingredient> readIngredients();

    boolean deleteIngredient(String name);
}


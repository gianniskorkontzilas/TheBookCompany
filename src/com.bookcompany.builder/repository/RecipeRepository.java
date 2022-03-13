package com.bookcompany.builder.repository;

import com.bookcompany.builder.Entities.Recipe;

import java.util.List;

public interface RecipeRepository {
    boolean createRecipe(Recipe recipe);

    Recipe readRecipe(String name, int time);

    List<Recipe> readRecipes();

    boolean deleteRecipe(String name, int time);

    boolean deleteAllRecipes();

}
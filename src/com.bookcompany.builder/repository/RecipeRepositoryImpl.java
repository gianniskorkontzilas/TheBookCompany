package com.bookcompany.builder.repository;

import com.bookcompany.builder.Entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeRepositoryImpl implements RecipeRepository {

    private final List<Recipe> recipes = new ArrayList<>();

    @Override
    public boolean createRecipe(Recipe recipe) {
        if (recipe == null) {
            return false;
        }
        try {
            recipes.add(recipe);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public Recipe readRecipe(String name, int time) {
        return null;
    }

    @Override
    public List<Recipe> readRecipes() {
        return recipes;
    }

    @Override
    public boolean deleteRecipe(String name, int time) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equals(name) && recipe.getPreparationTime() == time) {
                recipes.remove(recipe);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteAllRecipes() {
        if (!recipes.isEmpty()) {
            List<Recipe> tempRecipesList = new ArrayList<>();
            tempRecipesList.addAll(recipes);
            for (Recipe recipe : tempRecipesList) {
                System.out.println(recipe);
                recipes.remove(recipe);
            }
        }
        return true;
    }
}

package com.bookcompany.builder.service;

import com.bookcompany.builder.model.Ingredient;
import com.bookcompany.builder.model.Recipe;
import com.bookcompany.builder.repository.IngredientRepository;
import com.bookcompany.builder.repository.RecipeRepository;


import java.io.IOException;
import java.util.List;

public interface RecipeService {
    IngredientRepository<Recipe> loadRecipes(String recipeName, IngredientRepository<Ingredient> listOfIngredients) throws IOException;
    void printRecipesByName(IngredientRepository<Recipe> listOfRecipes);
    void printRecipesByPreparationTime(IngredientRepository<Recipe> listOfRecipes);
    List<String> printVegetarianRecipes(IngredientRepository<Recipe> listOfRecipes);
    List<String> returnedRecipes(IngredientRepository<Recipe> listOfRecipes, IngredientRepository<Ingredient> listOfIngredients, String ingredient);
    List<String> searchRangeOfCalories(IngredientRepository<Recipe> listOfRecipes, IngredientRepository<Ingredient> listOfIngredients, int fromCalories, int toCalories);
    void listIngredientsForRecipes(List<Recipe> listWithRecipes, IngredientRepository<Ingredient> listOfIngredients);



}

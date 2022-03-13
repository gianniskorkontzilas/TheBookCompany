package com.bookcompany.builder.service;

import com.bookcompany.builder.model.Ingredient;
import com.bookcompany.builder.model.Recipe;
import com.bookcompany.builder.repository.IngredientRepository;
import com.bookcompany.builder.repository.RecipeRepository;


import java.io.IOException;
import java.util.List;

public interface IngredientService {
    IngredientRepository<Ingredient> loadIngredients() throws IOException;
    void printListOfIngredients(IngredientRepository<Ingredient> listOfIngredients);
    void printListOfVegetarianIngredients(IngredientRepository<Ingredient> listOfIngredients);
    void printListOfRecipesWithAvailableIngredients(IngredientRepository<Ingredient> listOfIngredients, IngredientRepository<Recipe> listOfRecipes);
    void printListOfRecipesWithGivenIngredients(List<Ingredient> listOfIngredients, IngredientRepository<Recipe> listOfRecipes);
}

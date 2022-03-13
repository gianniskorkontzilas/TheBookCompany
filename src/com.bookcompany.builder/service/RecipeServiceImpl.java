package com.bookcompany.builder.service;

import com.bookcompany.builder.io.FileInputOutput;
import com.bookcompany.builder.model.Directory;
import com.bookcompany.builder.model.Ingredient;
import com.bookcompany.builder.model.Recipe;
import com.bookcompany.builder.repository.IngredientRepository;
import com.bookcompany.builder.repository.IngredientRepositoryImpl;
import com.bookcompany.builder.repository.RecipeRepository;
import com.bookcompany.builder.repository.RecipeRepositoryImpl;


import java.io.File;
import java.util.*;

public class RecipeServiceImpl implements RecipeService{


    @Override
    public IngredientRepository<Recipe> loadRecipes(String recipeName, IngredientRepository<Ingredient> listOfIngredients) {
        // The user decides which file the program will load.
        List<String> lines = FileInputOutput.readFile(Directory.FILE_DIRECTORY.getPath()
                + "data" + File.separator + "input" + File.separator + recipeName + ".txt");

        // Created a list of ingredient names from ingredient list.
        List<String> listIngredients = new ArrayList<>();
        for (Ingredient ingredient : listOfIngredients.read())
            listIngredients.add(ingredient.getName());

        // Creating a repository of recipes.
        IngredientRepository<Recipe> listOfRecipes = new IngredientRepositoryImpl<>();

        // Iterating through contents of file, creating recipes and if ingredients is not found on list of ingredient names
        // then we don't add it to the repository of recipes.
        for (String line: lines) {
            boolean ingredientNotExists = false;

            // A list of ingredients for each recipe.
            List<Ingredient> allIngredients = new ArrayList<>();

            // Creating each recipe.
            String[] items = line.split(",");
            Recipe recipe = new Recipe();
            recipe.setName(items[0]);
            recipe.setPreparationTime(Integer.parseInt(items[1]));
            for (int i = 2; i < items.length; i++) {

                // If ingredients is not found then we flag it.
                if (!listIngredients.contains(items[i])) {
                    System.err.println("Ingredient:" + items[i] + " is not found.");
                    ingredientNotExists = true;
                } else {
                for (Ingredient ingredient : listOfIngredients.read())
                    if (Objects.equals(ingredient.getName(), items[i]))
                        allIngredients.add(ingredient);
                }
            }
            if (!ingredientNotExists) {
                recipe.setListOfIngredients(allIngredients);
                listOfRecipes.create(recipe);
            }
        }
        return listOfRecipes;
    }

    @Override
    public void printRecipesByName(IngredientRepository<Recipe> listOfRecipes) {
        // If list of recipes is null we let the user know about it.
        if (listOfRecipes == null) {
            System.out.println("There are no recipes.");
        } else {

            // Taking the recipe names and then sorting it using the Collections and then print it out.
            List<String> listRecipesByName = new ArrayList<>();
            for (Recipe recipe : listOfRecipes.read())
                listRecipesByName.add(recipe.getName());

            // Sort names.
            Collections.sort(listRecipesByName);

            // Print them.
            listRecipesByName.forEach(System.out::println);
        }
    }


    @Override
    public void printRecipesByPreparationTime(IngredientRepository<Recipe> listOfRecipes) {
        // If list of recipes is null we let the user know about it.
        if (listOfRecipes == null) {
            System.out.println("There are no recipes.");
        } else {

            // Taking all preparation times of recipes and finding though Collections the max and min times.
            List<Integer> listOfPreparationTimes = new ArrayList<>();
            for (Recipe recipe : listOfRecipes.read())
                listOfPreparationTimes.add(recipe.getPreparationTime());
            int minPreparationTime = Collections.min(listOfPreparationTimes);
            int maxPreparationTime = Collections.max(listOfPreparationTimes);

            // Then we iterate through min to max with step of one and printing out all recipes ordered by preparation time.
            for (int i = minPreparationTime; i <= maxPreparationTime; i++) {
                for (Recipe recipe : listOfRecipes.read())
                    if (recipe.getPreparationTime() == i)
                        System.out.println(recipe.getName());
            }
        }
    }


    @Override
    public List<String> printVegetarianRecipes(IngredientRepository<Recipe> listOfRecipes) {
        // If list of recipes is null we let the user know about it.
        if (listOfRecipes == null) {
            System.out.println("There are no recipes.");
            return null;
        } else {
            boolean isVegetarian;

            // Creating a list of recipe names, checking which are vegetarian based on their ingredients. If there is a
            // nonVegetarian ingredient we flag it and move to the next recipe.
            List<String> listToOutput = new ArrayList<>();
            for (Recipe recipe : listOfRecipes.read()) {
                isVegetarian = true;
                for (Ingredient ingredient : recipe.getListOfIngredients()) {
                    if (Objects.equals(ingredient.getIsVegetarian(), "n")) {
                        isVegetarian = false;
                        break;
                    }
                }

                // If flag is true we add to the list of recipe names because the recipe is vegetarian.
                if (isVegetarian) {
                    listToOutput.add(recipe.getName());
                    System.out.println(recipe.getName());
                }
            }
            return listToOutput;
        }

    }


    @Override
    public List<String> returnedRecipes(IngredientRepository<Recipe> listOfRecipes, IngredientRepository<Ingredient> listOfIngredients, String ingredient) {
        // If list of recipes is null we let the user know about it.
         if (listOfRecipes == null) {
            System.out.println("There are no recipes.");
            return null;
        } else {
             // First we check if ingredient exists in our list.
            boolean isFound = false;
            for (Ingredient ingredientFromList : listOfIngredients.read())
                if (Objects.equals(ingredientFromList.getName(), ingredient)) {
                    isFound = true;
                    break;
                }

            // If ingredient does not exist we return null.
            if (!isFound){
                System.out.println("NO recipes.");
                return null;
            } else {

                // If ingredient exists then the program will print out a list of recipe names for the user ingredient.
                List<String> listToOutput = new ArrayList<>();
                for (Recipe recipe : listOfRecipes.read())
                    for (Ingredient ingredientOfRecipe : recipe.getListOfIngredients())
                        if (Objects.equals(ingredientOfRecipe.getName(), ingredient)){
                            listToOutput.add(recipe.getName());
                            System.out.println(recipe.getName());
                            break;
                        }
                return listToOutput;
            }
        }
    }


    @Override
    public List<String> searchRangeOfCalories(IngredientRepository<Recipe> listOfRecipes, IngredientRepository<Ingredient> listOfIngredients, int fromCalories, int toCalories) {
        // If list of recipes is null we let the user know about it.
        if (listOfRecipes == null) {
            System.out.println("There are no recipes.");
            return null;
        } else {

            // Check if user calories range are bigger than zero and the toCalories is not bigger than fromCalories.
            if (fromCalories < 0 && toCalories < 0 || fromCalories > toCalories) {
                System.out.println("Calories must be above 0 or to calories must not exceed from calories.");
                return null;
            }
            else {
                // Creating a hashtable and integer of calories calculation.
                Hashtable<Recipe, Integer> recipesCalories = new Hashtable<>();
                int calories;
                for (Recipe recipe : listOfRecipes.read()) {
                    calories = 0;
                    for (Ingredient ingredient : recipe.getListOfIngredients())
                        calories += ingredient.getCalories();
                    recipesCalories.put(recipe, calories);
                }

                // Creating a list of recipe names and printing the recipes that are within range of calories.
                List<String> listToOutput = new ArrayList<>();
                recipesCalories.forEach((k, v) -> {
                    if (v >= fromCalories && v <= toCalories) {
                        listToOutput.add(k.getName());
                        System.out.println(k.getName());
                    }
                });
                return listToOutput;
            }
        }
    }


    @Override
    public void listIngredientsForRecipes(List<Recipe> listWithRecipes, IngredientRepository<Ingredient> listOfIngredients) {
        // Creating a hashtable of ingredient names and integer of counter for each ingredient from user recipes.
        Hashtable<String, Integer> listWithIngredients = new Hashtable<>();
        for (Recipe recipe : listWithRecipes)
            for (Ingredient ingredient : recipe.getListOfIngredients())
                if (listWithIngredients.containsKey(ingredient.getName())){
                    int value = listWithIngredients.get(ingredient.getName());
                    listWithIngredients.put(ingredient.getName(), value + 1);
                } else {
                    listWithIngredients.put(ingredient.getName(), 1);
                }

        // Printing out the ingredients name and values of how many of them the user need in order to create the requested
        // recipes.
        listWithIngredients.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}

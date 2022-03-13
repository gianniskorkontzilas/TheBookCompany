package com.bookcompany.builder.Entities;

public class Recipe {
    String name;
    int preparationTime;
    String stringOfIngredients;
    String overallType;
    int calories;

    public Recipe() {
    }

    public Recipe(String name, int preparationTime, String stringOfIngredients, String overallType, int calories) {
        this.name = name;
        this.preparationTime = preparationTime;
        this.stringOfIngredients = stringOfIngredients;
        this.overallType = overallType;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getStringOfIngredients() {
        return stringOfIngredients;
    }

    public void setStringOfIngredients(String stringOfIngredients) {
        this.stringOfIngredients = stringOfIngredients;
    }

    public String getOverallType() {
        return overallType;
    }

    public void setOverallType(String overallType) {
        this.overallType = overallType;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", preperationTime=" + preparationTime +
                ", stringOfIngredients='" + stringOfIngredients + '\'' +
                ", overalType='" + overallType + '\'' +
                ", calories=" + calories +
                '}';
    }
}


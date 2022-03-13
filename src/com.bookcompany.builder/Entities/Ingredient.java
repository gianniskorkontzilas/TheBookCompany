package com.bookcompany.builder.Entities;

import java.math.BigDecimal;

public class Ingredient {
    String name;
    BigDecimal cost;
    Integer calories;
    String type;

    public Ingredient() {
    }

    public Ingredient(String name, BigDecimal cost, Integer calories, String type) {
        this.name = name;
        this.cost = cost;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", calories=" + calories +
                ", type='" + type + '\'' +
                '}';
    }
}


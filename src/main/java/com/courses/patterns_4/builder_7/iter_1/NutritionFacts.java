package com.courses.patterns_4.builder_7.iter_1;

/**
 * Created by VSulevskiy on 28.08.2015.
 */
public class NutritionFacts {
    private int servingSize;  //ml            required
    private int servings;     //per container required
    private int calories;     //              optional
    private int fat;          //g             optional
    private int sodium;       //mg            optional
    private int carbonhydrate;//g             optional

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0, 0, 0, 0);

    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0, 0, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbonhydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbonhydrate = carbonhydrate;
    }

    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getCarbonhydrate() {
        return carbonhydrate;
    }
}

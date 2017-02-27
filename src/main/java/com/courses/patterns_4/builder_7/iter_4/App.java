package com.courses.patterns_4.builder_7.iter_4;

/**
 * Created by VSulevskiy on 28.08.2015.
 */
public class App {
    public void usageNutritionFacts(){
        NutritionFacts cola = new NutritionFacts.Builder(240,8).calories(100).sodium(35).carbonhydrate(27).build();
        NutritionFacts burger = new NutritionFacts.Builder(200,1).calories(540).sodium(12).carbonhydrate(46).fat(45).build();

    }

    public static void main(String[] args) {
        new App().usageNutritionFacts();
    }
}

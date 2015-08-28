package com.courses.patterns_4.builder_7.iter_2;

import com.courses.patterns_4.builder_7.iter_2.NutritionFacts;

/**
 * Created by VSulevskiy on 28.08.2015.
 */
public class App {
    public void usageNutritionFacts(){
        NutritionFacts cola = new NutritionFacts();
        cola.setServingSize(240);
        cola.setServings(8);
        cola.setCalories(100);
        cola.setSodium(35);
        cola.setCarbonhydrate(27);

        NutritionFacts burger = new NutritionFacts();
        burger.setServingSize(200);
        burger.setServings(1);
        burger.setCalories(540);
        burger.setFat(45);
        burger.setSodium(12);
        burger.setCarbonhydrate(46);

    }
}

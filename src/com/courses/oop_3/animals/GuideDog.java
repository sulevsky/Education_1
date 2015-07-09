package com.courses.oop_3.animals;

/**
 * Created by VSulevskiy on 09.07.2015.
 */
public class GuideDog extends Dog {
    private boolean isTrained;

    public GuideDog(int id, int age, double weight, String color, String name, boolean isVaccinated, boolean isTrained) {
        super(id, age, weight, color, name, isVaccinated);
        this.isTrained = isTrained;
    }

    public GuideDog() {
    }

    public String phrase(){
        String result = super.phrase();
        if(isTrained){
            result+=" I can take you home.";
        }
        return result;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setIsTrained(boolean isTrained) {
        this.isTrained = isTrained;
    }
}

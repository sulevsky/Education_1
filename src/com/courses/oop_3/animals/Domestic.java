package com.courses.oop_3.animals;

/**
 * Created by VSulevskiy on 09.07.2015.
 */
public abstract class Domestic extends Animal {
    private String name;
    private boolean isVaccinated;

    public Domestic(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color);
        this.name = name;
        this.isVaccinated = isVaccinated;
    }

    public Domestic() {
    }

    public String phrase(){
        String result = super.phrase();
        if(name != null){
            result += "my name is " + getName();
        }
        return result;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setIsVaccinated(boolean isVaccinated) {
        this.isVaccinated = isVaccinated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

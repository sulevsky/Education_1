package com.courses.oop_3.shape;

public class Paint {
    private final String colorName;
    private final double consumptionPerSquare;
    private final Money price;

    public Paint(String colorName, double consumptionPerSquare, Money price) {
        this.colorName = colorName;
        this.consumptionPerSquare = consumptionPerSquare;
        this.price = price;
    }

    public String getColorName() {
        return colorName;
    }

    public double getConsumptionPerSquare() {
        return consumptionPerSquare;
    }

    public double getPrice() {
        return price.getAmount();
    }
}

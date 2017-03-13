package com.courses.oop_3.shape;

public abstract class Shape {

    private Paint paint;

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    abstract double calculateArea();

    public double calculatePaintSpent() {
        return calculateArea() * paint.getConsumptionPerSquare();
    }

    public double calculatePaintCost() {
        return calculatePaintSpent() * paint.getPrice();
    }
}

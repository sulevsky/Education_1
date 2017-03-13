package com.courses.oop_3.shape;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShapeCollection {

    private List<Shape> shapes  = new LinkedList<>();

    public void addShape(Shape shape){
        shapes.add(shape);
    }
    public void removeShape(Shape shape){
        shapes.remove(shape);
    }

    public double totalCost() {
        double total = 0.0;
        for(Shape shape : shapes){
            total += shape.calculatePaintCost();
        }
        return total;
    }


    public double totalPaintSpent() {
        double total = 0.0;
        for(Shape shape : shapes){
            total += shape.calculatePaintSpent();
        }
        return total;
    }

    public double totalPaintArea() {
        double total = 0.0;
        for(Shape shape : shapes){
            total += shape.calculateArea();
        }
        return total;
    }
}

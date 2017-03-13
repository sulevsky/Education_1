package com.courses.oop_3.shape;

public class Main {
    public static void main(String[] args) {
        ShapeCollection shapeCollection = init();
        System.out.println(shapeCollection.totalCost());
    }














    private static ShapeCollection init() {
        Circle circle = new Circle(2);


        Square square = new Square(5);


//        Paint red = new Paint("Red", 2.1, 14);

        Money price = new Money(25);
        double consumptionPerSquare = 0.6;
        Paint orange = new Paint("Orange", consumptionPerSquare, price);
        circle.setPaint(orange);
//        square.setPaint(red);


        ShapeCollection shapeCollection = new ShapeCollection();
        shapeCollection.addShape(circle);
        shapeCollection.addShape(square);


        return shapeCollection;
    }
}

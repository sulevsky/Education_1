package com.courses.patterns_4.decorator_4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VSulevskiy on 10.08.2015.
 */
public class App {
    public static void main(String[] args) {
        List<Shape> shapes = createShapes();

        shapesDraw(shapes);
    }

    public static void shapesDraw(List<Shape> shapes){
        for(Shape shape : shapes){
            shape.draw();
        }
    }

    public static List<Shape> createShapes(){
        List<Shape> shapes = new ArrayList<Shape>();

        Circle circle = new Circle();
        shapes.add(circle);

        Rectangle rectangle = new Rectangle();
        shapes.add(rectangle);

        Shape rectangleWithRedBorders = new RedShapeDecorator(new Rectangle());
        shapes.add(rectangleWithRedBorders);

        return shapes;
    }
}

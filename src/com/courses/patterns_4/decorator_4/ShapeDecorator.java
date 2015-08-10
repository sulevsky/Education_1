package com.courses.patterns_4.decorator_4;

/**
 * Created by VSulevskiy on 10.08.2015.
 */
public class ShapeDecorator implements Shape {
    private Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }
    @Override
    public void draw() {
        decoratedShape.draw();
    }

    public Shape getDecoratedShape() {
        return decoratedShape;
    }
}

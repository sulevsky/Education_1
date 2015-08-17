package com.courses.patterns_4.decorator_4;

public abstract class ShapeDecorator implements Shape {
    private Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }
    @Override
    public void draw() {
        decoratedShape.draw();
    }

    public void setDecoratedShape(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public Shape getDecoratedShape() {
        return decoratedShape;
    }
}

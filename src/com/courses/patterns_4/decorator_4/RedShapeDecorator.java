package com.courses.patterns_4.decorator_4;

/**
 * Created by VSulevskiy on 10.08.2015.
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }
    @Override
    public void draw(){
        Shape decoratedShape = getDecoratedShape();
        decoratedShape.draw();
        drawRedBorder(decoratedShape);
    }

    private void drawRedBorder(Shape shape){
        System.out.println("Border color - red");
    }
}

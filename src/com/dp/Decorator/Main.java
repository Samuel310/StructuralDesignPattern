package com.dp.Decorator;

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}

abstract class Decorator implements Shape {
    protected Shape decoratedShape;
    public Decorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }
}

class RedShapeDecorator extends Decorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }
    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Border Color: Red");
    }
}

public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
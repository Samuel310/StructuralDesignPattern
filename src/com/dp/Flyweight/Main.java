package com.dp.Flyweight;
import java.util.HashMap;

interface Shape {
    void draw();
}

class Circle implements Shape {
    private String color;
    private int radius;
    public Circle(String color){
        this.color = color;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color + ",  radius :" + radius+"]");
    }
}

class ShapeFactory {
    private static final HashMap circleMap = new HashMap();
    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);
        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}

class Main {
    private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };
    public static void main(String[] args) {
        for(int i=0; i < 20; ++i) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setRadius(getRandomRadius());
            circle.draw();
        }
    }
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomRadius() {
        return (int)(Math.random()*50 );
    }
}


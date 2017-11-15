package task4_14_11_2017.factories;

import task4_14_11_2017.figures.ColorTriangle;

import java.util.Random;

public class ColorTriangleFactory {
    public static ColorTriangle create(){
        Random r = new Random();
        return new ColorTriangle(TriangleFactory.create(), r.nextInt(1000));
    }
}

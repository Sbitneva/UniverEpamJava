package task4_14_11_2017.factories;

import task4_14_11_2017.figures.ColorPoint;

import java.util.Random;

public class ColorPointFactory {
    public static ColorPoint create(){
        Random r = new Random();
        return new ColorPoint(r.nextInt(), r.nextInt(), r.nextInt());
    }
}

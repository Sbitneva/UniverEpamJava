package task4_14_11_2017.factories;

import task4_14_11_2017.figures.ColorLine;

import java.util.Random;

public class ColorLineFactory {
    public static ColorLine crete(){
        Random r = new Random();
        return new ColorLine(PointFactory.create(), PointFactory.create(), r.nextInt(2000));
    }
}

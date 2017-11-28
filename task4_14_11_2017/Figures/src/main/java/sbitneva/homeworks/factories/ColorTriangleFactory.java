package factories;

import figures.ColorTriangle;

import java.util.Random;

public class ColorTriangleFactory extends AbstractConcreteFactory{
    public static ColorTriangle create(){
        Random r = new Random();
        return new ColorTriangle(TriangleFactory.create(), r.nextInt(1000));
    }
}

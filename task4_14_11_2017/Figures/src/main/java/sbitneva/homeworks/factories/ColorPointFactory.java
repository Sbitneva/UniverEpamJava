package factories;

import figures.ColorPoint;

import java.util.Random;

public class ColorPointFactory extends AbstractConcreteFactory{
    public static ColorPoint create(){
        Random r = new Random();
        return new ColorPoint(r.nextInt(), r.nextInt(), r.nextInt());
    }
}

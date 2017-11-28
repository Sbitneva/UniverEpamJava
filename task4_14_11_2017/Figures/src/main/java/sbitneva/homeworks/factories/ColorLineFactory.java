package factories;

import figures.ColorLine;

import java.util.Random;

public class ColorLineFactory extends AbstractConcreteFactory{
    public static ColorLine crete(){
        Random r = new Random();
        return new ColorLine(PointFactory.create(), PointFactory.create(), r.nextInt(2000));
    }
}

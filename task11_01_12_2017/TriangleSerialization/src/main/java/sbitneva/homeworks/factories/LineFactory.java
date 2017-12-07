package factories;

import entities.Line;

import java.util.Random;

public class LineFactory extends AbstractConcreteFactory {
    public static Line create(){
        Random r = new Random();
        return new Line(PointFactory.create(), PointFactory.create());
    }
}

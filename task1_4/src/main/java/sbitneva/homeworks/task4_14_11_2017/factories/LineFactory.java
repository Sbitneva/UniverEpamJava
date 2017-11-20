package task4_14_11_2017.factories;

import task4_14_11_2017.figures.Line;

import java.util.Random;

public class LineFactory extends AbstractConcreteFactory{
    public static Line create(){
        Random r = new Random();
        return new Line(PointFactory.create(),PointFactory.create());
    }
}

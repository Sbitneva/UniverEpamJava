package task4_14_11_2017.factories;

import task4_14_11_2017.figures.Figure;

abstract class AbstractConcreteFactory {
    public static Figure create(){
        return new Figure();
    };
}

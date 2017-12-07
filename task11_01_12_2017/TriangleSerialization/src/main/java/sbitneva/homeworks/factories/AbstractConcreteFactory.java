package factories;


import entities.Figure;

abstract class AbstractConcreteFactory {
    public static Figure create(){
        return new Figure();
    };
}

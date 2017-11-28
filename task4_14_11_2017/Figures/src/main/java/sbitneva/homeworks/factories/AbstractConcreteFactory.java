package factories;

import figures.Figure;

abstract class AbstractConcreteFactory {
    public static Figure create(){
        return new Figure();
    };
}

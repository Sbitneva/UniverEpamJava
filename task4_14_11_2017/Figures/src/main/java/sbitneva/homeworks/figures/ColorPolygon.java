package figures;

import interfaces.Colored;

public class ColorPolygon extends Polygon implements Colored {
    private int color;
    private int id;
    public ColorPolygon(Point polyPoints[], int color){
        super(polyPoints);
        this.color = color;
        this.id = getId();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "\nFigure Type - " + this.getClass().getSimpleName() + "\t id = " + this.id;
    }
}

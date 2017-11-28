package figures;

import interfaces.Colored;

public class ColorTriangle extends Triangle implements Colored{
    int color;
    private int id;

    public ColorTriangle(Point apexA, Point apexB, Point apexC, int color){
        super(apexA, apexB, apexC);
        this.color = color;
        this.id = getId();
    }

    public ColorTriangle(Triangle triangle, int color){
        super(triangle.apexA, triangle.apexB, triangle.apexC);
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

package task4_14_11_2017.figures;

import task4_14_11_2017.interfaces.Colored;

public class ColorLine  extends Line implements Colored{
    private int color;
    private int id;

    public ColorLine(Point beg, Point end, int color) {
        super(beg, end);
        this.color = color;
        this.id = getId();
        this.id = getId();
    }
    public ColorLine(int x1, int y1, int x2, int y2, int color) {
        super(x1, y1, x2, y2);
        this.color = color;
        this.id = getId();
    }

    public int getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "\nFigure Type - " + this.getClass().getSimpleName() + "\t\t id = " + this.id;
    }
}

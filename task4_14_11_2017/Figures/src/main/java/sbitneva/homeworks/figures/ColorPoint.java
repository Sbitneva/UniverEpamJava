package figures;

import interfaces.Colored;

public class ColorPoint extends Point implements Colored{

    private int color;
    private int id;
    public ColorPoint(int x, int y, int color){
        super(x, y);
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

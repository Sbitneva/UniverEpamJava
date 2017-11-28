package figures;

public class Polygon extends Figure{
    private int id;
    private Point polyPoints[];
    public Polygon(Point polyPoints[]){
        this.polyPoints = polyPoints;
        this.id = getId();
    }

    public Point[] getPolyPoints() {
        return polyPoints;
    }

    public void setPolyPoints(Point[] polyPoints) {
        this.polyPoints = polyPoints;
    }

    @Override
    public String toString() {
        return "\nFigure Type - " + this.getClass().getSimpleName() + "\t\t id = " + this.id;
    }
}

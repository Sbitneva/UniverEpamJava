package task4_14_11_2017.figures;

public class Point extends Figure implements Cloneable{
    private int id;
    @Override
    protected Object clone()  {

        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    private int x;
    private int y;
    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.id = getId();
    }
    public Point(Point p) {
        this.x=p.getX();
        this.y=p.getY();
        this.id = getId();
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "\nFigure Type - " + this.getClass().getSimpleName() + "\t\t\t id = " + this.id;
    }

}
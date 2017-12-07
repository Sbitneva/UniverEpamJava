package entities;

import java.io.Serializable;

public class Point extends Figure implements Serializable{

    private int x;
    private int y;

    public Point(){

    }

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
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
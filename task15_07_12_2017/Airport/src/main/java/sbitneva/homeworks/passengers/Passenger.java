package sbitneva.homeworks.passengers;


import sbitneva.homeworks.planes.Plane;

public class Passenger {
    private static int id;
    private String name;
    private Plane plane;
    public Passenger(){
        id++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                '}';
    }
}


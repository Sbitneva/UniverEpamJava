package sbitneva.homeworks.planes;

import sbitneva.homeworks.passengers.Passenger;

import java.util.LinkedList;
import java.util.Queue;

public class Plane {
    private static  int id = 1;
    private String cityName;
    private int reservedPlaces;
    private int current_id;
    private Queue<Passenger> passenggers = new LinkedList<>();

    public Plane(){
        this.current_id = id++;
    }

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getReservedPlaces() {
        return reservedPlaces;
    }

    public void setReservedPlaces(int reservedPlaces) {
        this.reservedPlaces = reservedPlaces;
    }

    public Queue<Passenger> getPassenggers() {
        return passenggers;
    }

    public void setPassenggers(Queue<Passenger> passenggers) {
        this.passenggers = passenggers;
    }

    @Override
    public String toString() {
        return "Plane #" + current_id;
    }
}

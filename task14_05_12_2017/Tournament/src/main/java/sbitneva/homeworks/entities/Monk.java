package sbitneva.homeworks.entities;

public class Monk {
    private static int  id;
    private String      name;
    private String      village;
    private int         energy;

    public Monk() {
        id++;
        this.name = "Name # " + id;
        this.village = "";
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

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public String toString() {
        return "Monk{" +
                "name='" + name + '\'' +
                ", village='" + village + '\'' +
                ", energy=" + energy +
                '}';
    }
}

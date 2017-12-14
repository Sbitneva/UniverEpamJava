package sbitneva.homeworks.factories;

import sbitneva.homeworks.entities.Monk;

import java.util.Random;

public class MonkFactory {

    static String[] monks = {"In'", "Yan'"};
    public static Monk create(){
        Random r = new Random();
        Monk monk = new Monk();
        monk.setName("Monk #" + monk.getId());
        monk.setVillage(monks[r.nextInt(2)]);
        monk.setEnergy(r.nextInt(1000));
        return monk;
    }
}

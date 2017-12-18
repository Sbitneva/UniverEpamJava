package sbitneva.homeworks;

import sbitneva.homeworks.entities.AircraftWithAmmunition;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestExceptions {
    @Test
    public void testMilitaryAircraftExceptions(){
        AircraftWithAmmunition aircraftWithAmmunition = new AircraftWithAmmunition();
        aircraftWithAmmunition.setSeats(3);
        assertEquals(aircraftWithAmmunition.getSeats(), 0);
    }
}

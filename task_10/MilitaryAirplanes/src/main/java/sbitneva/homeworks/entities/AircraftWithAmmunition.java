package entities;

import exceptions.AircraftWithAmmunitionException;
import org.apache.log4j.Logger;

public class AircraftWithAmmunition extends Aircraft {

    static Logger log = Logger.getLogger(Aircraft.class.getName());

    byte ammunition;

    public static AircraftWithAmmunition aircraftWithAmmunitionFactory(){
        return new AircraftWithAmmunition();
    }

    public byte getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(byte ammunition) {
        try{
            if((ammunition < 0) || (ammunition > 10)){
                throw new AircraftWithAmmunitionException("Invalid ammunition parameter. Value must be in [0..10] range");
            }
        }catch (AircraftWithAmmunitionException e){
            log.error(e.getMessage());
            return;
        }
        this.ammunition = ammunition;
        log.debug(AircraftWithAmmunition.class.getName() + " ammunition is set to " + ammunition);
    }

    @Override
    public String toString() {
        return super.toString() +
                "ammunition=" + ammunition;
    }
}

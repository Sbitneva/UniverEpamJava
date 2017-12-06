package entities;

import exceptions.MilitaryAircraftException;
import org.apache.log4j.Logger;

public class Aircraft {
    static Logger log = Logger.getLogger(Aircraft.class.getName());
    private String id;
    private String model;
    private String origin;
    private String type;
    private int seats;
    private boolean radar;
    private int price;
    private AircraftParameters parameters;

    public Aircraft(){
        parameters = new AircraftParameters();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        log.debug(Aircraft.class.getName() + " price is set to" + price);
    }

    public String getId() {
        return id;
    }

    public static Aircraft militaryAircraftFactory() {
        return new Aircraft();
    }

    public void setId(String id) {
        this.id = id;
        log.debug(Aircraft.class.getName() + " id is set to " + id);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
        log.debug(Aircraft.class.getName() + " model is set to " + model);
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
        log.debug(Aircraft.class.getName() + " origin is set to " + origin);
    }


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        try{
            if((seats > 2)||(seats < 1)){
                throw new MilitaryAircraftException("Invalid seats value");
            }
        }catch (MilitaryAircraftException e){
            log.error(e.getMessage());
            return;
        }
        this.seats = seats;
        log.debug(Aircraft.class.getName() + " seats are set to " + seats);
    }

    public boolean isRadar() {
        return radar;
    }

    public void setRadar(boolean radar) {
        this.radar = radar;
        log.debug(Aircraft.class.getName() + " radar is set to " + radar);
    }

    public void setParameters(AircraftParameters parameters) {
        this.parameters = parameters;
        log.debug("Aircraft" + " parameters is set to " + parameters.toString());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        log.debug("Aircraft" + " type is set to " + type);
    }

    @Override
    public String toString() {
        return "\n\nAircraft " +
                "id=" + id + "\n" +
                "model=" + model + "\n" +
                "origin=" + origin + "\n" +
                "type=" + type + "\n" +
                "seats=" + seats + "\n" +
                "radar=" + radar + "\n" +
                "price=" + price + "\n" +
                "parameters=" + parameters +
                "\n";
    }
    public static class AircraftParameters {
        private int width = 0;
        private int lenght = 0;
        private int height = 0;

        public AircraftParameters(){

        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
            log.debug("Aircraft width is set to " + width);
        }

        public int getLenght() {
            return lenght;
        }

        public void setLenght(int lenght) {
            this.lenght = lenght;
            log.debug("Aircraft lenght is set to " + lenght);
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
            log.debug("Aircraft height is set to " + height);
        }


        @Override
        public String toString() {
            return "AircraftParameters{" +
                    "width=" + width +
                    ", lenght=" + lenght +
                    ", height=" + height +
                    '}';
        }
    }

}

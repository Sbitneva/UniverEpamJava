package view;

import interfaces.DisplayElement;
import interfaces.Observer;
import model.WeatherData;

public class StatisticsDisplay implements Observer, DisplayElement {
    private WeatherData weatherData;
    private double temperature;
    private int pressure;
    private int humidity;
    private double temperatures;
    private long pressures;
    private long humidities;
    private int index;

    public StatisticsDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public String toString() {
        return "Statistics conditions: " + temperature
                + "C degrees and " + humidity + "% humidity and " + pressure + " hpa pressure";
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public void update(double temperature, int pressure, int humidity) {
        ++index;
        temperatures = temperatures + temperature;
        pressures += pressure;
        humidities += humidity;
        this.temperature = temperatures / index;
        this.humidity = (int)(humidities / index);
        this.pressure = (int)(pressures / index);
    }

    @Override
    public void restart() {
        this.index = 0;
        this.temperatures = 0;
        this.pressures = 0;
        this.humidities = 0;
        this.temperature = 0;
        this.humidity = 0;
        this.pressure = 0;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getTemperature() {
        return temperature;
    }


}

package view;

import interfaces.DisplayElement;
import interfaces.Observer;
import model.ForecastData;

public class ForecastDisplay implements Observer, DisplayElement {
    private ForecastData forecastData;
    private double temperature;
    private int pressure;
    private int humidity;

    public ForecastDisplay(ForecastData forecastData){
        this.forecastData = forecastData;
        forecastData.registerObserver(this);
    }
    @Override
    public String toString() {
        return "Forecast for next 3 hours:\n " + temperature
                + "C degrees, \n " + humidity + "% humidity, \n " + pressure + " hpa pressure\n";
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public void update(double temperature, int pressure, int humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    @Override
    public void restart(){

    }

    public double getTemperature() {
        return temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}

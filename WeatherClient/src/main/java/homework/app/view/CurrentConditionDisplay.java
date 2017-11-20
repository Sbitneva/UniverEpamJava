package view;

import interfaces.DisplayElement;
import interfaces.Observer;
import model.WeatherData;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;
    private double temperature;
    private int pressure;
    private int humidity;

    public CurrentConditionDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public void update(double temperature, int pressure, int humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    @Override
    public String toString() {
        return "Current conditions:\n " + temperature
                + "C degrees, \n " + humidity + "% humidity, \n " + pressure + " hpa pressure\n";
    }

    @Override
    public void restart() {
        this.temperature = 0;
        this.pressure = 0;
        this.humidity = 0;
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

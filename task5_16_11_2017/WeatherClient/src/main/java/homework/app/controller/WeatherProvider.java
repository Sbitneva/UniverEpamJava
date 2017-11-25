package controller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherProvider {

    private final static String Weather_Web_Service_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private final static String Weather_Web_Service_Key = "&appid=14e98da6d7fb36ff261d34bbb9b8cb56&units=metric";
    private final static String Forecast_Web_Service_URL = "http://api.openweathermap.org/data/2.5/forecast?q=";

    private double temperature;
    private int pressure;
    private int humidity;
    private double ftemperature;
    private int fpressure;
    private int fhumidity;
    private String city;

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public WeatherProvider(String city){

        this.city = city;
        if(!city.equals(""))
        {
            getCurrentWeather();
            getForecast();
        }

    }

    public void getCurrentWeather(){
        try {
            URL url = new URL(Weather_Web_Service_URL + city + Weather_Web_Service_Key);

            InputStream is = url.openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                JSONObject json = new JSONObject(jsonText);
                JSONObject main = json.getJSONObject("main");
                temperature = main.getDouble("temp");
                pressure = main.getInt("pressure");
                humidity = main.getInt("humidity");

            } catch (Exception e) {

            }
        } catch (Exception e) {

        }

    }

    public void getForecast(){
        JSONArray list;
        try {
            URL url = new URL(Forecast_Web_Service_URL + city + Weather_Web_Service_Key);

            InputStream is = url.openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                JSONObject json = new JSONObject(jsonText);
                list = json.getJSONArray("list");
                JSONObject main = list.getJSONObject(0).getJSONObject("main");
                ftemperature = main.getDouble("temp");
                fpressure = main.getInt("pressure");
                fhumidity = main.getInt("humidity");

            } catch (Exception e) {

            }
        }catch (Exception e){

        }
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

    public double getFtemperature() {
        return ftemperature;
    }

    public int getFpressure() {
        return fpressure;
    }

    public int getFhumidity() {
        return fhumidity;
    }
}

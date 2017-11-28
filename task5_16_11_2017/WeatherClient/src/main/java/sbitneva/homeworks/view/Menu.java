package view;

import controller.WeatherProvider;
import model.ForecastData;
import model.WeatherData;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;


public class Menu {

    private String city;
    private JFrame fr;
    private JTextField cityTextField;
    private JButton okButton;
    private JLabel jlabel;
    private WeatherData currentWeatherData;
    private ForecastData forecastData;
    private CurrentConditionDisplay currentDisplay;
    private StatisticsDisplay statisticsDisplay;
    private ForecastDisplay forecastDisplay;
    private Timer timer = new Timer();

    private JLabel forecastLabel;
    private JLabel weatherLabel;
    private JLabel statisticsLabel;

    private JTextField forecastTextField;
    private JTextField weatherTextField;
    private JTextField statisticsTextField;


    public Menu(){

        currentWeatherData = new WeatherData();
        currentDisplay = new CurrentConditionDisplay(currentWeatherData);
        statisticsDisplay = new StatisticsDisplay(currentWeatherData);

        forecastData = new ForecastData();
        forecastDisplay = new ForecastDisplay(forecastData);

        jlabel = new JLabel("Enter city name");
        jlabel.setBounds(50, 70, 200, 20);
        weatherLabel = new JLabel("Current weather: ");
        weatherLabel.setBounds(50,130, 200,30);
        forecastLabel = new JLabel("Forecast: ");
        forecastLabel.setBounds(50,210, 200,30);
        statisticsLabel = new JLabel("Statistics: ");
        statisticsLabel.setBounds(50,290, 200,30);

        fr = new JFrame();
        fr.setSize(1000, 500);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cityTextField = new JTextField();
        cityTextField.setBounds(50,100, 200,30);
        weatherTextField = new JTextField();
        weatherTextField.setBounds(50, 160, 900, 50);
        forecastTextField = new JTextField();
        forecastTextField.setBounds(50, 240, 900, 50);
        statisticsTextField = new JTextField();
        statisticsTextField.setBounds(50, 320, 900, 50);

        JButton okButton = new JButton("OK");
        okButton.setBounds(250, 100,  100, 30);

        fr.add(jlabel);
        fr.add(okButton);
        fr.add(cityTextField);
        fr.add(weatherLabel);
        fr.add(forecastLabel);
        fr.add(forecastTextField);
        fr.add(weatherTextField);
        fr.add(statisticsLabel);
        fr.add(statisticsTextField);
        fr.setLayout(null);
        fr.setVisible(true);


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                city = cityTextField.getText();
                currentWeatherData.restart();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        readData(city);
                    }
                }, 1000, 5000);

            }
        });
    }

    private void readData(String city){
        if(!city.equals("")) {
            System.out.println(city);
            WeatherProvider weatherProvider = new WeatherProvider(city);
            weatherProvider.getForecast();
            weatherProvider.getCurrentWeather();

            currentWeatherData.setMeasurements(weatherProvider.getTemperature(),
                    weatherProvider.getPressure(), weatherProvider.getHumidity());
            forecastData.setMeasurements(weatherProvider.getFtemperature(),
                    weatherProvider.getFpressure(), weatherProvider.getFhumidity());

            weatherTextField.setText(currentDisplay.toString());
            forecastTextField.setText(forecastDisplay.toString());
            statisticsTextField.setText(statisticsDisplay.toString());

            currentDisplay.display();
            forecastDisplay.display();
            statisticsDisplay.display();
        }
    }

    public JFrame getJf() {
        return fr;
    }
}

class MyTimerActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {

    }
}
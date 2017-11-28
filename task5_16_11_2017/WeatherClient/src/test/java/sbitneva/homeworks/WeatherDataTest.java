import model.WeatherData;
import org.junit.Before;
import org.junit.Test;
import view.CurrentConditionDisplay;
import view.StatisticsDisplay;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class WeatherDataTest {

    final int LEN = 100;
    double temp[] = new double[LEN];
    int pressure[] = new int[LEN];
    int humidity[] = new int[LEN];

    WeatherData weatherData;
    StatisticsDisplay statisticsDisplay;
    CurrentConditionDisplay currentConditionDisplay;

    @Test
    public void testWeatherData() {
        weatherData = new WeatherData();
        statisticsDisplay = new StatisticsDisplay(weatherData);
        currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        Random r = new Random();
        double  t = r.nextDouble();
        int p = r.nextInt();
        int h = r.nextInt();
        for(int i = 0; i < LEN; i++){
            temp[i] = t;
            pressure[i] = p;
            humidity[i] = h;
        }
        for(int i = 0; i < LEN; i++){
            weatherData.setMeasurements(temp[i], pressure[i], humidity[i]);
        }

        assertTrue("statistics calculation error", statisticsDisplay.getTemperature() == temp[0]);
        assertTrue("statistics calculation error", statisticsDisplay.getHumidity() == humidity[0]);
        assertTrue("statistics calculation error", statisticsDisplay.getPressure() == pressure[0]);
    }

    @Test
    public void testWeatherDataObservers(){
        weatherData = new WeatherData();
        weatherData.restart();
        statisticsDisplay = new StatisticsDisplay(weatherData);
        currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        Random r = new Random();
        for(int i = 0; i < LEN; i++){
            temp[i] = r.nextDouble();
            pressure[i] = 1000 + r.nextInt(10);
            humidity[i] = r.nextInt(100);
        }

        for(int i = 0; i < LEN; i++){
            weatherData.setMeasurements(temp[i], pressure[i], humidity[i]);
            System.out.print(weatherData.toString());
            statisticsDisplay.display();
            currentConditionDisplay.display();

            assertTrue("CurrentConditionDisplay notification error",
                    currentConditionDisplay.getTemperature() == weatherData.getTemperature());
            assertTrue("CurrentConditionDisplay notification error",
                    currentConditionDisplay.getHumidity() == weatherData.getHumidity());
            assertTrue("CurrentConditionDisplay notification error",
                    currentConditionDisplay.getPressure() == weatherData.getPressure());

        }

        weatherData.restart();
        assertTrue("restart statistics error", statisticsDisplay.getTemperature() == 0);
        assertTrue("restart statistics error", statisticsDisplay.getHumidity() == 0);
        assertTrue("restart statistics error", statisticsDisplay.getPressure() == 0);

        weatherData.setMeasurements(temp[0], pressure[0], humidity[0]);
        assertTrue("restart statistics error",
                statisticsDisplay.getPressure() == weatherData.getPressure());
        assertTrue("restart statistics error",
                statisticsDisplay.getHumidity() == weatherData.getHumidity());
        assertTrue("restart statistics error",
                statisticsDisplay.getTemperature() == weatherData.getTemperature());

        weatherData.removeObserver(currentConditionDisplay);
        assertTrue("remove observer error",
                (weatherData.getObservers().get(0) instanceof StatisticsDisplay));
    }


}
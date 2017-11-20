import model.ForecastData;
import org.junit.Test;

import view.ForecastDisplay;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class ForecastDataTest {
    final int LEN = 100;
    double temp[] = new double[LEN];
    int pressure[] = new int[LEN];
    int humidity[] = new int[LEN];

    ForecastData forecastData;
    ForecastDisplay forecastDisplay;

    @Test public void testForecastDataUpdating(){
        forecastData = new ForecastData();
        forecastDisplay = new ForecastDisplay(forecastData);

        Random r = new Random();
        for(int i = 0; i < LEN; i++){
            temp[i] = r.nextDouble();
            pressure[i] = 1000 + r.nextInt(10);
            humidity[i] = r.nextInt(100);
        }
        for(int i = 0; i < LEN; i++){
            forecastData.setMeasurements(temp[i], pressure[i], humidity[i]);
            System.out.print(forecastData.toString());
            forecastDisplay.display();

            assertTrue("ForecastDisplay notification error",
                    forecastDisplay.getTemperature() == forecastData.getTemperature());
            assertTrue("ForecastDisplay notification error",
                    forecastDisplay.getHumidity() == forecastData.getHumidity());
            assertTrue("ForecastDisplay notification error",
                    forecastDisplay.getPressure() == forecastData.getPressure());
        }

        forecastData.removeObserver(forecastDisplay);
        assertTrue("ForecastDisplay notification error",
                forecastData.getObservers().size() == 0);
    }
}

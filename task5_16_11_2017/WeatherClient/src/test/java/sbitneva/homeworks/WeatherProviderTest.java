import controller.WeatherProvider;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WeatherProviderTest {

    @Test public void weatherLondon(){
        WeatherProvider weatherProvider = new WeatherProvider("London");
        WeatherProvider weatherProvider2 = new WeatherProvider("");
        assertTrue("Reading JSON problem",
                weatherProvider2.getTemperature() == 0);
        assertTrue("Reading JSON problem",
                weatherProvider2.getFhumidity() == 0);
        assertTrue("Reading JSON problem",
                weatherProvider2.getFpressure() ==0);
        assertTrue("Reading JSON problem",
                weatherProvider2.getFtemperature() == 0);
        assertTrue("Reading JSON problem",
                weatherProvider2.getHumidity() == 0);
        assertTrue("Reading JSON problem",
                weatherProvider2.getPressure() == 0);
    }
}

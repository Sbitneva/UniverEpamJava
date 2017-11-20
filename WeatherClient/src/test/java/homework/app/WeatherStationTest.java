import controller.WeatherStation;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class WeatherStationTest {

    @Test public void testWeatherStation(){
        WeatherStation ws = new WeatherStation();
        assertFalse("", ws.getMenu() == null);
    }
}

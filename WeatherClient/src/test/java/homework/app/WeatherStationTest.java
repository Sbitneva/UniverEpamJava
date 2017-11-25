import controller.WeatherStation;
import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertFalse;

public class WeatherStationTest {

    @Ignore("Can't test GUI on CI job")
    @Test public void testWeatherStation(){
        WeatherStation ws = new WeatherStation();
        assertFalse("", ws.getMenu() == null);
    }
}

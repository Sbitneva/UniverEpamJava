package homework7.app;
import homework7.app.entities.URLReader;
import org.junit.Test;


import java.net.URL;

import static org.junit.Assert.assertTrue;


public class TestUrlReader {

    @Test
    public void testHtmlReading() throws Exception{

        URL filepath1 =  new URL("https://en.wikipedia.org/wiki/Ukraine");
        URL filepath2 = new URL("file:///home/mariia/Documents/MavenProjects/UniverEpamJava/UniverEpamJava/" +
                "task7_23_11_2017/RegEx/src/test/java/homework7/app/source.html");
        String data1 = URLReader.readUrl(filepath1);
        String data2 = URLReader.readUrl(filepath2);
        assertTrue(data1.equals(data2));
    }
}

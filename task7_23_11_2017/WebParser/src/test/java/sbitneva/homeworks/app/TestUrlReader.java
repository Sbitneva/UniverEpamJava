package app;
import app.entities.URLReader;

import org.junit.Test;
import java.net.URL;
import java.io.File;
import static org.junit.Assert.assertEquals;


public class TestUrlReader {

    @Test
    public void testHtmlReading() throws Exception{
        String data1 = URLReader.readUrl(
        	new URL("https://en.wikipedia.org/wiki/Ukraine")
        	);
        String data2 = URLReader.readUrl(
        	new File("src/test/java/sbitneva/homeworks/app/source.html").toURI().toURL()
        	);
        assertEquals(data1, data2);
    }
}

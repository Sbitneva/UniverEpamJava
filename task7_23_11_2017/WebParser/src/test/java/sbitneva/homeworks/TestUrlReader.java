package sbitneva.homeworks;

import org.junit.Test;
import sbitneva.homeworks.entities.URLReader;

import java.net.URL;

import static org.junit.Assert.assertFalse;


public class TestUrlReader {

    @Test
    public void testHtmlReading() throws Exception {
        String data1 = URLReader.readUrl(
                new URL("https://en.wikipedia.org/wiki/Ukraine"));

        assertFalse(data1.equals(""));
    }
}

package sbitneva.homeworks;
import sbitneva.homeworks.entities.AircraftWithAmmunition;
import org.junit.Before;
import org.junit.Test;
import sbitneva.homeworks.parsers.dom.DomXmlParser;
import sbitneva.homeworks.parsers.sax.SaxXmlParser;
import sbitneva.homeworks.parsers.stax.StaxXmlParser;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class TestParsers {
    private final String path = "xml/aircraft_set.xml";
    private DomXmlParser domXmlParser = null;
    private SaxXmlParser saxXmlParser = null;
    private StaxXmlParser staxXmlParser = null;
    private ArrayList<AircraftWithAmmunition> aircraftsFromDom = null;
    private ArrayList<AircraftWithAmmunition> aircraftsFromSax = null;
    private ArrayList<AircraftWithAmmunition> aircraftsFromStax = null;


    @Before
    public void beforeTesting(){
        domXmlParser = new DomXmlParser();
        saxXmlParser = new SaxXmlParser();
        staxXmlParser = new StaxXmlParser();
        aircraftsFromDom = domXmlParser.read(path);
        aircraftsFromSax = saxXmlParser.getObjects(path);
        aircraftsFromStax = staxXmlParser.getAircraftList(path);
    }

    @Test
    public void testObjects(){
        assertEquals(aircraftsFromDom.toString(), aircraftsFromSax.toString());
        assertEquals(aircraftsFromDom.toString(), aircraftsFromStax.toString());
    }

    @Test
    public void testObjectFromDomXmlParser(){
        assertEquals(aircraftsFromDom.get(0).getId(), "1");
        assertEquals(aircraftsFromDom.get(0).getModel(), "Sukhoi Su-34");
        assertEquals(aircraftsFromDom.get(0).getOrigin(), "Russia");
        assertEquals(aircraftsFromDom.get(0).getType(), "reconnaissance");
        assertEquals(aircraftsFromDom.get(0).getSeats(), 2);
        assertEquals(aircraftsFromDom.get(0).isRadar(), true);
    }
}

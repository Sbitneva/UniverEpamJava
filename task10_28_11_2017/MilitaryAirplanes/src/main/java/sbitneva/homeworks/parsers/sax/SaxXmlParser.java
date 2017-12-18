package sbitneva.homeworks.parsers.sax;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import sbitneva.homeworks.entities.AircraftWithAmmunition;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaxXmlParser {

    private static Logger log = Logger.getLogger(SaxXmlParser.class.getName());
    private SAXParserFactory factory;
    private SAXParser saxParser;

    public SaxXmlParser() {

        try {
            factory = SAXParserFactory.newInstance();
            saxParser = factory.newSAXParser();
        } catch (SAXException e) {
            log.error(e.getMessage());
        } catch (ParserConfigurationException ex) {
            log.error(ex.getMessage());
        }
    }

    public ArrayList<AircraftWithAmmunition> getObjects(String path) {

        AircraftHandler handler = new AircraftHandler();
        ArrayList<AircraftWithAmmunition> militaryAircrafts = new ArrayList<>();
        XMLReader xmlReader = null;
        try {
            xmlReader = saxParser.getXMLReader();
        } catch (SAXException e) {
            log.error(e.getMessage());
            return null;
        }
        xmlReader.setContentHandler(handler);
        File xmlFile = new File(path);
        try {
            xmlReader.parse(xmlFile.toURI().toString());
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        } catch (SAXException ex) {
            log.error(ex.getMessage());
            return null;
        }
        log.debug("Xml is parsed using Sax Parser ");

        militaryAircrafts = handler.getAircrafts();
        log.debug(militaryAircrafts.toString());

        return militaryAircrafts;
    }
}

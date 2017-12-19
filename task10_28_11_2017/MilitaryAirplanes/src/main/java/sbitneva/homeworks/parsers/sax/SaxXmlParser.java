package sbitneva.homeworks.parsers.sax;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import sbitneva.homeworks.entities.AircraftWithAmmunition;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;

public class SaxXmlParser {

    private static Logger log = Logger.getLogger(SaxXmlParser.class.getName());
    private SAXParser saxParser;

    public SaxXmlParser() {
        SAXParserFactory factory;
        try {
            factory = SAXParserFactory.newInstance();
            saxParser = factory.newSAXParser();
        } catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public ArrayList<AircraftWithAmmunition> getObjects(String path) {

        AircraftHandler handler = new AircraftHandler();
        ArrayList<AircraftWithAmmunition> militaryAircraft;
        XMLReader xmlReader;
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
        } catch (Exception e){
            log.error(e.getMessage());
        }
        log.debug("Xml is parsed using Sax Parser ");

        militaryAircraft = handler.getAircraftList();
        log.debug(militaryAircraft.toString());

        return militaryAircraft;
    }
}

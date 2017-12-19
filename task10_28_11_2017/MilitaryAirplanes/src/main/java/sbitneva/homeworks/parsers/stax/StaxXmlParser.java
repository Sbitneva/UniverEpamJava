package sbitneva.homeworks.parsers.stax;

import com.sun.istack.internal.NotNull;
import org.apache.log4j.Logger;
import sbitneva.homeworks.entities.Aircraft;
import sbitneva.homeworks.entities.AircraftWithAmmunition;
import sbitneva.homeworks.parsers.Parser;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class StaxXmlParser {

    private static Logger log = Logger.getLogger(StaxXmlParser.class.getName());

    private ArrayList<AircraftWithAmmunition> aircrafts;

    public ArrayList<AircraftWithAmmunition> getAircrafts(String path) {
        aircrafts = new ArrayList<>();
        AircraftWithAmmunition militaryAircraft = new AircraftWithAmmunition();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        AircraftWithAmmunition.AircraftParameters parameters = new Aircraft.AircraftParameters();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals(Parser.PLANE)) {
                        militaryAircraft = new AircraftWithAmmunition();
                        parameters = new AircraftWithAmmunition.AircraftParameters();
                        militaryAircraft.setParameters(parameters);
                    } else if (startElement.getName().getLocalPart().equals(Parser.ID)) {
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setId(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals(Parser.MODEL)) {
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setModel(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals(Parser.ORIGIN)) {
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setOrigin(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals(Parser.TYPE)) {
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setType(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals(Parser.SEATS)) {
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setSeats(Integer.valueOf(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals(Parser.RADAR)) {
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setRadar(Boolean.valueOf(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals(Parser.PRICE)) {
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setPrice(Integer.valueOf(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals(Parser.WIDTH)) {
                        xmlEvent = xmlEventReader.nextEvent();
                        parameters.setWidth(Integer.valueOf(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals(Parser.LENGTH)) {
                        xmlEvent = xmlEventReader.nextEvent();
                        parameters.setLenght(Integer.valueOf(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals(Parser.HEIGHT)) {
                        xmlEvent = xmlEventReader.nextEvent();
                        parameters.setHeight(Integer.valueOf(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals(Parser.AMMUNITION)) {
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setAmmunition(Byte.valueOf(xmlEvent.asCharacters().getData()));
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals(Parser.PLANE)) {
                        aircrafts.add(militaryAircraft);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            log.error(e.getMessage());
        }
        return aircrafts;
    }
}

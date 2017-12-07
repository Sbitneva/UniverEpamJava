package parsers.stax;

import entities.AircraftWithAmmunition;
import org.apache.log4j.Logger;
import parsers.sax.SaxXmlParser;

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

    static Logger log = Logger.getLogger(StaxXmlParser.class.getName());

    ArrayList<AircraftWithAmmunition> aircrafts;

    public ArrayList<AircraftWithAmmunition> getAircrafts(String path){
        aircrafts = new ArrayList<>();
        AircraftWithAmmunition militaryAircraft = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        AircraftWithAmmunition.AircraftParameters parameters = null;
        try{
            XMLEventReader xmlEventReader= xmlInputFactory.createXMLEventReader(new FileInputStream(path));
            while(xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if(xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    if(startElement.getName().getLocalPart().equals("plane")){
                        militaryAircraft = new AircraftWithAmmunition();
                        parameters = new AircraftWithAmmunition.AircraftParameters();
                        militaryAircraft.setParameters(parameters);
                    }else if(startElement.getName().getLocalPart().equals("id")){
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setId(xmlEvent.asCharacters().getData());
                    }else if(startElement.getName().getLocalPart().equals("model")){
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setModel(xmlEvent.asCharacters().getData());
                    }else if(startElement.getName().getLocalPart().equals("origin")){
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setOrigin(xmlEvent.asCharacters().getData());
                    }else if(startElement.getName().getLocalPart().equals("type")){
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setType(xmlEvent.asCharacters().getData());
                    }else if(startElement.getName().getLocalPart().equals("seats")){
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setSeats(Integer.valueOf(xmlEvent.asCharacters().getData()));
                    }else if(startElement.getName().getLocalPart().equals("radar")){
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setRadar(Boolean.valueOf(xmlEvent.asCharacters().getData()));
                    }else if(startElement.getName().getLocalPart().equals("price")){
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setPrice(Integer.valueOf(xmlEvent.asCharacters().getData()));
                    }else if(startElement.getName().getLocalPart().equals("width")){
                        xmlEvent = xmlEventReader.nextEvent();
                        parameters.setWidth(Integer.valueOf(xmlEvent.asCharacters().getData()));
                    }else if(startElement.getName().getLocalPart().equals("length")){
                        xmlEvent = xmlEventReader.nextEvent();
                        parameters.setLenght(Integer.valueOf(xmlEvent.asCharacters().getData()));
                    }else if(startElement.getName().getLocalPart().equals("height")){
                        xmlEvent = xmlEventReader.nextEvent();
                        parameters.setHeight(Integer.valueOf(xmlEvent.asCharacters().getData()));
                    }else if(startElement.getName().getLocalPart().equals("ammunition")){
                        xmlEvent = xmlEventReader.nextEvent();
                        militaryAircraft.setAmmunition(Byte.valueOf(xmlEvent.asCharacters().getData()));
                    }
                }
                if(xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if(endElement.getName().getLocalPart().equals("plane")){
                        aircrafts.add(militaryAircraft);
                    }
                }
            }
        }catch(FileNotFoundException | XMLStreamException e){
            log.error(e.getMessage());
        }
        return aircrafts;
    }
}

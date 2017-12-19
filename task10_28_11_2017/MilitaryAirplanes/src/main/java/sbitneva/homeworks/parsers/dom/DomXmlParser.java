package sbitneva.homeworks.parsers.dom;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import sbitneva.homeworks.entities.Aircraft;
import sbitneva.homeworks.entities.AircraftWithAmmunition;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;

import sbitneva.homeworks.parsers.Parser;

public class DomXmlParser {

    private static Logger log = Logger.getLogger(DomXmlParser.class.getName());
    private DocumentBuilder db = null;

    public DomXmlParser() {
        DocumentBuilderFactory dbf;
        try {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.error("DocumentBuilder exception" + e.getMessage());
        }
    }

    public ArrayList<AircraftWithAmmunition> read(String path) {
        ArrayList<AircraftWithAmmunition> aircrafts = new ArrayList<>();
        Document doc;
        try {
            doc = db.parse(new File(path));
            log.debug("Document from file " + path + "is created");

        } catch (Exception e) {
            log.error("Document from file " + path + "doesn't created " + e.getMessage());
            return null;
        }

        Element root = doc.getDocumentElement();

        if (root.getTagName().equals(Parser.PLANES)) {

            NodeList aircraftList = root.getElementsByTagName(Parser.PLANE);

            for (int i = 0; i < aircraftList.getLength(); i++) {

                AircraftWithAmmunition militaryAircraft = AircraftWithAmmunition.aircraftWithAmmunitionFactory();
                Element plane = (Element) aircraftList.item(i);

                militaryAircraft.setId(plane.getElementsByTagName(Parser.ID).item(0).getTextContent());
                militaryAircraft.setModel(plane.getElementsByTagName(Parser.MODEL).item(0).getTextContent());
                militaryAircraft.setOrigin(plane.getElementsByTagName(Parser.ORIGIN).item(0).getTextContent());
                militaryAircraft.setType(plane.getElementsByTagName(Parser.TYPE).item(0).getTextContent());

                if (!militaryAircraft.getType().equals(Parser.RECONNAISSANCE)) {
                    militaryAircraft.setAmmunition(Byte.valueOf(plane.getElementsByTagName(Parser.AMMUNITION).
                            item(0).getTextContent()));
                }

                militaryAircraft.setSeats(
                        Byte.valueOf(plane.getElementsByTagName(Parser.SEATS).item(0).getTextContent()));
                militaryAircraft.setRadar(
                        Boolean.valueOf(plane.getElementsByTagName(Parser.RADAR).item(0).getTextContent()));
                militaryAircraft.setPrice(
                        Integer.valueOf(plane.getElementsByTagName(Parser.PRICE).item(0).getTextContent()));
                Element parameters = (Element) plane.getElementsByTagName(Parser.PARAMETERS).item(0);
                Aircraft.AircraftParameters aircraftParameters = new Aircraft.AircraftParameters();
                aircraftParameters.setWidth(Integer.valueOf(parameters.getElementsByTagName(Parser.WIDTH).
                        item(0).getTextContent()));
                aircraftParameters.setLenght(Integer.valueOf(parameters.getElementsByTagName(Parser.LENGTH).
                        item(0).getTextContent()));
                aircraftParameters.setHeight(Integer.valueOf(parameters.getElementsByTagName(Parser.HEIGHT).
                        item(0).getTextContent()));
                militaryAircraft.setParameters(aircraftParameters);
                aircrafts.add(militaryAircraft);
                log.debug("XML Document is parsed using DOM parser");
            }
        }
        return aircrafts;
    }
}

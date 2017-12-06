package parsers.dom;

import entities.AircraftWithAmmunition;
import entities.Aircraft;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;

public class DomXmlParser {

    static Logger log = Logger.getLogger(DomXmlParser.class.getName());
    DocumentBuilderFactory dbf = null;
    DocumentBuilder db = null;

    public DomXmlParser(){
        try
        {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
        }
        catch(ParserConfigurationException e)
        {
            log.error("DocumentBuilder exception" + e.getMessage());
        }
    }

    public ArrayList<AircraftWithAmmunition> read(String path){
        ArrayList<AircraftWithAmmunition> aircrafts = new ArrayList<>();
        Document doc = null;
        try{
            doc = db.parse(new File(path));
            log.debug("Document from file " + path + "is created");

        }
        catch (Exception e){
            log.error("Document from file " + path + "doesn't created " + e.getMessage());
            return null;
        }

        Element root = doc.getDocumentElement();

        if(root.getTagName().equals("planes")){

            NodeList aircraftsList = root.getElementsByTagName("plane");


            System.out.println(" Length::" + aircraftsList.getLength());

            for(int i = 0; i < aircraftsList.getLength(); i++){

                AircraftWithAmmunition militaryAircraft = AircraftWithAmmunition.aircraftWithAmmunitionFactory();
                Element plane = (Element) aircraftsList.item(i);

                militaryAircraft.setId(plane.getElementsByTagName("id").item(0).getTextContent());
                militaryAircraft.setModel(plane.getElementsByTagName("model").item(0).getTextContent());
                militaryAircraft.setOrigin(plane.getElementsByTagName("origin").item(0).getTextContent());
                militaryAircraft.setType(plane.getElementsByTagName("type").item(0).getTextContent());
                if(!militaryAircraft.getType().equals("reconnaissance")) {
                    militaryAircraft.setAmmunition(Byte.valueOf(plane.getElementsByTagName("ammunition").
                            item(0).getTextContent()));
                }
                militaryAircraft.setSeats(Byte.valueOf(plane.getElementsByTagName("seats").item(0).getTextContent()));

                militaryAircraft.setRadar(Boolean.valueOf(plane.getElementsByTagName("radar").item(0).getTextContent()));
                militaryAircraft.setPrice(Integer.valueOf(plane.getElementsByTagName("price").item(0).getTextContent()));

                Element parameters = (Element)plane.getElementsByTagName("parameters").item(0);

                Aircraft.AircraftParameters aircraftParameters = new Aircraft.AircraftParameters();

                aircraftParameters.setWidth(Integer.valueOf(parameters.getElementsByTagName("width").
                        item(0).getTextContent()));
                aircraftParameters.setLenght(Integer.valueOf(parameters.getElementsByTagName("length").
                        item(0).getTextContent()));
                aircraftParameters.setHeight(Integer.valueOf(parameters.getElementsByTagName("height").
                        item(0).getTextContent()));
                militaryAircraft.setParameters(aircraftParameters);

                aircrafts.add(militaryAircraft);
                log.debug("XML Document is parsed");
            }
        }
        return aircrafts;
    }


}

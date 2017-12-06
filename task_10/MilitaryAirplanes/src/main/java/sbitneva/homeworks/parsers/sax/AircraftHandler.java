package parsers.sax;

import entities.Aircraft;
import entities.AircraftWithAmmunition;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class AircraftHandler extends DefaultHandler {
    private ArrayList<AircraftWithAmmunition> aircrafts = new ArrayList<>();
    private AircraftWithAmmunition militaryAircraft = null;
    private Aircraft.AircraftParameters parameters = null;
    private boolean bId;
    private boolean bModel;
    private boolean bOrigin;
    private boolean bType;
    private boolean bSeats;
    private boolean bRadar;
    private boolean bPrice;
    private boolean bWidth;
    private boolean bHeight;
    private boolean bLength;
    private boolean bAmmunition;

    private String thisElement;
    private static Logger log = Logger.getLogger(AircraftHandler.class.getName());

    public ArrayList<AircraftWithAmmunition> getAircrafts(){
        return this.aircrafts;
    }

    @Override
    public void startDocument() throws SAXException {
        log.debug("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        log.debug("Start element " + qName);
        thisElement = qName;
        if(qName == "plane"){
            log.debug("New plane is founded");
            militaryAircraft = new AircraftWithAmmunition();
            parameters = new AircraftWithAmmunition.AircraftParameters();
            militaryAircraft.setParameters(parameters);
        }else if(qName.equals("id")){
            bId = true;
        }else if(qName.equals("model")){
            bModel = true;
        }else if(qName.equals("origin")){
            bOrigin = true;
        }else if(qName.equals("type")){
            bType = true;
        }else if(qName.equals("seats")){
            bSeats = true;
        }else if(qName.equals("radar")){
            bRadar = true;
        }else if(qName.equals("price")){
            bPrice = true;
        }else if(qName.equals("width")){
            bWidth = true;
        }else if(qName.equals("length")){
            bLength = true;
        }else if(qName.equals("height")){
            bHeight = true;
        }else if(qName.equals("ammunition")){
            bAmmunition = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bId) {
            militaryAircraft.setId(new String(ch, start, length));
            bId = false;
        } else if (bModel) {
            militaryAircraft.setModel(new String(ch, start, length));
            bModel = false;
        }else  if (bOrigin) {
            militaryAircraft.setOrigin(new String(ch, start, length));
            bOrigin = false;
        }
        else if (bType) {
            militaryAircraft.setType(new String(ch, start, length));
            bType = false;
        }
        else if (bSeats) {
            militaryAircraft.setSeats(new Integer(new String(ch, start, length)));
            bSeats = false;
        }
        else if (bRadar) {
            militaryAircraft.setRadar(Boolean.valueOf(new String(ch, start, length)));
            bRadar = false;
        }
        else if (bPrice) {
            militaryAircraft.setPrice(Integer.valueOf(new String(ch, start, length)));
            bPrice = false;
        }
        else if (bWidth) {
            parameters.setWidth(Integer.valueOf(new String(ch, start, length)));
            bWidth = false;
        }
        else if (bLength) {
            parameters.setLenght(new Integer(new String(ch, start, length)));
            bLength = false;
        }
        else if (bHeight) {
            parameters.setHeight(new Integer(new String(ch, start, length)));
            bHeight = false;
        }else if (bAmmunition) {
            militaryAircraft.setAmmunition(new Byte(new String(ch, start, length)));
            bAmmunition = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("plane")){
            aircrafts.add(militaryAircraft);
        }
    }
}

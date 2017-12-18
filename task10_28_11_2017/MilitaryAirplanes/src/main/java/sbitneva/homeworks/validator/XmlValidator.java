package sbitneva.homeworks.validator;

import org.apache.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XmlValidator {

    private static Logger log = Logger.getLogger(XmlValidator.class.getName());

    public static boolean validateAccordingToSchema(String xsdSchemaFilePath, String xmlFilePath) {
        boolean validate = false;
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdSchemaFilePath));
            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(new File(xmlFilePath)));
            validate = true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return validate;
    }
}

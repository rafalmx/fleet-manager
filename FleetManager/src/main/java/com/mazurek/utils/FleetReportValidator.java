package com.mazurek.utils;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FleetReportValidator {

    private static final ClassLoader CLASS_LOADER = FleetReportValidator.class.getClassLoader();

    public boolean isReportValid(String path) {
        Source xmlFile = null;
        try {
            URL schemaFile = CLASS_LOADER.getResource("xsd/flota.xsd");

            xmlFile = new StreamSource(new File(path));

            SchemaFactory schemaFactory = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (SAXException e) {
            System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}

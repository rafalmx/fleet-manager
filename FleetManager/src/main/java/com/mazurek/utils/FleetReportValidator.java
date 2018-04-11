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
            xmlFile = new StreamSource(new File(path));
            Validator validator = getSchema().newValidator();
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (Exception e) {
            System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
            return false;
        }
        return true;
    }

    public static Schema getSchema() throws SAXException {
        URL schemaFile = CLASS_LOADER.getResource("xsd/flota.xsd");
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        return schemaFactory.newSchema(schemaFile);
    }
}

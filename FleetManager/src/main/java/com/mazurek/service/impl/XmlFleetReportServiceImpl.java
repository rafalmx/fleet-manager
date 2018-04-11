package com.mazurek.service.impl;

import com.mazurek.generated.Flota;
import com.mazurek.service.XmlFleetReportService;
import com.mazurek.config.ApplicationProperties;
import com.mazurek.utils.FleetReportValidator;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.helpers.DefaultValidationEventHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import java.io.File;
import java.io.FileReader;

public class XmlFleetReportServiceImpl implements XmlFleetReportService {

    private final ApplicationProperties applicationProperties = ApplicationProperties.getInstance();
    private final static String FILE_NAME = "report.xml";

    @Override
    public String generateReport(Flota fleet){
        String filePath = applicationProperties.getProperty("output.folder") + File.separator + FILE_NAME;
        try {
            JAXBContext context = JAXBContext.newInstance(Flota.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(fleet, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
        return filePath;
    }

    @Override
    public Flota loadReport(String path, boolean isValidationEnabled){
        Flota fleet = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(Flota.class);

            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            XMLReader xmlReader = spf.newSAXParser().getXMLReader();
            InputSource inputSource = new InputSource(new FileReader(path));
            SAXSource source = new SAXSource(xmlReader, inputSource);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            if(isValidationEnabled) {
                unmarshaller.setSchema(FleetReportValidator.getSchema());
                unmarshaller.setEventHandler(new DefaultValidationEventHandler());
            }
            fleet = (Flota) unmarshaller.unmarshal(source);
        }catch (Exception e){
            e.printStackTrace();
        }
        return fleet;
    }

}

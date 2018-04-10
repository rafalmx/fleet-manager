package com.mazurek.service.impl;

import com.mazurek.generated.Flota;
import com.mazurek.service.XmlFleetReportGenerator;
import com.mazurek.config.ApplicationProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class XmlFleetReportGeneratorImpl implements XmlFleetReportGenerator{

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

}

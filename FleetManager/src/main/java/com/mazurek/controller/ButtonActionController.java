package com.mazurek.controller;

import com.mazurek.generated.Flota;
import com.mazurek.service.FleetService;
import com.mazurek.service.XmlFleetReportService;
import com.mazurek.service.impl.FleetServiceImpl;
import com.mazurek.service.impl.XmlFleetReportServiceImpl;
import com.mazurek.utils.FleetMapper;
import com.mazurek.utils.FleetProperties;
import com.mazurek.utils.FleetReportValidator;

import javax.swing.*;
import java.io.File;

public class ButtonActionController {

    private FleetProperties fleetProperties = FleetProperties.getInstance();
    private FleetService fleetService = new FleetServiceImpl();
    private XmlFleetReportService xmlReportService = new XmlFleetReportServiceImpl();
    private FleetReportValidator reportValidator = new FleetReportValidator();
    private FleetMapper fleetMapper = new FleetMapper();

    public void handleGenerateXmlButton(Integer positionCount, Integer carCount, Integer driverCount){
        fleetProperties.updatePropertiesVaules();

        Flota fleet = fleetService.generateFleetReport(positionCount, carCount, driverCount);
        String xmlPath = xmlReportService.generateReport(fleet);
        boolean isReportValid = reportValidator.isReportValid(xmlPath);

        if(isReportValid){
            com.mazurek.persistence.entity.Flota fleetEntity = fleetMapper.map(fleet);
            fleetService.save(fleetEntity);
            JOptionPane.showMessageDialog(null, "XML generated and saved to database");
        }
        else{
            JOptionPane.showMessageDialog(null, "XML not valid - not saved in database");
        }
    }

    public void handleLoadXMLButton(File file, boolean isValidationEnabled){
        try {
            Flota fleet = xmlReportService.loadReport(file.getAbsolutePath(), isValidationEnabled);
            com.mazurek.persistence.entity.Flota fleetEntity = fleetMapper.map(fleet);
            fleetService.save(fleetEntity);
            JOptionPane.showMessageDialog(null, "XML loaded and saved to database");
        }catch (Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "XML loading failed");
        }
    }
}

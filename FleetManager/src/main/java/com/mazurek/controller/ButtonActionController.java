package com.mazurek.controller;

import com.mazurek.generated.Flota;
import com.mazurek.service.FleetService;
import com.mazurek.service.XmlFleetReportGenerator;
import com.mazurek.service.impl.FleetServiceImpl;
import com.mazurek.service.impl.XmlFleetReportGeneratorImpl;
import com.mazurek.utils.FleetMapper;
import com.mazurek.utils.FleetProperties;
import com.mazurek.utils.FleetReportValidator;

import javax.swing.*;

public class ButtonActionController {

    private FleetProperties fleetProperties = FleetProperties.getInstance();
    private FleetService fleetService = new FleetServiceImpl();
    private XmlFleetReportGenerator reportGenerator = new XmlFleetReportGeneratorImpl();
    private FleetReportValidator reportValidator = new FleetReportValidator();
    private FleetMapper fleetMapper = new FleetMapper();

    public void generateXmlButton(Integer positionCount, Integer carCount, Integer driverCount){
        fleetProperties.updatePropertiesVaules();

        Flota fleet = fleetService.generateFleetReport(positionCount, carCount, driverCount);
        String xmlPath = reportGenerator.generateReport(fleet);
        boolean isReportValid = reportValidator.isReportValid(xmlPath);

        if(isReportValid){
            //save to DB
            com.mazurek.persistence.entity.Flota fleetEntity = fleetMapper.map(fleet);
            fleetService.save(fleetEntity);
            JOptionPane.showMessageDialog(null, "XML generated and saved to database");
        }
        else{
            JOptionPane.showMessageDialog(null, "XML not valid - not saved in database");
        }
    }
}

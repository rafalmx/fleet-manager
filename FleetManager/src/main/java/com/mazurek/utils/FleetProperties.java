package com.mazurek.utils;

import com.mazurek.config.ApplicationProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class FleetProperties {

    private static FleetProperties instance = null;

    private ApplicationProperties applicationProperties =  ApplicationProperties.getInstance();

    private String propertiesSearchPath;

    private List<String> brandList;
    private List<String> modelList;
    private List<String> bodyTypeList;
    private List<String> destinationList;
    private List<String> vinList;
    private List<String> colorList;
    private List<String> isMetalicList;
    private List<String> typeList;
    private List<String> capacityList;
    private List<String> powerList;
    private List<String> equipmentDescList;
    private List<String> equipmentValueList;
    private List<String> nameList;
    private List<String> surnameList;
    private List<String> peselList;

    private FleetProperties() {
        propertiesSearchPath = applicationProperties.getProperty("source.folder");
    }

    public static FleetProperties getInstance() {
        if (instance == null) {
            instance = new FleetProperties();
        }
        return instance;
    }

    public void updatePropertiesVaules() {
        brandList = getPropertyValuesList("marka");
        modelList = getPropertyValuesList("model");
        destinationList = getPropertyValuesList("przeznaczenie");
        bodyTypeList = getPropertyValuesList("typ_nadwozia");
        vinList = getPropertyValuesList("vin");
        colorList = getPropertyValuesList("kolor");
        isMetalicList = getPropertyValuesList("czy_metalik");
        typeList = getPropertyValuesList("typ");
        capacityList = getPropertyValuesList("pojemnosc");
        powerList = getPropertyValuesList("moc");
        typeList = getPropertyValuesList("typ");
        equipmentDescList = getPropertyValuesList("opis");
        equipmentValueList = getPropertyValuesList("wartosc");
        nameList = getPropertyValuesList("imie");
        surnameList = getPropertyValuesList("nazwisko");
        peselList = getPropertyValuesList("pesel");
    }

    private List<String> getPropertyValuesList(String propertyName) {
        String propertyFilePath = propertiesSearchPath + "/" + propertyName + ".properties";
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> values = new ArrayList<String>();
        Enumeration e = properties.propertyNames();
        while (e.hasMoreElements()) {
            values.add((String) e.nextElement());
        }
        return values;
    }

    public List<String> getBrandList() {
        return brandList;
    }

    public List<String> getModelList() {
        return modelList;
    }

    public List<String> getBodyTypeList() {
        return bodyTypeList;
    }

    public List<String> getDestinationList() {
        return destinationList;
    }

    public List<String> getVinList() {
        return vinList;
    }

    public List<String> getColorList() {
        return colorList;
    }

    public List<String> getIsMetalicList() {
        return isMetalicList;
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public List<String> getCapacityList() {
        return capacityList;
    }

    public List<String> getPowerList() {
        return powerList;
    }

    public List<String> getEquipmentDescList() {
        return equipmentDescList;
    }

    public List<String> getEquipmentValueList() {
        return equipmentValueList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public List<String> getSurnameList() {
        return surnameList;
    }

    public List<String> getPeselList() {
        return peselList;
    }
}

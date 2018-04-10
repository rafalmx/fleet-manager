package com.mazurek.service.impl;

import com.mazurek.generated.*;
import com.mazurek.persistence.service.FleetDao;
import com.mazurek.persistence.service.impl.FleetDaoImpl;
import com.mazurek.service.FleetService;
import com.mazurek.utils.FleetProperties;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FleetServiceImpl implements FleetService {

    FleetProperties properties = FleetProperties.getInstance();
    FleetDao fleetDao = new FleetDaoImpl();

    @Override
    public Flota generateFleetReport(int positionCount, int carCount, int driverCount) {
        Flota flota = new Flota();

        for (int i = 0; i < positionCount; i++) {
            flota.getPozycja().add(generatePositionInReport(carCount, driverCount));
        }
        return flota;
    }

    @Override
    public void save(com.mazurek.persistence.entity.Flota flota) {
        fleetDao.save(flota);
        System.out.println("Flota saved successfuly");
    }

    private KierowcyPojazdy generatePositionInReport(int carCount, int driverCount) {
        KierowcyPojazdy kierowcyPojazdy = new KierowcyPojazdy();

        for (int i = 0; i < carCount; i++) {
            kierowcyPojazdy.getPojazd().add(generateCarReport());
        }
        for (int i = 0; i < driverCount; i++) {
            kierowcyPojazdy.getKierowcy().add(generateDriverReport());
        }
        return kierowcyPojazdy;
    }

    private Kierowca generateDriverReport() {
        Kierowca driver = new Kierowca();
        driver.setImie(getRandomFromList(properties.getNameList()));
        driver.setNazwisko(getRandomFromList(properties.getSurnameList()));
        driver.setPesel(getRandomFromList(properties.getPeselList()));
        return driver;
    }

    private Pojazd generateCarReport() {
        Pojazd car = new Pojazd();
        car.setMarka(getRandomFromList(properties.getBrandList()));
        car.setModel(getRandomFromList(properties.getModelList()));
        car.setVIN(getRandomFromList(properties.getVinList()));
        car.setSilnik(generateEngineReport());
        car.setTyp(generateTypeReport());
        car.setWyposazenie(generateEquipmentReport());
        car.setLakier(generateLacquerReport());
        return car;
    }

    private TypLakieru generateLacquerReport() {
        TypLakieru typLakieru = new TypLakieru();
        typLakieru.setKolor(getRandomFromList(properties.getColorList()));
        typLakieru.setCzyMetalik(getRandomFromList(properties.getIsMetalicList()));
        return typLakieru;
    }

    private PozycjeWyposazenia generateEquipmentReport() {
        PozycjeWyposazenia pozycjeWyposazenia = new PozycjeWyposazenia();
        PozycjaWyposazenia pozycjaWyposazenia = new PozycjaWyposazenia();
        pozycjaWyposazenia.setOpis(getRandomFromList(properties.getEquipmentDescList()));
        pozycjaWyposazenia.setWartosc(new BigDecimal(getRandomIntFromList(properties.getEquipmentValueList())));
        pozycjeWyposazenia.getDodatki().add(pozycjaWyposazenia);
        return pozycjeWyposazenia;
    }

    private TypPojazdu generateTypeReport() {
        TypPojazdu typPojazdu = new TypPojazdu();
        typPojazdu.setTypNadwozia(getRandomFromList(properties.getBodyTypeList()));
        typPojazdu.setPrzeznaczenie(getRandomFromList(properties.getDestinationList()));
        return typPojazdu;
    }

    private Silnik generateEngineReport() {
        Silnik silnik = new Silnik();
        silnik.setTyp(getRandomFromList(properties.getTypeList()));
        silnik.setPojemnosc(getRandomIntFromList(properties.getCapacityList()));
        silnik.setMoc(getRandomIntFromList(properties.getPowerList()));
        return silnik;
    }

    private String getRandomFromList(List<String> givenList) {
        if(givenList.size() < 1){
            return RandomStringUtils.randomAlphabetic(10);
        }
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private int getRandomIntFromList(List<String> givenList){
        if(givenList.size() < 1){
            return ThreadLocalRandom.current().nextInt(600, 7000 + 1);
        }
        Random rand = new Random();
        return Integer.parseInt(givenList.get(rand.nextInt(givenList.size())));
    }
}

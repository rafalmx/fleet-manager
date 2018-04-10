package com.mazurek.utils;

import com.mazurek.generated.*;
import com.mazurek.persistence.entity.Flota;
import com.mazurek.persistence.entity.Pozycja;
import com.mazurek.persistence.entity.enumeration.Przeznaczenie;
import com.mazurek.persistence.entity.enumeration.TypNadwozia;
import com.mazurek.persistence.entity.enumeration.TypSilnika;

import java.util.ArrayList;
import java.util.List;

public class FleetMapper {

    public Flota map(com.mazurek.generated.Flota flota){
        Flota flotaEntity = new Flota();
        flota.getPozycja().forEach(pozycja -> flotaEntity.getPozycje().add(mapPozycja(pozycja)));
        return flotaEntity;
    }

    private Pozycja mapPozycja(KierowcyPojazdy pozycja) {
        Pozycja pozycjaEntity = new Pozycja();
        pozycja.getPojazd().forEach(pojazd -> pozycjaEntity.getPojazdy().add(mapPojazd(pojazd)));
        pozycja.getKierowcy().forEach(kierowca -> pozycjaEntity.getKierowcy().add(mapKierowca(kierowca)));
        return pozycjaEntity;
    }

    private com.mazurek.persistence.entity.Kierowca mapKierowca(Kierowca kierowca) {
        com.mazurek.persistence.entity.Kierowca kierowcaEntity = new com.mazurek.persistence.entity.Kierowca();
        kierowcaEntity.setImie(kierowca.getImie());
        kierowcaEntity.setNazwisko(kierowca.getNazwisko());
        kierowcaEntity.setPesel(kierowca.getPesel());
        return kierowcaEntity;
    }

    private com.mazurek.persistence.entity.Pojazd mapPojazd(Pojazd pojazd) {
        com.mazurek.persistence.entity.Pojazd pojazdEntity = new com.mazurek.persistence.entity.Pojazd();
        pojazdEntity.setMarka(pojazd.getMarka());
        pojazdEntity.setModel(pojazd.getModel());
        pojazdEntity.setVin(pojazd.getVIN());
        pojazdEntity.setLakier(mapLakier(pojazd.getLakier()));
        pojazdEntity.setSilnik(mapSilnik(pojazd.getSilnik()));
        pojazdEntity.setTypPojazdu(mapTypPojazdu(pojazd.getTyp()));
        pojazdEntity.setWyposazenie(mapWyposazenie(pojazd.getWyposazenie()));
        return pojazdEntity;
    }

    private List<com.mazurek.persistence.entity.embedable.PozycjaWyposazenia> mapWyposazenie(PozycjeWyposazenia wyposazenie) {
        List<com.mazurek.persistence.entity.embedable.PozycjaWyposazenia> wyposazenieEntity = new ArrayList<>();
        wyposazenie.getDodatki().forEach(pozycjaWyposazenia -> wyposazenieEntity.add(mapPozycjaWyposazenia(pozycjaWyposazenia)));
        return wyposazenieEntity;
    }

    private com.mazurek.persistence.entity.embedable.PozycjaWyposazenia mapPozycjaWyposazenia(PozycjaWyposazenia pozycjaWyposazenia) {
        com.mazurek.persistence.entity.embedable.PozycjaWyposazenia pwEntity = new com.mazurek.persistence.entity.embedable.PozycjaWyposazenia();
        pwEntity.setOpis(pozycjaWyposazenia.getOpis());
        pwEntity.setWartosc(pozycjaWyposazenia.getWartosc());
        return pwEntity;
    }

    private com.mazurek.persistence.entity.embedable.TypPojazdu mapTypPojazdu(TypPojazdu typ) {
        com.mazurek.persistence.entity.embedable.TypPojazdu typPojazduEntity = new com.mazurek.persistence.entity.embedable.TypPojazdu();
        typPojazduEntity.setTypNadwozia(TypNadwozia.valueOf(typ.getTypNadwozia()));
        typPojazduEntity.setPrzeznaczenie(Przeznaczenie.valueOfString(typ.getPrzeznaczenie()));
        return typPojazduEntity;
    }

    private com.mazurek.persistence.entity.embedable.Silnik mapSilnik(Silnik silnik) {
        com.mazurek.persistence.entity.embedable.Silnik silnikEntity = new com.mazurek.persistence.entity.embedable.Silnik();
        silnikEntity.setTyp(TypSilnika.valueOf(silnik.getTyp()));
        silnikEntity.setPojemnosc(silnik.getPojemnosc());
        silnikEntity.setMoc(silnik.getMoc());
        return silnikEntity;
    }

    private com.mazurek.persistence.entity.embedable.TypLakieru mapLakier(TypLakieru lakier) {
        com.mazurek.persistence.entity.embedable.TypLakieru typLakieruEntity = new com.mazurek.persistence.entity.embedable.TypLakieru();
        typLakieruEntity.setCzyMetalik(lakier.getCzyMetalik().equals("T") ? true : false);
        typLakieruEntity.setKolor(lakier.getKolor());
        return typLakieruEntity;
    }
}

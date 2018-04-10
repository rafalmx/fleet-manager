package com.mazurek.persistence.entity;

import com.mazurek.persistence.entity.embedable.PozycjaWyposazenia;
import com.mazurek.persistence.entity.embedable.Silnik;
import com.mazurek.persistence.entity.embedable.TypLakieru;
import com.mazurek.persistence.entity.embedable.TypPojazdu;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pojazd")
public class Pojazd extends AbstractEntity{

    @Column(name = "MARKA", nullable = false, length = 64)
    private String marka;

    @Column(name = "MODEL", nullable = false, length = 64)
    private String model;

    @Embedded
    private TypPojazdu typPojazdu;

    @Column(name = "VIN", nullable = false, length = 64)
    private String vin;

    @Embedded
    private TypLakieru lakier;

    @Embedded
    private Silnik silnik;

    @ElementCollection
    private List<PozycjaWyposazenia> wyposazenie = new ArrayList<>();


    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public TypPojazdu getTypPojazdu() {
        return typPojazdu;
    }

    public void setTypPojazdu(TypPojazdu typPojazdu) {
        this.typPojazdu = typPojazdu;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public TypLakieru getLakier() {
        return lakier;
    }

    public void setLakier(TypLakieru lakier) {
        this.lakier = lakier;
    }

    public Silnik getSilnik() {
        return silnik;
    }

    public void setSilnik(Silnik silnik) {
        this.silnik = silnik;
    }

    public List<PozycjaWyposazenia> getWyposazenie() {
        return wyposazenie;
    }

    public void setWyposazenie(List<PozycjaWyposazenia> wyposazenie) {
        this.wyposazenie = wyposazenie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pojazd)) return false;

        Pojazd pojazd = (Pojazd) o;
        if (marka != null ? !marka.equals(pojazd.marka) : pojazd.marka != null) return false;
        if (model != null ? !model.equals(pojazd.model) : pojazd.model != null) return false;
        if (typPojazdu != null ? !typPojazdu.equals(pojazd.typPojazdu) : pojazd.typPojazdu != null) return false;
        if (vin != null ? !vin.equals(pojazd.vin) : pojazd.vin != null) return false;
        if (lakier != null ? !lakier.equals(pojazd.lakier) : pojazd.lakier != null) return false;
        if (silnik != null ? !silnik.equals(pojazd.silnik) : pojazd.silnik != null) return false;
        return wyposazenie != null ? wyposazenie.equals(pojazd.wyposazenie) : pojazd.wyposazenie == null;
    }

    @Override
    public int hashCode() {
        int result = marka != null ? marka.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (typPojazdu != null ? typPojazdu.hashCode() : 0);
        result = 31 * result + (vin != null ? vin.hashCode() : 0);
        result = 31 * result + (lakier != null ? lakier.hashCode() : 0);
        result = 31 * result + (silnik != null ? silnik.hashCode() : 0);
        result = 31 * result + (wyposazenie != null ? wyposazenie.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pojazd{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", typPojazdu=" + typPojazdu +
                ", vin='" + vin + '\'' +
                ", lakier=" + lakier +
                ", silnik=" + silnik +
                ", wyposazenie=" + wyposazenie +
                '}';
    }
}

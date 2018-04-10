package com.mazurek.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "KIEROWCA")
public class Kierowca extends AbstractEntity {

    @Column(name = "IMIE")
    private String imie;

    @Column(name = "NAZWISKO")
    private String nazwisko;

    @Column(name = "PESEL")
    private String pesel;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kierowca)) return false;

        Kierowca kierowca = (Kierowca) o;

        if (imie != null ? !imie.equals(kierowca.imie) : kierowca.imie != null) return false;
        if (nazwisko != null ? !nazwisko.equals(kierowca.nazwisko) : kierowca.nazwisko != null) return false;
        return pesel != null ? pesel.equals(kierowca.pesel) : kierowca.pesel == null;
    }

    @Override
    public int hashCode() {
        int result = imie != null ? imie.hashCode() : 0;
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Kierowca{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}

package com.mazurek.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FLOTA")
public class Flota extends AbstractEntity {

    @OneToMany
    @JoinColumn(name = "FLOTA_ID", referencedColumnName = "ID")
    private List<Pozycja> pozycje = new ArrayList<>();

    public List<Pozycja> getPozycje() {
        return pozycje;
    }

    public void setPozycje(List<Pozycja> pozycje) {
        this.pozycje = pozycje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flota)) return false;

        Flota flota = (Flota) o;
        return pozycje != null ? pozycje.equals(flota.pozycje) : flota.pozycje == null;
    }

    @Override
    public int hashCode() {
        return pozycje != null ? pozycje.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Flota{" + "pozycje=" + pozycje + '}';
    }
}

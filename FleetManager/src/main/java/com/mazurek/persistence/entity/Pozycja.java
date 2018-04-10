package com.mazurek.persistence.entity;

import com.mazurek.persistence.entity.AbstractEntity;
import com.mazurek.persistence.entity.Kierowca;
import com.mazurek.persistence.entity.Pojazd;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pozycja")
public class Pozycja extends AbstractEntity{

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="POZYCJA_ID", referencedColumnName="ID")
    private List<Pojazd> pojazdy = new ArrayList<>();

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="POZYCJA_ID", referencedColumnName="ID")
    private List<Kierowca> kierowcy = new ArrayList<>();

    public List<Pojazd> getPojazdy() {
        return pojazdy;
    }

    public void setPojazdy(List<Pojazd> pojazdy) {
        this.pojazdy = pojazdy;
    }

    public List<Kierowca> getKierowcy() {
        return kierowcy;
    }

    public void setKierowcy(List<Kierowca> kierowcy) {
        this.kierowcy = kierowcy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pozycja)) return false;

        Pozycja pozycja = (Pozycja) o;
        if (pojazdy != null ? !pojazdy.equals(pozycja.pojazdy) : pozycja.pojazdy != null) return false;
        return kierowcy != null ? kierowcy.equals(pozycja.kierowcy) : pozycja.kierowcy == null;
    }

    @Override
    public int hashCode() {
        int result = pojazdy != null ? pojazdy.hashCode() : 0;
        result = 31 * result + (kierowcy != null ? kierowcy.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pozycja{" +
                "pojazdy=" + pojazdy +
                ", kierowcy=" + kierowcy +
                '}';
    }
}

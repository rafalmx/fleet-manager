package com.mazurek.persistence.entity.embedable;

import com.mazurek.persistence.entity.enumeration.Przeznaczenie;
import com.mazurek.persistence.entity.enumeration.TypNadwozia;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TypPojazdu {

    @Column(name = "TYP_NADWOZIA", nullable = false)
    private TypNadwozia typNadwozia;

    @Column(name = "PRZEZNACZENIE", nullable = true)
    private Przeznaczenie przeznaczenie;


    public TypNadwozia getTypNadwozia() {
        return typNadwozia;
    }

    public void setTypNadwozia(TypNadwozia typNadwozia) {
        this.typNadwozia = typNadwozia;
    }

    public Przeznaczenie getPrzeznaczenie() {
        return przeznaczenie;
    }

    public void setPrzeznaczenie(Przeznaczenie przeznaczenie) {
        this.przeznaczenie = przeznaczenie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypPojazdu)) return false;

        TypPojazdu that = (TypPojazdu) o;

        if (typNadwozia != that.typNadwozia) return false;
        return przeznaczenie == that.przeznaczenie;
    }

    @Override
    public int hashCode() {
        int result = typNadwozia != null ? typNadwozia.hashCode() : 0;
        result = 31 * result + (przeznaczenie != null ? przeznaczenie.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TypPojazdu{" +
                "typNadwozia=" + typNadwozia +
                ", przeznaczenie=" + przeznaczenie +
                '}';
    }
}

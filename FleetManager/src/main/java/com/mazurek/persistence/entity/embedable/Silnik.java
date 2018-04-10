package com.mazurek.persistence.entity.embedable;

import com.mazurek.persistence.entity.enumeration.TypSilnika;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Silnik {

    @Column(name = "TYP", nullable = false)
    private TypSilnika typ;

    @Column(name = "POJEMNOSC", nullable = true)
    private Integer pojemnosc;

    @Column(name = "MOC", nullable = false)
    private int moc;

    public TypSilnika getTyp() {
        return typ;
    }

    public void setTyp(TypSilnika typ) {
        this.typ = typ;
    }

    public Integer getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(Integer pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public int getMoc() {
        return moc;
    }

    public void setMoc(int moc) {
        this.moc = moc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Silnik)) return false;

        Silnik silnik = (Silnik) o;

        if (moc != silnik.moc) return false;
        if (typ != silnik.typ) return false;
        return pojemnosc != null ? pojemnosc.equals(silnik.pojemnosc) : silnik.pojemnosc == null;
    }

    @Override
    public int hashCode() {
        int result = typ != null ? typ.hashCode() : 0;
        result = 31 * result + (pojemnosc != null ? pojemnosc.hashCode() : 0);
        result = 31 * result + moc;
        return result;
    }

    @Override
    public String toString() {
        return "Silnik{" +
                "typ=" + typ +
                ", pojemnosc=" + pojemnosc +
                ", moc=" + moc +
                '}';
    }
}

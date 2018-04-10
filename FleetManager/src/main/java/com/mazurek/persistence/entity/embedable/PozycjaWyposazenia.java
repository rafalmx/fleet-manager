package com.mazurek.persistence.entity.embedable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class PozycjaWyposazenia {

    @Column(name = "OPIS", nullable = false, length = 128)
    private String opis;

    @Column(name = "WARTOSC", nullable = false)
    private BigDecimal wartosc;

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public BigDecimal getWartosc() {
        return wartosc;
    }

    public void setWartosc(BigDecimal wartosc) {
        this.wartosc = wartosc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PozycjaWyposazenia)) return false;

        PozycjaWyposazenia that = (PozycjaWyposazenia) o;

        if (opis != null ? !opis.equals(that.opis) : that.opis != null) return false;
        return wartosc != null ? wartosc.equals(that.wartosc) : that.wartosc == null;
    }

    @Override
    public int hashCode() {
        int result = opis != null ? opis.hashCode() : 0;
        result = 31 * result + (wartosc != null ? wartosc.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PozycjaWyposazenia{" +
                "opis='" + opis + '\'' +
                ", wartosc=" + wartosc +
                '}';
    }
}

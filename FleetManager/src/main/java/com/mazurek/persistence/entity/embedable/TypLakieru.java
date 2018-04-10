package com.mazurek.persistence.entity.embedable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TypLakieru {

    @Column(name = "KOLOR", nullable = false)
    private String kolor;

    @Column(name = "CZY_METALIK")
    private boolean czyMetalik;

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public boolean isCzyMetalik() {
        return czyMetalik;
    }

    public void setCzyMetalik(boolean czyMetalik) {
        this.czyMetalik = czyMetalik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypLakieru)) return false;

        TypLakieru that = (TypLakieru) o;

        if (czyMetalik != that.czyMetalik) return false;
        return kolor != null ? kolor.equals(that.kolor) : that.kolor == null;
    }

    @Override
    public int hashCode() {
        int result = kolor != null ? kolor.hashCode() : 0;
        result = 31 * result + (czyMetalik ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TypLakieru{" +
                "kolor='" + kolor + '\'' +
                ", czyMetalik=" + czyMetalik +
                '}';
    }
}

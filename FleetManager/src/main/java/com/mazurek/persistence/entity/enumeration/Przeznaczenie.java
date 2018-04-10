package com.mazurek.persistence.entity.enumeration;

public enum Przeznaczenie {

    osobowy("osobowy"),
    ciezarowy("ciężarowy"),
    rolniczy("rolniczy");

    private String przeznaczenie;

    Przeznaczenie(String przeznaczenie) {
        this.przeznaczenie = przeznaczenie;
    }

    public String getPrzeznaczenie() {
        return przeznaczenie;
    }

    public static Przeznaczenie valueOfString(String value){
        for(Przeznaczenie p : Przeznaczenie.values()) {
            if(p.getPrzeznaczenie().equals(value)){
                return p;
            }
        }
        return null;
    }
}
